package sda.JavaVilnius5.poolApp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.Participant;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantsRepository extends CrudRepository<Participant, Long> {

//    @Query("SELECT p FROM Participant as p JOIN p.activities as a WHERE a.idactivity = :id")
//    List<Participant> findByIdactivityWithParticipants(@Param("idactivity") Long id);
    @Query("SELECT a FROM Activity as a JOIN a.participants as p WHERE p.idparticipant = ?1")
    List<Activity> findByIdparticipantWithActivities(Long idparticipant);
}
