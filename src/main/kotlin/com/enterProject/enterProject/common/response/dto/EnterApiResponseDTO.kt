package com.enterProject.enterProject.common.response.dto

import com.enterProject.enterProject.common.response.constants.EnterResponseConstants
import java.io.Serializable

/**
 * 공통 응답 DTO
 */
data class EnterApiResponseDTO(
    var status: String = EnterResponseConstants.STATUS.SUCCESS.code,
    var message: String? = null,
    val data: Any? = null
): Serializable