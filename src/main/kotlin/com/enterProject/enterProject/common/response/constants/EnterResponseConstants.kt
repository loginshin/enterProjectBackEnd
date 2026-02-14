package com.enterProject.enterProject.common.response.constants

object EnterResponseConstants {
    enum class STATUS(val code: String) {
        SUCCESS("S-0000"),
        SUCCESS_EDIT("S-0001"),
        ERROR_FAIL("E-0000"),
        ERROR_DUPLICATE("E-0001");

        companion object {
            fun isSuccessCode(code: String): Boolean {
                return code[0] == 'S'
            }
        }
    }
}