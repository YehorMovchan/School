package ua.dnu.myv.domain.attendance;

import ua.dnu.myv.domain.Kid;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "kid_attendance")
public class KidAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kid")
    private Kid kid;

    @Column(name = "date")
    private LocalDate date;

}