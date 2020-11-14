package sda.JavaVilnius5.poolApp.repositories;

import org.springframework.data.repository.CrudRepository;
import sda.JavaVilnius5.poolApp.models.Participant;

public interface ParticipantsRepository extends CrudRepository<Participant, Long> {
}
