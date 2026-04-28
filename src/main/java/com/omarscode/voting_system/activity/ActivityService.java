package com.omarscode.voting_system.activity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.omarscode.voting_system.activity.dto.ActivityResponseDTO;
import com.omarscode.voting_system.activity.dto.CreateActivityDTO;
import com.omarscode.voting_system.activity.entity.Activity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<ActivityResponseDTO> getActivities(){
        return activityRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    public ActivityResponseDTO getActivity(Long id){
        Activity activity = activityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        return toResponse(activity);
    }

    public void deleteActivity(Long id){
        Activity activity = activityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityRepository.delete(activity);
    }

    public ActivityResponseDTO changeActivityStatus(Long id){
        Activity activity = activityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activity.setFinished(!activity.isFinished());
        Activity updated = activityRepository.save(activity);
        return toResponse(updated);
    }

    public ActivityResponseDTO createActivity(CreateActivityDTO dto){
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

        Activity saved = activityRepository.save(activity);

        return toResponse(saved);
    }

    private ActivityResponseDTO toResponse(Activity activity) {
        return new ActivityResponseDTO(
            activity.getId(),
            activity.getName(),
            activity.getDescription(),
            activity.isFinished(),
            activity.getStartDate(),
            activity.getEndDate()
        );
    }
}
