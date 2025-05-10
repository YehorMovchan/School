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
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "kid")
    private Integer kid;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "program")
    private Integer program;

    @Lob
    @Column(name = "reason_of_change")
    private String reasonOfChange;

}