package com.location.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "payemnt_type", nullable = false)
    private String paymenType;

    @Column(name = "classification", nullable = false)
    private String classification;

    @Column(name = "is_Created_Date", nullable = false)
    private Instant isCreatedDate ;

    /*@Column(name = "is_Deleted_flag", nullable = false)
    private Character isDeletedFlag;*/


}
