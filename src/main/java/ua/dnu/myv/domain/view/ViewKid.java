package ua.dnu.myv.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_kid")
public class ViewKid {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "birth_certificate")
    private byte[] birthCertificate;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "mother")
    private Integer mother;

    @Column(name = "father")
    private Integer father;

    @Column(name = "program_id", nullable = false)
    private Integer programId;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "school_included", nullable = false)
    private Boolean schoolIncluded = false;

}