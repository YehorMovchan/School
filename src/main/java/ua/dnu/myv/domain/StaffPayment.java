package ua.dnu.myv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "staff_payment")
public class StaffPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "staff")
    private Integer staff;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Column(name = "salary")
    private Integer salary;

    @Lob
    @Column(name = "reason_of_change")
    private String reasonOfChange;

}