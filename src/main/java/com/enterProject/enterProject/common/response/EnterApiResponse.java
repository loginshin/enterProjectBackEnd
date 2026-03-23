package com.enterProject.enterProject.common.response;

import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EnterApiResponse {

    private static HttpHeaders setHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setDate(System.currentTimeMillis());
        return headers;
    }

    /**
     * Response [isSuccess]
     */
    public static ResponseEntity<EnterApiResponseDTO> response(boolean isSuccess) {
        HttpStatus httpStatus = isSuccess ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        EnterApiResponseDTO response = new EnterApiResponseDTO();
        return new ResponseEntity<>(response, setHeader(), httpStatus);
    }

    /**
     * Response [data]
     */
    public static ResponseEntity<EnterApiResponseDTO> response(Object data) {
        EnterApiResponseDTO response = new EnterApiResponseDTO(data);
        return new ResponseEntity<>(response, setHeader(), HttpStatus.OK);
    }

    /**
     * Response [response]
     */
    public static ResponseEntity<EnterApiResponseDTO> response(EnterApiResponseDTO response) {
        return new ResponseEntity<>(response, setHeader(), HttpStatus.OK);
    }
}
