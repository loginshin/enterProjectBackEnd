package com.enterProject.enterProject.common.response.exception;

import com.enterProject.enterProject.common.response.constants.EnterResponseConstants;
import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EnterApiResponseDTO> handleValidationException(MethodArgumentNotValidException e) {
        EnterApiResponseDTO response = new EnterApiResponseDTO();
        response.setStatus(EnterResponseConstants.STATUS.ERROR_FAIL.getCode());
        response.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<EnterApiResponseDTO> handleBadCredentialsException(BadCredentialsException e) {
        EnterApiResponseDTO response = new EnterApiResponseDTO();
        response.setStatus(EnterResponseConstants.STATUS.ERROR_FAIL.getCode());
        response.setMessage(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<EnterApiResponseDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        EnterApiResponseDTO response = new EnterApiResponseDTO();
        response.setStatus(EnterResponseConstants.STATUS.ERROR_FAIL.getCode());
        response.setMessage(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

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
