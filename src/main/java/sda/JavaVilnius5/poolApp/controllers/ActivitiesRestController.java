package sda.JavaVilnius5.poolApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.JavaVilnius5.poolApp.exeptions.ActivityNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;
import sda.JavaVilnius5.poolApp.services.ActivitiesService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivitiesRestController {
    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activitiesService.getAllActivities();
    }

//    @DeleteMapping("/delete/{id}")
//    List<Activity> deleteActivity(@PathVariable Long id) {
//        activitiesRepository.deleteById(id);
//        return new ArrayList<>();
//    }

    @GetMapping("/getactivity/{id_activity}")
    public Activity getActivityById(@PathVariable Long id_activity)throws ActivityNotFoundException {
      return activitiesService.getActivityById(id_activity);
    }

    @DeleteMapping("/delete/{id_activity}")
    List<Activity> deleteActivity(@PathVariable Long id_activity) throws ActivityNotFoundException {
        return activitiesService.deleteActivity(id_activity);
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
