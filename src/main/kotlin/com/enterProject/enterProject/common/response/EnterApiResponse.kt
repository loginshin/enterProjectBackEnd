package com.enterProject.enterProject.common.response

import com.enterProject.enterProject.common.response.dto.EnterApiResponseDTO
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class EnterApiResponse {

    companion object {
        private fun setHeader(): HttpHeaders {
            val headers = HttpHeaders()
            headers.date = System.currentTimeMillis()
            return headers
        }

        /**
         * Response [isSuccess]
         */
        fun response(isSuccess: Boolean): ResponseEntity<EnterApiResponseDTO> {
            val httpStatus = if (isSuccess) HttpStatus.OK else HttpStatus.INTERNAL_SERVER_ERROR
            val response = EnterApiResponseDTO()
            return ResponseEntity(response, this.setHeader(), httpStatus)
        }

        /**
         * Response [data]
         */
        fun response(data: Any?): ResponseEntity<EnterApiResponseDTO> {
            val response = EnterApiResponseDTO(
                data = data
            )
            return ResponseEntity(response, this.setHeader(), HttpStatus.OK)
        }

        /**
         * Response [response]
         */
        fun response(response: EnterApiResponseDTO): ResponseEntity<EnterApiResponseDTO> {
            return ResponseEntity(response, this.setHeader(), HttpStatus.OK)
        }

        /**
         * Response [httpstatus, data]
         */

    }

}
