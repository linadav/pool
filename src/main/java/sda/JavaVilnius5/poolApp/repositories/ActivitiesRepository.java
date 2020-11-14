package sda.JavaVilnius5.poolApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.JavaVilnius5.poolApp.models.Activity;

import java.util.List;

@Repository
public interface ActivitiesRepository extends CrudRepository<Activity, Long> {

}
