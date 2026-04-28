package com.omarscode.voting_system.activity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omarscode.voting_system.activity.dto.ActivityResponseDTO;
import com.omarscode.voting_system.activity.dto.CreateActivityDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("activities")
public class ActivityController {

    private final ActivityService activityService;
    
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityResponseDTO> getActivities() {
        return activityService.getActivitiesDTO();
    }

    @GetMapping("{id}")
    public ActivityResponseDTO getActivity(@PathVariable Long id){
        return activityService.getActivityDTO(id);
    }

    @DeleteMapping("{id}")
    public String deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
        return "Activity deleted with sucess";
    }

    @PatchMapping("{id}/change")
    public ActivityResponseDTO ActivityStatus(@PathVariable Long id){
        return activityService.changeActivityStatus(id);
    }

    @PostMapping
    public ActivityResponseDTO createActivity(@Valid @RequestBody CreateActivityDTO dto){
        return activityService.createActivity(dto);
    }
}
