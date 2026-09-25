package com.leave.LeaveService.repository;

import com.leave.LeaveService.entity.LeaveRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeaveRequestRepository extends JpaRepository<LeaveRequestEntity,Long> {

}
