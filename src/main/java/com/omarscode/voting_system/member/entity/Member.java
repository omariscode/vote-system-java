package com.omarscode.voting_system.member.entity;

import com.omarscode.voting_system.activity.entity.Activity;
import com.omarscode.voting_system.project.entity.Project;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String turma;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Project project;

    @Enumerated(EnumType.STRING)
    private ClassLevel classe;

    @Enumerated(EnumType.STRING)
    private Course course;

    public Member() {
    }
}
