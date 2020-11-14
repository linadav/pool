package sda.JavaVilnius5.poolApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    Date dateStart;

    @Column
    Date dateStop;

    @Column
    String email;

    @Column
    private String personal_code;

}
