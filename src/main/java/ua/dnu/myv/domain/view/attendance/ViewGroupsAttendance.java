package ua.dnu.myv.domain.view.attendance;

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
@Table(name = "view_groups_attendance")
public class ViewGroupsAttendance {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "kid_id")
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "date")
    private LocalDate date;

}