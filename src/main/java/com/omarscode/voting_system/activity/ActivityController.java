package com.omarscode.voting_system.activity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omarscode.voting_system.activity.entity.Activity;

@RestController
@RequestMapping("activities")
public class ActivityController {
    private final ActivityRepository activityRepository;
    private final ActivityService activityService;
    
    ActivityController(ActivityService activityService, ActivityRepository activityRepository) {
        this.activityService = activityService;
        this.activityRepository = activityRepository;
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

    @GetMapping("{id")
    public Activity geActivity(@PathVariable Long id){
        return activityService.getActivity(id);
    }

    @PostMapping
    public void createActivity(@RequestBody Activity activity){
        activityRepository.save(activity);
    }
}
