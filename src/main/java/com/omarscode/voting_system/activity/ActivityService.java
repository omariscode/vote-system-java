package com.omarscode.voting_system.activity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.omarscode.voting_system.activity.dto.CreateActivityDTO;
import com.omarscode.voting_system.activity.entity.Activity;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    public Activity getActivity(Long id){
        return activityRepository.findById(id).orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public Activity createActivity(CreateActivityDTO dto){
        if (dto.name().isBlank() || dto.description().isBlank() || dto.startDate() == null || dto.endDate() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Every a field must be filled");
        }

        if (dto.startDate().isAfter(dto.endDate())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Start date must not be after or greater than the end date");
        }

        Activity activity = new Activity(
            dto.name(),
            dto.description(),
            dto.finished(),
            dto.startDate(),
            dto.endDate()
        );

        return activityRepository.save(activity);
    }
    
}
