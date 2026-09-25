package com.leave.LeaveService.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LeaveBalanceWorker {

    private static final Long leaveBalance=10l;

    @JobWorker(type="check-leave-balance")
    public Map<String,Object> checkLeaveBalance(ActivatedJob job)
    {
        Map<String,Object> variables= job.getVariablesAsMap();
        Long leaveDays = (Long) variables.get("leaveDays");
        if(leaveBalance-leaveDays<=-1) {
            return Map.of("balanceAvailable", true);
        }

        return Map.of("balanceAvailable",false);
    }

}
