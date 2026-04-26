package com.omarscode.voting_system.activity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omarscode.voting_system.activity.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    
}