package sda.JavaVilnius5.poolApp.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "activities")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_activity;

    @Column
    String activityname;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "participant_activities",
            joinColumns = @JoinColumn(name = "id_activity"),
            inverseJoinColumns = @JoinColumn(name = "id_participant")
    )

    // @JsonIgnore
    private List<Participant> participants = new ArrayList<>();

}
