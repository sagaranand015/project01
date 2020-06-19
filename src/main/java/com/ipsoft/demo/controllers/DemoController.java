package com.ipsoft.demo.controllers;

import com.ipsoft.demo.exceptions.ServiceException;
import com.ipsoft.demo.managers.DemoManager;
import com.ipsoft.demo.responses.BaseResponse;
import com.ipsoft.demo.responses.EmployeesResponse;
import javafx.concurrent.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    // add a logger

    @Autowired
    private DemoManager demoManager;

    @RequestMapping(method = RequestMethod.GET, value = "/v1/api/employee/add")
    public ResponseEntity<EmployeesResponse> demoEndpointOne(HttpServletRequest request) {
        try {
            EmployeesResponse resp = demoManager.demoEndpointOneImpl(request);
            return ResponseEntity.status(resp.getStatus()).body(resp);
        } catch (ServiceException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new EmployeesResponse(HttpStatus.BAD_GATEWAY.value(),
                    HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

}
