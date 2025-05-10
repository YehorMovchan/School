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
@Table(name = "view_groups_type")
public class ViewGroupsType {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "leader_id")
    private Integer leaderId;

    @Column(name = "leader", nullable = false)
    private String leader;

    @Column(name = "price")
    private Integer price;

    @Lob
    @Column(name = "info")
    private String info;

}