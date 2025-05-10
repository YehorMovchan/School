package ua.dnu.myv.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_groups_kid_schedule")
public class ViewGroupsKidSchedule {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "leader_id", nullable = false)
    private Integer leaderId;

    @Column(name = "leader_name", nullable = false)
    private String leaderName;

    @Column(name = "kid_id", nullable = false)
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

}