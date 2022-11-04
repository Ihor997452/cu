package com.my.repository.jpa;

import com.my.model.WorkingSchedule;
import com.my.repository.basic.WorkingScheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWorkingScheduleRepository extends JpaRepository<WorkingSchedule, String>, WorkingScheduleRepository {
}
