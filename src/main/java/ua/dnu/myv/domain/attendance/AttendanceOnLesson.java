package ua.dnu.myv.domain.attendance;

import ua.dnu.myv.domain.Kid;
import ua.dnu.myv.domain.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "attendance_on_lesson")
public class AttendanceOnLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "lesson")
    private Integer lesson;

    @JoinColumn(name = "kid")
    private Integer kid;

    @Column(name = "date")
    private LocalDate date;

}