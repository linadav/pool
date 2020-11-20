package sda.JavaVilnius5.poolApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

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
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_participant")
    private Long idparticipant;

//    @Column(name = "first_name")
    @Column
    private String firstname;

//    @Column(name = "last_name")
    @Column
    private String lastname;

//    @Column(name = "date_start")
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datestart;

//    @Column(name = "date_stop")
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datestop;

    @Column
    private String email;

    //    @Column (name = "personal_code")
    @Column
    private String personalcode;

    @JsonBackReference
    @ManyToMany(mappedBy = "participants", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Activity> activities = new ArrayList<>();

}

