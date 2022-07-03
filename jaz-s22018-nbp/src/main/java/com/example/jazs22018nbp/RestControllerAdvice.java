package com.example.jazs22018nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {


    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<String> HandlerRuntimeExecption(HttpClientErrorException exception) {
;
        switch (exception.getStatusCode()){
            case INTERNAL_SERVER_ERROR :
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception thorw: 500" );
            case  NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception thorw: 404" );
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thorw: 400" );
            case NO_CONTENT:
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Exception thorw: 599" );
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 502" );

    }

}
