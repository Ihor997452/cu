package com.my.model;

import com.my.model.enums.Days;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "working_schedule")
@Document(collection = "working_schedule")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SpecialService specialService;

    @Enumerated(EnumType.STRING)
    private Days dayOfWeek;

    private Time startTime;
    private Time endTime;
}
