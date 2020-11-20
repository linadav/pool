package sda.JavaVilnius5.poolApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.JavaVilnius5.poolApp.exeptions.ActivityNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.Participant;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;
import sda.JavaVilnius5.poolApp.services.ActivitiesService;
import sda.JavaVilnius5.poolApp.services.ParticipantsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activities")
public class ActivitiesRestController {
    @Autowired
    private ActivitiesService activitiesService;
    private ParticipantsService participantsService;

    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activitiesService.getAllActivities();
    }

    @GetMapping("/getactivity/{id}")
    public Activity getActivityById(@PathVariable Long id)throws ActivityNotFoundException {
      return activitiesService.getActivityById(id);
    }
    @GetMapping("/getparticipant/{idparticipant}/activities")
    List<Activity> getActivitiesByIdparticipant(@PathVariable Long idparticipant) {
        return activitiesService.getActivitiesByIdparticipant(idparticipant);
    }
    @DeleteMapping("/delete/{id}")
    List<Activity> deleteActivity(@PathVariable Long id) throws ActivityNotFoundException {
        return activitiesService.deleteActivity(id);
    }

    @PostMapping("/newactivity")
    List<Activity> newActivity (@RequestBody Activity activity) {
        return activitiesService.newActivity(activity);
    }

    @PutMapping("/activity/{id}")
    Activity updateActivityById(@PathVariable Long id, @RequestBody Activity activity) {
        return activitiesService.updateActivityById(id, activity);
    }
}
