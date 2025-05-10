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
@Table(name = "view_transactions")
public class ViewTransaction {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "kid_id")
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "transaction_type_id")
    private Integer transactionTypeId;

    @Column(name = "transaction_type_name")
    private String transactionTypeName;

    @Column(name = "sum")
    private Integer sum;

    @Column(name = "receipt")
    private byte[] receipt;

    @Column(name = "id_of_item")
    private Integer idOfItem;

    @Column(name = "group_name")
    private String groupName;
}