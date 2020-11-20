package sda.JavaVilnius5.poolApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sda.JavaVilnius5.poolApp.exeptions.ActivityNotFoundException;
import sda.JavaVilnius5.poolApp.exeptions.ParticipantNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.Participant;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;
import sda.JavaVilnius5.poolApp.repositories.ParticipantsRepository;
import sda.JavaVilnius5.poolApp.services.ParticipantsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantsRestController {

    @Autowired
    private ParticipantsService participantsService;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Participant> getAllParticipants() {
        return participantsService.getAllParticipants();
    }

//    @RequestMapping(value = "/newparticipant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/newparticipant")
    List<Participant> addNewParticipant(@RequestBody Participant participant) {
        // Participant addNewParticipant (@RequestBody Participant participant) {
        return participantsService.addParticipant(participant);
    }
    @GetMapping("/getactivity/{idactivity}/participants")
    List<Participant> getParticipantsByIdactivity(@PathVariable Long idactivity){
              return participantsService.getParticipantsbyIdactivity(idactivity);
    }

    @GetMapping("/getparticipant/{id}")
    public Participant getParticipantById(@PathVariable Long id) throws ParticipantNotFoundException {
        return participantsService.getParticipantById(id);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    List<Participant> deleteParticipant(@PathVariable Long id) throws ParticipantNotFoundException {
        return participantsService.deleteParticipant(id);
    }

    @DeleteMapping("/delete/all")
    @CrossOrigin(origins = "http://localhost:4200")
    List<Participant> deleteAllParticipants() {
        return participantsService.deleteAllParticipants();
    }

    @PutMapping("/participant/{id}")
    Participant updateParticipantById(@PathVariable Long id, @RequestBody Participant participant) {
        return participantsService.updateParticipantById(id, participant);
    }

}
