package com.enterProject.enterProject.common.response.dto;

import com.enterProject.enterProject.common.response.constants.EnterResponseConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 공통 응답 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterApiResponseDTO implements Serializable {
    private String status = EnterResponseConstants.STATUS.SUCCESS.getCode();
    private String message = null;
    private Object data = null;

    public EnterApiResponseDTO(Object data) {
        this.data = data;
    }
}
