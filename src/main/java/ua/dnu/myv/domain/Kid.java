package ua.dnu.myv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "kids")
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Lob
    @Column(name = "birth_certificate", columnDefinition = "LONGBLOB")
    private byte[] birthCertificate;

    @Column(name = "grade")
    private Integer grade;

    @JoinColumn(name = "mother")
    private Long mother;

    @JoinColumn(name = "father")
    private Long father;

}