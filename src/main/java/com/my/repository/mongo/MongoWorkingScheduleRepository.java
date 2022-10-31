package com.my.repository.mongo;

import com.my.model.WorkingSchedule;
import com.my.repository.basic.WorkingScheduleRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoWorkingScheduleRepository extends MongoRepository<WorkingSchedule, Integer>, WorkingScheduleRepository {
}
