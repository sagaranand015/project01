package com.ipsoft.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String employeeId;

    @Column(name = "employeeName", columnDefinition = "TEXT")
    private String employeeName;

    @Column(name = "employeePhone", columnDefinition = "TEXT")
    private String employeePhone;

    @Column(name = "employeeEmail", columnDefinition = "TEXT")
    private String employeeEmail;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+05:30")
    private Timestamp createdOn;

    @CreationTimestamp
    @Column(updatable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+05:30")
    private Timestamp lastUpdatedOn;

    public Employees(String employeeName, String employeePhone, String employeeEmail) {
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
    }
}
