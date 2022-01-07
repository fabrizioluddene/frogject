package it.frogject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="FRJ_RESOURCES")
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RSC_ID", nullable = false,unique = true)
    private  Long id;
    @Column(name="PRJ_NAME", nullable = false,length = 100)
    private String name;
    @Column(name="PRJ_SURNAME", nullable = false,length = 100)
    private String surname;

}
