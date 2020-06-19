package com.ipsoft.demo.managers;

import com.ipsoft.demo.exceptions.ServiceException;
import com.ipsoft.demo.models.Employees;
import com.ipsoft.demo.repositories.EmployeesRepository;
import com.ipsoft.demo.responses.BaseResponse;
import com.ipsoft.demo.responses.EmployeesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class DemoManager {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired

    public EmployeesResponse demoEndpointOneImpl(HttpServletRequest request) throws ServiceException {
        try {
            Employees savedEmp = employeesRepository.save(new Employees("Krishna",
                    "9988776655", "krish@ipsoft.com"));
            employeesRepository.save(savedEmp);
            return new EmployeesResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            // use a logger
            e.printStackTrace();
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
