package it.frogject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="frj_project")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="PRJ_ID", nullable = false)
    private  Long id;
    @Column(name="PRJ_COD", nullable = false,length = 5,unique = true)
    private String projectCode;
    @Column(name="PRJ_DESCRIPTION", nullable = false,length = 100)
    private String projectDescription;
    @Column(name="PRJ_DATE_PROD", nullable = false)
    private Date productionDate;
    @Column(name="PRJ_DATE_TESTING", nullable = false)
    private Date testingDate;
    @Column(name="PRJ_DATE_END_DEV", nullable = false)
    private Date developDueDate;
    @ManyToMany
    @JoinTable(name = "frj_project_resource",
            joinColumns = @JoinColumn(name = "RSC_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRJ_ID")
    )
    private List<Resource> resources;

}
