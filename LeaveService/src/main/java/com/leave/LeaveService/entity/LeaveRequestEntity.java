package com.leave.LeaveService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="LEAVE_REQUEST")
public class LeaveRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;

    private String leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer duration;

    private String reason;

    private String status;

    private String workflowInstanceId;

    private LocalDateTime createdAt;
}
