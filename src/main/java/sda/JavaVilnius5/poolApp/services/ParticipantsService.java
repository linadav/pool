package sda.JavaVilnius5.poolApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sda.JavaVilnius5.poolApp.exeptions.ParticipantNotFoundException;
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

    public List<Participant> getAllParticipants(){
        return (List<Participant>) participantsRepository.findAll();

    }

    public Participant getParticipantById(Long id_participant) throws ParticipantNotFoundException {
        Participant participant = participantsRepository.findById(id_participant)
                .orElseThrow(() -> new ParticipantNotFoundException(String.format("Participant with id %s not found",
                        id_participant)));
        return participant;
    }

    public List<Participant> deleteParticipant(Long id_participant) throws ParticipantNotFoundException {
        participantsRepository.findById(id_participant)
                .orElseThrow(() -> new ParticipantNotFoundException(String.format("Participant with id %s not found",
                        id_participant)));

        participantsRepository.deleteById(id_participant);
        return new ArrayList<Participant>();
    }

    public List<Participant> newParticipant (Participant participant) {
        return Collections.singletonList(participantsRepository.save(participant));
    }

   public Participant updateParticipantById(Long id, Participant participant) {
        participant.setId_participant(id);
        return this.participantsRepository.save(participant);
    }
}
