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
@Table(name = "view_attendance_on_lesson")
public class ViewAttendanceOnLesson {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "kid_id")
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Column(name = "class")
    private Integer classField;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

}