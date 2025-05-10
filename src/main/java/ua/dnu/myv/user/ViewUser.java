package ua.dnu.myv.user;

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
@Table(name = "view_users")
public class ViewUser {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "info")
    private String info;

    @Column(name = "teacher")
    private Boolean teacher;

}