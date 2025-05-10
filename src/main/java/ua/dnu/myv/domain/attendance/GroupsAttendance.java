package ua.dnu.myv.domain.attendance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "groups_attendance")
public class GroupsAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "_group")
    private Integer _group;

    @JoinColumn(name = "kid")
    private Integer kid;

    @Column(name = "date")
    private LocalDate date;


}