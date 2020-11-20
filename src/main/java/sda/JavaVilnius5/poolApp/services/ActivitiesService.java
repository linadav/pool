package sda.JavaVilnius5.poolApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sda.JavaVilnius5.poolApp.exeptions.ActivityNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.Participant;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;
import sda.JavaVilnius5.poolApp.repositories.ParticipantsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ActivitiesService {
    @Autowired
    private ActivitiesRepository activitiesRepository;
    private ParticipantsRepository participantsRepository;

    public List<Activity> getAllActivities() {
        return (List<Activity>) activitiesRepository.findAll();
    }

    public Activity getActivityById(@PathVariable Long idactivity) throws ActivityNotFoundException {
        Activity activity = activitiesRepository.findById(idactivity)
                .orElseThrow(() -> new ActivityNotFoundException(String.format("Activity with id %s not found",
                        idactivity)));
        return activity;
    }

    public List<Activity> getActivitiesByIdparticipant(@PathVariable Long idparticipant) {
        return new ArrayList<>(participantsRepository.findByIdparticipantWithActivities(idparticipant));
    }

    public List<Activity> deleteActivity(@PathVariable Long idactivity) throws ActivityNotFoundException {
        activitiesRepository.findById(idactivity)
                .orElseThrow(() -> new ActivityNotFoundException(String.format("Activity with id %s not found",
                        idactivity)));

        activitiesRepository.deleteById(idactivity);
        return new ArrayList<Activity>();
    }

    public List<Activity> newActivity(@RequestBody Activity activity) {
        return Collections.singletonList(activitiesRepository.save(activity));
    }

    public Activity updateActivityById(@PathVariable Long id, @RequestBody Activity activity) {
        activity.setIdactivity(id);
        return this.activitiesRepository.save(activity);
    }
}
