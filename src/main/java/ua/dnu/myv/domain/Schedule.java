package ua.dnu.myv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class")
    private Integer classField;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @JoinColumn(name = "teacher")
    private Integer teacher;

    @JoinColumn(name = "subject")
    private Integer subject;

    @Column(name = "lesson_number")
    private Integer lessonNumber;

}