package ua.dnu.myv.domain.view;

import jakarta.persistence.*;
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
@Table(name = "view_groups")
public class ViewGroup {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "kid_id")
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Lob
    @Column(name = "reason_of_change")
    private String reasonOfChange;

}