package com.interview.schedule.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Column(name = "emailId" ,unique = true,nullable = false)
    private String email;
    private String mobile;
    private Integer ctc;
    private Integer ectc;
    private String Location;
    private String notice;
    private String resumeUrl;
}
