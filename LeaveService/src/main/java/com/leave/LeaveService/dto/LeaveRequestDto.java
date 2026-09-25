package com.leave.LeaveService.dto;

import java.time.LocalDate;

public record LeaveRequestDto(

    String employeeId,
    String leaveType,
    LocalDate startDate,
    LocalDate endDate,
    String reason){


}