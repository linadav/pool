package sda.JavaVilnius5.poolApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.JavaVilnius5.poolApp.models.Participant;

@Repository
public interface ParticipantsRepository extends CrudRepository<Participant, Long> {
}
