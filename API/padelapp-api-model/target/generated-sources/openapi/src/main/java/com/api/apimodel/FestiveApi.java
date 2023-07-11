/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api.apimodel;

import com.api.model.FestiveDTO;
import java.time.LocalDate;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")
@Validated
@Api(value = "festive", description = "the festive API")
public interface FestiveApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /festive/{date} : Get festive by id
     *
     * @param date date (required)
     * @return successful operation (status code 200)
     *         or Invalid festive id supplied (status code 400)
     *         or Festive not found (status code 404)
     */
    @ApiOperation(value = "Get festive by id", nickname = "getFestivebyDate", notes = "", response = FestiveDTO.class, tags={ "festive", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = FestiveDTO.class),
        @ApiResponse(code = 400, message = "Invalid festive id supplied"),
        @ApiResponse(code = 404, message = "Festive not found") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/festive/{date}",
        produces = { "application/json" }
    )
    default ResponseEntity<FestiveDTO> _getFestivebyDate(@ApiParam(value = "date", required = true) @PathVariable("date") LocalDate date) {
        return getFestivebyDate(date);
    }

    // Override this method
    default  ResponseEntity<FestiveDTO> getFestivebyDate(LocalDate date) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"Reconquista de Vigo\", \"festiveId\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /festive/{idfestive} : Get festive by id
     *
     * @param idfestive festive id (required)
     * @return successful operation (status code 200)
     *         or Invalid festive id supplied (status code 400)
     *         or Festive not found (status code 404)
     */
    @ApiOperation(value = "Get festive by id", nickname = "getFestivebyId", notes = "", response = FestiveDTO.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "festive", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = FestiveDTO.class),
        @ApiResponse(code = 400, message = "Invalid festive id supplied"),
        @ApiResponse(code = 404, message = "Festive not found") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/festive/{idfestive}",
        produces = { "application/json" }
    )
    default ResponseEntity<FestiveDTO> _getFestivebyId(@ApiParam(value = "festive id", required = true) @PathVariable("idfestive") Integer idfestive) {
        return getFestivebyId(idfestive);
    }

    // Override this method
    default  ResponseEntity<FestiveDTO> getFestivebyId(Integer idfestive) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"Reconquista de Vigo\", \"festiveId\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}