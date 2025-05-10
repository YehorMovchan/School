package ua.dnu.myv.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalTime;


@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_groups_schedule")
public class ViewGroupsSchedule {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "`group`")
    private String group;

    @Column(name = "leader_id")
    private Integer leaderId;

    @Column(name = "leader", nullable = false)
    private String leader;

    @Column(name = "price")
    private Double price;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

}