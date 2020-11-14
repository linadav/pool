package sda.JavaVilnius5.poolApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sda.JavaVilnius5.poolApp.exeptions.ActivityNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ActivitiesService {
    @Autowired
    private ActivitiesRepository activitiesRepository;

    public List<Activity> getAllActivities() {
        return (List<Activity>) activitiesRepository.findAll();

    }

    public Activity getActivityById(Long id_activity) throws ActivityNotFoundException {
        Activity activity = activitiesRepository.findById(id_activity)
                .orElseThrow(() -> new ActivityNotFoundException(String.format("Activity with id %s not found",
                        id_activity)));
        return activity;
    }

    public List<Activity> deleteActivity(Long id_activity) throws ActivityNotFoundException {
        activitiesRepository.findById(id_activity)
                .orElseThrow(() -> new ActivityNotFoundException(String.format("Activity with id %s not found",
                        id_activity)));

        activitiesRepository.deleteById(id_activity);
        return new ArrayList<Activity>();
    }

    public List<Activity> newActivity(Activity activity) {
        return Collections.singletonList(activitiesRepository.save(activity));
    }

    public Activity updateActivityById(Long id, Activity activity) {
        activity.setId_activity(id);
        return this.activitiesRepository.save(activity);
    }
}
