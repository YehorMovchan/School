package ua.dnu.myv.domain.attendance;

import ua.dnu.myv.domain.Staff;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "staff_attendance")
public class StaffAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "staff")
    private Integer staff;

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

}