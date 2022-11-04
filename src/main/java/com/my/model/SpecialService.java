package com.my.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "special_services")
@Document(collection = "special_services")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String phoneNumber;
}
