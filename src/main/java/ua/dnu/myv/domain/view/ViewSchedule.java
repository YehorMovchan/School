package ua.dnu.myv.domain.view;

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
@Table(name = "view_schedule")
public class ViewSchedule {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(name = "class")
    private Integer classField;

    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "lesson_number")
    private Integer lessonNumber;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

}