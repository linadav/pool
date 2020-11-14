package sda.JavaVilnius5.poolApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//           first_name     VARCHAR(255),
//           last_name      VARCHAR(255),
//           dateStart      DATE,
//           dateStop       DATE,
//           email          VARCHAR(255),
//           id_participant INT);
@Entity
@Data
@Table(name = "participants")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Participant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_participant;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private Date date_start;

    @Column
    private Date date_stop;

    @Column
    private String email;

    @Column
    private String personal_code;

    @JsonBackReference
    @ManyToMany(mappedBy = "participants")
    private List<Activity> activities = new ArrayList<>();

}
