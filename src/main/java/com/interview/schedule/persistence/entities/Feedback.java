package com.interview.schedule.persistence.entities;


import com.interview.schedule.enums.InterviewStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;
    @OneToOne
    @JoinColumn(name = "interview_id",referencedColumnName = "id")
    private Interview interview;
    @Enumerated(EnumType.STRING)
    private InterviewStatus status;
    private String remarks;
    private Integer rating;
}
