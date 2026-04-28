package com.omarscode.voting_system.vote.entity;

import com.omarscode.voting_system.voter.entity.Voter;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vote {
    
    @Id
    @GeneratedValue
    private Long id;

    private Long targetId;

    @Enumerated(EnumType.STRING)
    private VoteTargetType type;

    @ManyToOne
    private Voter vote;

    public Vote() {
    }
}
