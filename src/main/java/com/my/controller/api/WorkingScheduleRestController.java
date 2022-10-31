package com.my.controller.api;

import com.my.model.WorkingSchedule;
import com.my.service.workingSchedule.WorkingScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/working-schedules")
public class WorkingScheduleRestController extends AbstractRestController<WorkingSchedule, Integer> {
    public WorkingScheduleRestController(WorkingScheduleService service) {
        this.service = service;
    }
}
