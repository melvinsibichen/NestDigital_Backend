package com.example.NestDigitalApp.dao;

import com.example.NestDigitalApp.model.LeaveModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel, Integer> {

    @Query(value = "SELECT l.`id`, l.`apply_date`, e.emp_code, e.id AS empId, e.name, l.`from_date`, l.`leave_status`, l.`remarks`, l.`to_date`, l.`leave_type` FROM `leave2` AS l JOIN `employee` AS e ON e.id = l.emp_id", nativeQuery = true)
    List<Map<String, String>> GetAllLeaves();

    @Query(value = "SELECT `id`, `apply_date`, `emp_id`, `from_date`, `leave_status`, `leave_type`, `remarks`, `to_date` FROM `leave2` WHERE `emp_id`= :id", nativeQuery = true)
    List<LeaveModel> GetEmployeeLeaves(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave2` SET `leave_status`= :status WHERE `id`= :id", nativeQuery = true)
    void UpdateLeaves(@Param("id") int id, @Param("status") int status);


}