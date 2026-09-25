package com.leave.LeaveService.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmployeeValidationWorker {

    @JobWorker(type="employee-validation")
    public Map<String,Object> validateEmployee(ActivatedJob job)
    {
        Map<String,Object> variables=job.getVariablesAsMap();
        String employeeId = (String) variables.get("employeeId");
        boolean valid = employeeId!=null;
        return Map.of("employeeValid",valid);
    }
}
