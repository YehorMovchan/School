package ua.dnu.myv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "nutrition_price")
public class NutritionPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "breakfast")
    private Integer breakfast;

    @Column(name = "lunch")
    private Integer lunch;

    @Column(name = "dinner")
    private Integer dinner;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Column(name = "reason_of_change")
    private String reasonOfChange;

}