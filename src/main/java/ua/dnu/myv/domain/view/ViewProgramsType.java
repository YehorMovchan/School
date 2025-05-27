package ua.dnu.myv.domain.view;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_programs_types")
public class ViewProgramsType implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "programId", nullable = false)
    private Integer programId;
    @Column(name="priceId")
    private Integer priceId;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "info")
    private String info;

    @Column(name = "school_included")
    private Boolean schoolIncluded ;

    @Column(name = "price")
    private Integer price;

    @Column(name = "`from`")
    private LocalDate from;

    @Column(name = "`to`")
    private LocalDate to;

    @Lob
    @Column(name = "reason_of_change")
    private String reasonOfChange;
}