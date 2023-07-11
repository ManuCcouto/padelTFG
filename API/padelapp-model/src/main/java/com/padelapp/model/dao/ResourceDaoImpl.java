package com.padelapp.model.dao;




import com.padelapp.dao.ResourceDao;
import com.padelapp.entities.Resource;

import com.padelapp.repository.ResourceRepository;
import com.padelapp.utils.Interval;
import com.padelapp.utils.IntervalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Repository
public class ResourceDaoImpl implements ResourceDao {
  @Autowired
  private ResourceRepository resourceRepository;

    private static final Logger logger = LoggerFactory.getLogger(ResourceDaoImpl.class);


    public Map<LocalDateTime, List<Resource>> findAvailableResourcesByTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Map<LocalDateTime, List<Resource>> availableResourcesByTime = new LinkedHashMap<>();

        while (startDateTime.isBefore(endDateTime)) {
            LocalDateTime endDateTimeSlot = startDateTime.plusMinutes(90); // duración predeterminada de la franja horaria
            List<Resource> availableResources = resourceRepository.findAvailableResourcesByTimeSlot(
                    startDateTime,
                    endDateTimeSlot
            );
            List<Resource> filteredResources = new ArrayList<>();
            for (Resource resource : availableResources) {
                if (resource.getStartTimeSlot().isBefore(startDateTime.toLocalTime()) || resource.getEndTimeSlot().isAfter(endDateTime.toLocalTime())) {
                    logger.info("condicion reciurso  comienzo"+ resource.getStartTimeSlot()+ " hora introducida " + startDateTime.toLocalTime());
                    logger.info("condicion reciurso  fin"+ resource.getEndTimeSlot()+ " hora introducida " + endDateTime.toLocalTime());
                    continue;
                }
                logger.info("se añade recuerso  "+ resource+ " hora inicio " + startDateTime);
                filteredResources.add(resource);
            }

            availableResourcesByTime.put(startDateTime, filteredResources);
            logger.info("rango   "+ filteredResources+ " hora inicio " + startDateTime);
            startDateTime = endDateTimeSlot;
        }

        return availableResourcesByTime;
    }

    @Override
    public   Map<Interval, List<Resource>> findAllResources(){
        List<Resource> resources = this.resourceRepository.findAll();
        logger.info("RfindAllRecursos "+ resources);
        Map<Interval, List<Resource>> availabilityMap = new HashMap<>();

        for (Resource resource : resources) {
            LocalTime startTime = resource.getStartTimeSlot();
            LocalTime endTime = resource.getEndTimeSlot();
            int timeSlot = resource.getTimeSlot();
            logger.info("en el for  "+ resource);
            while (startTime.isBefore(endTime)) {
                logger.info("en el while   "+ startTime+ " " + endTime);
                // Verificar que la franja horaria no se extienda más allá del tiempo de cierre
                LocalTime timeSlotEnd = startTime.plusMinutes(timeSlot);
                if (timeSlotEnd.isAfter(endTime)) {
                    timeSlotEnd = endTime;
                }

                // Crear intervalo con las horas de inicio y fin
                Interval interval = new Interval(startTime, timeSlotEnd);

                // Agregar el recurso a la lista correspondiente al intervalo
                List<Resource> resourceList = availabilityMap.getOrDefault(interval, new ArrayList<>());
                resourceList.add(resource);
                availabilityMap.put(interval, resourceList);

                // Avanzar al siguiente intervalo de tiempo
                startTime = timeSlotEnd;
                if (startTime.isBefore(resource.getStartTimeSlot())) {
                    break;
                }
            }
        }
        logger.info("Recursos que se puedes reservar sin ver aun en reservas "+ availabilityMap);
            return availabilityMap;

    }
    @Override
    public  Map<IntervalDateTime, List<Resource>> mapToIntervalDate(LocalDate date, Map<Interval, List<Resource>> availabilityResources) {
        Map<IntervalDateTime, List<Resource>> availabilityMapWithDateTime = new HashMap<>();
        for (Map.Entry<Interval, List<Resource>> entry : availabilityResources.entrySet()) {
            Interval interval = entry.getKey();
            List<Resource> resources = entry.getValue();


            IntervalDateTime intervalDateTime = interval.toIntervalDateTime(date);

            availabilityMapWithDateTime.put(intervalDateTime, resources);
        }
        return availabilityMapWithDateTime;
    }

    public  Map<IntervalDateTime, List<Resource>> getPosibleResources(   LocalDate date,  Map<Interval, List<Resource>> availabilityResources) {
        return mapToIntervalDate(date,findAllResources());

    }
}
