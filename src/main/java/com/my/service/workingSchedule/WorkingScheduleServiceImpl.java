package com.my.service.workingSchedule;

import com.my.model.WorkingSchedule;
import com.my.repository.jpa.JpaWorkingScheduleRepository;
import com.my.repository.mongo.MongoWorkingScheduleRepository;
import com.my.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WorkingScheduleServiceImpl extends AbstractService<WorkingSchedule, Integer> implements WorkingScheduleService {
    public WorkingScheduleServiceImpl(JpaWorkingScheduleRepository jpaWorkingScheduleRepository,
                                      MongoWorkingScheduleRepository mongoWorkingScheduleRepository) {
        this.jpaRepository = jpaWorkingScheduleRepository;
        this.mongoRepository = mongoWorkingScheduleRepository;
    }

    @Override
    protected Page<WorkingSchedule> getSearch(String searchValue, Pageable pageable) {
        return null;
    }
}
