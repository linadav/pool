package sda.JavaVilnius5.poolApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.JavaVilnius5.poolApp.exeptions.ParticipantNotFoundException;
import sda.JavaVilnius5.poolApp.models.Participant;
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
    public List<Participant> getAllParticipants() {
        return participantsService.getAllParticipants();
    }

    @GetMapping("/getparticipant/{id_participant}")
    public Participant getParticipantById(@PathVariable Long id_participant) throws ParticipantNotFoundException {
         return participantsService.getParticipantById(id_participant);
    }

    @DeleteMapping("/delete/{id_participant}")
    List<Participant> deleteParticipant(@PathVariable Long id_participant) throws ParticipantNotFoundException {
         return participantsService.deleteParticipant(id_participant);
    }

    @PostMapping("/newparticipant")
    List<Participant> postParticipant (@RequestBody Participant participant) {
        return participantsService.newParticipant(participant);
    }

    @PutMapping("/participant/{id}")
    Participant updateParticipantById(@PathVariable Long id, @RequestBody Participant participant) {
        return participantsService.updateParticipantById(id, participant);
    }

}
