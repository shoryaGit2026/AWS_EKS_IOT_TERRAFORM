package com.leave.LeaveService.service;

import com.leave.LeaveService.dto.LeaveRequestDto;
import io.camunda.client.CamundaClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LeaveService {

    private final CamundaClient camundaClient;


    public LeaveService(CamundaClient camundaClient)
    {
        this.camundaClient=camundaClient;
    }

    public long leaveRequestProcess(LeaveRequestDto leaveRequestDto)
    {
        Map<String, Object> variables = Map.of(
                "employeeId", leaveRequestDto.employeeId(),
                "leaveType", leaveRequestDto.leaveType(),
                "startDate", leaveRequestDto.startDate().toString(),
                "endDate", leaveRequestDto.endDate().toString(),
                "leaveDays", leaveRequestDto,
                "reason", leaveRequestDto.reason()
        );

        var result = camundaClient.newCreateInstanceCommand()
                .bpmnProcessId("LEAVE_MANAGEMENT")
                .latestVersion().variables(variables).send().join();

        return result.getProcessDefinitionKey();
    }


}