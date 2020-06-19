package com.ipsoft.demo.responses;

import lombok.Data;

@Data
public class BaseResponse {

    private int status;

    private String message;

    public BaseResponse() {
        super();
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
