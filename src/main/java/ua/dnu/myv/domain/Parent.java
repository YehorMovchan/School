package ua.dnu.myv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Byte sex;

    @Lob
    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "home_address")
    private String homeAddress;

}