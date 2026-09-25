package com.leave.LeaveService.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeductLeaveWorker {

   /* private final LeaveRepository leaveRepository;

    public DeductLeaveWorker(
            LeaveRepository leaveRepository) {

        this.leaveRepository = leaveRepository;
    }

    @JobWorker(type = "deduct-leave")
    public Map<String, Object> deductLeave(
            ActivatedJob job) {

        Map<String, Object> variables =
                job.getVariablesAsMap();

        Long leaveId =
                ((Number) variables.get("leaveId"))
                        .longValue();

        LeaveRequest leave =
                leaveRepository
                        .findById(leaveId)
                        .orElseThrow();

        leave.setStatus("COMPLETED");

        leaveRepository.save(leave);

        return Map.of(
                "leaveDeducted",
                true
        );
    }*/
}