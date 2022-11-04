package com.my.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "mobile_operators")
@Document(collection = "mobile_operators")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String hotline;
    private String email;
    private String website;
}
