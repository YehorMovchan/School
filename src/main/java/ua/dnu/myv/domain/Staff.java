package ua.dnu.myv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "passport_number")
    private String passportNumber;

    @Lob
    @Column(name = "info")
    private String info;

    @Column(name = "passport_copy", columnDefinition = "LONGBLOB")
    private byte[] passportCopy;

    @Column(name = "teacher")
    private Boolean teacher;

}