package ua.dnu.myv.domain.view;

import jakarta.persistence.*;
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
@Table(name = "view_programs")
public class ViewProgram {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "kid_id")
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Column(name = "program_id")
    private Integer programId;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "program_price")
    private Integer programPrice;

    @Column(name = "price_from")
    private LocalDate priceFrom;

    @Column(name = "price_to")
    private LocalDate priceTo;

    @Lob
    @Column(name = "reason_of_change")
    private String reasonOfChange;

}