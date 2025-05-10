package ua.dnu.myv.domain.view;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_staff")
public class ViewStaff {
    @Id
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

    @Column(name = "passport_copy")
    private byte[] passportCopy;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "teacher")
    private Boolean teacher;

}