package com.leave.LeaveService.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderWorker {

    @JobWorker(type="order-worker")
    public Map<String,Object> placeOrder()
    {
        System.out.println("order working executed");
       return Map.of("orderId","ITEM0012026");
    }

    @JobWorker(type="payment-worker")
    public void getOrderId (ActivatedJob job)
    {
        Map<String,Object> variables=job.getVariablesAsMap();
        System.out.println((String)variables.get("orderId"));
    }
}
