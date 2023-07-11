package com.padelapp;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringJoiner;


import com.padelapp.exception.AuthenticateException;
import com.padelapp.model.exception.ForbiddenException;
import com.padelapp.model.exception.ResourceFoundException;
import com.padelapp.model.exception.ResourceNotFoundException;
import com.padelapp.model.utils.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import  com.api.model.RestErrorDTO;

@ControllerAdvice
public class ExceptionHandlerController {

  public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
      .ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

  @Autowired
  private LocalDateTimeUtils localDateTimeUtils;

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<RestErrorDTO> resourceNotFoundException(final ResourceNotFoundException ex,
      final WebRequest request) {
    return this.generateResponseEntity(ex, request, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(AuthenticateException.class)
  public ResponseEntity<RestErrorDTO> authenticateException(final AuthenticateException ex,
                                                                final WebRequest request) {
    return this.generateResponseEntity(ex, request, HttpStatus.UNAUTHORIZED);
  }
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<RestErrorDTO> illegalArgumentException(final IllegalArgumentException ex,
      final WebRequest request) {
    return this.generateResponseEntity(ex, request, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ResourceFoundException.class)
  public ResponseEntity<RestErrorDTO> resourceFoundException(final ResourceFoundException ex,
      final WebRequest request) {
    return this.generateResponseEntity(ex, request, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<RestErrorDTO> forbiddenException(final ResourceFoundException ex,
      final WebRequest request) {
    return this.generateResponseEntity(ex, request, HttpStatus.CONFLICT);
  }

  private ResponseEntity<RestErrorDTO> generateResponseEntity(final RuntimeException ex,
      final WebRequest request,
      final HttpStatus httpStatus) {
    final RestErrorDTO message = new RestErrorDTO();
    message.setStatus(httpStatus.value());
    message.setTitle(ex.getMessage());
    message.setDetail(request.getDescription(false));
    message
        .setTimestamp(this.localDateTimeUtils.now(null).atZone(ZoneId.systemDefault()).format(DATE_TIME_FORMATTER));
    return new ResponseEntity<>(message, httpStatus);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  RestErrorDTO methodArgumentNotValidException(final MethodArgumentNotValidException e) {
    final RestErrorDTO message = new com.api.model.RestErrorDTO();
    message.setStatus(HttpStatus.BAD_REQUEST.value());
    message.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
    final StringJoiner stringJoiner = new StringJoiner(". ", "", ".");
    e.getFieldErrors().stream().sorted(Comparator.comparing(FieldError::getField))
        .forEach(fieldError -> stringJoiner.add(fieldError.getField() + " " + fieldError.getDefaultMessage()));
    message.setDetail(stringJoiner.toString());
    message.setTimestamp(this.localDateTimeUtils.now(null).atZone(ZoneId.systemDefault()).format(DATE_TIME_FORMATTER));
    return message;
  }

}
