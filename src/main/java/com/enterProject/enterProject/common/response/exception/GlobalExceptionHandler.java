package com.enterProject.enterProject.common.response.exception;

import com.enterProject.enterProject.common.response.constants.EnterResponseConstants;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<EnterApiResponseDTO> handleRuntimeException(RuntimeException e) {
        EnterApiResponseDTO response = new EnterApiResponseDTO();
        response.setStatus(EnterResponseConstants.STATUS.ERROR_FAIL.getCode());
        response.setMessage(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 최상위 예외
     *  - 다른 예외에서 처리되지 않으면 Exception에서 처리
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EnterApiResponseDTO> handleException(Exception e) {
        EnterApiResponseDTO response = new EnterApiResponseDTO();
        response.setStatus(EnterResponseConstants.STATUS.ERROR_FAIL.getCode());
        response.setMessage("Internal Server Error");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
