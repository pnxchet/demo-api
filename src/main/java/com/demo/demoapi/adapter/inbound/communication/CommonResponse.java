package com.demo.demoapi.adapter.inbound.communication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse {

    @JsonProperty("code")
    private final int code;

    @JsonProperty("message")
    private final String message;

    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
