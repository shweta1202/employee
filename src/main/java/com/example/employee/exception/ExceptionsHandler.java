package com.example.employee.exception;

import com.example.employee.dto.ResponseMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public ResponseEntity<ResponseMessageDto> badRequestException(HttpServletRequest request, Exception e) {
        return new ResponseEntity<>(new ResponseMessageDto(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InternalServerErrorException.class})
    @ResponseBody
    public ResponseEntity<ResponseMessageDto> internalServerErrorException(HttpServletRequest request, Exception e) {
        return new ResponseEntity<>(new ResponseMessageDto(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
