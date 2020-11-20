package sda.JavaVilnius5.poolApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sda.JavaVilnius5.poolApp.exeptions.ParticipantNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.Participant;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;
import sda.JavaVilnius5.poolApp.repositories.ParticipantsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ParticipantsService {
    @Autowired
    private ParticipantsRepository participantsRepository;
    private ActivitiesRepository activitiesRepository;

    public List<Participant> getAllParticipants() {
        return (List<Participant>) participantsRepository.findAll();
    }

    public List<Participant> getParticipantsbyIdactivity(@PathVariable Long idactivity) {
       return new ArrayList<>(activitiesRepository.findByIdactivityWithParticipants(idactivity));
    }

    public Participant getParticipantById(@PathVariable Long idparticipant) throws ParticipantNotFoundException {
        Participant participant = participantsRepository.findById(idparticipant)
                .orElseThrow(() -> new ParticipantNotFoundException(String.format("Participant with id %s not found",
                        idparticipant)));
        return participant;
    }

    public List<Participant> deleteParticipant(@PathVariable Long idparticipant) throws ParticipantNotFoundException {
        participantsRepository.findById(idparticipant)
                .orElseThrow(() -> new ParticipantNotFoundException(String.format("Participant with id %s not found",
                        idparticipant)));

        participantsRepository.deleteById(idparticipant);
        return new ArrayList<Participant>();
    }

    public List<Participant> addParticipant(@RequestBody Participant participant) {
    return Collections.singletonList(participantsRepository.save(participant));
//        return participantsRepository.save(participant);
    }

    public Participant updateParticipantById(@PathVariable Long idparticipant, @RequestBody Participant participant) {
        participant.setIdparticipant(idparticipant);
        return this.participantsRepository.save(participant);
    }

    public List<Participant> deleteAllParticipants() {
        this.participantsRepository.deleteAll();
        return new ArrayList<Participant>();
    }
}
