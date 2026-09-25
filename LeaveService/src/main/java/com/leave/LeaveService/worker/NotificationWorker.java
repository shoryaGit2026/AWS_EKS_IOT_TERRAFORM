package com.leave.LeaveService.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationWorker {

    @JobWorker(type="send-leave-notification")
    public void sendNotification(ActivatedJob job)
    {
        Map<String,Object> variables=job.getVariablesAsMap();
        variables.forEach((k,v)->{
            System.out.println("key: "+k+" : "+ v);
        });

    }
}
