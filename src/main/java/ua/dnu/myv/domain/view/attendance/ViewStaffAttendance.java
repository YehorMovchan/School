package ua.dnu.myv.domain.view.attendance;

import jakarta.persistence.*;
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
@Table(name = "view_staff_attendance")
public class ViewStaffAttendance {
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "staff_name", nullable = false)
    private String staffName;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start")
    private LocalTime start;

    @Column(name = "end")
    private LocalTime end;

    @Column(name = "breaktime_from")
    private LocalTime breaktimeFrom;

    @Column(name = "breaktime_to")
    private LocalTime breaktimeTo;

    @Lob
    @Column(name = "info")
    private String info;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}