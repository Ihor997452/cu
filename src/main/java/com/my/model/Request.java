package com.my.model;

import com.my.model.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "requests")
@Document(collection = "requests")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RequestType requestType;

    @DBRef
    @ManyToOne
    private Subscriber subscriber;

    private String description;
}
