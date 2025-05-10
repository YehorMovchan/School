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
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "kid")
    private Integer kid;

    @Column(name = "date")
    private LocalDate date;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "type")
    private Integer type;

    @Column(name = "sum")
    private Integer sum;

    @Column(name = "receipt")
    private byte[] receipt;

    @Column(name = "id_of_item")
    private Integer idOfItem;

}