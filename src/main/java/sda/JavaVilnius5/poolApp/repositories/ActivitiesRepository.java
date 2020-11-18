package sda.JavaVilnius5.poolApp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.Participant;

import java.util.List;

@Repository
public interface ActivitiesRepository extends CrudRepository<Activity, Long> {

 @Query("SELECT p FROM Participant as p JOIN p.activities as a WHERE a.idactivity = ?1")
     List<Participant> findByIdactivityWithParticipants(Long idactivity);

/// PVZ>:
// http://stackoverflow.com/questions/50471162/spring-data-jpa-using-query-with-many-to-many-relationships-join-table
//    @Transactional(readOnly = true)
//    @Query("SELECT u FROM OAuthUser as u JOIN u.roles as r WHERE r.id = ?1

//    @Query("SELECT activity FROM Activity activities left join fetch activity.participants WHERE activity
//    .idactivity =:id")
//    Optional<Activity> findByIdWithParticipants(@Param("id") Long id);
}
