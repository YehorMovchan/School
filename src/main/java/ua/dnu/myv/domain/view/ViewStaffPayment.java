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
@Table(name = "view_staff_payment")
public class ViewStaffPayment {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "staff_name", nullable = false)
    private String staffName;

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