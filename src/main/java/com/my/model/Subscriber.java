package com.my.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "subscribers")
@Document(collection = "subscribers")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phoneNumber;
    private String name;
    private String lastName;
    private String patronymic;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;
    private int postCode;

    @DBRef
    @ManyToOne
    private MobileOperator operator;
}
