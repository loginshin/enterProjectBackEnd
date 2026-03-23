package com.enterProject.enterProject.common.response.constants;

public class EnterResponseConstants {
    public enum STATUS {
        SUCCESS("S-0000"),
        SUCCESS_EDIT("S-0001"),
        ERROR_FAIL("E-0000"),
        ERROR_DUPLICATE("E-0001");

        private final String code;

        STATUS(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
