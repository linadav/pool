package sda.JavaVilnius5.poolApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//           first_name     VARCHAR(255),
//           last_name      VARCHAR(255),
//           email          VARCHAR(255),
//           id_participant INT);
@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_participant")
    @JsonBackReference
    private Participant participant;


}
