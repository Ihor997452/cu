package com.my.controller.api;

import com.my.model.SpecialService;
import com.my.model.WorkingSchedule;
import com.my.model.enums.Days;
import com.my.service.workingSchedule.WorkingScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/workingSchedules")
public class WorkingScheduleRestController extends AbstractRestController<WorkingSchedule, String> {
    public WorkingScheduleRestController(WorkingScheduleService service) {
        this.service = service;
    }

    @Override
    public WorkingSchedule getPrototype() {
        WorkingSchedule workingSchedule = new WorkingSchedule();
        workingSchedule.setId("0");
        workingSchedule.setEndTime(LocalTime.now());
        workingSchedule.setStartTime(LocalTime.now());
        workingSchedule.setDayOfWeek(Days.FRIDAY);

        SpecialService specialService = new SpecialService();
        specialService.setPhoneNumber("0");
        specialService.setId("0");
        specialService.setName("0");

        workingSchedule.setSpecialService(specialService);

        return workingSchedule;
    }
}
