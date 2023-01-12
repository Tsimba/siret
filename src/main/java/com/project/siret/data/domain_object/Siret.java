package com.project.siret.data.domain_object;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nicolas on 13/01/2023.
 */
@Entity
@Table(name = "siret",
        indexes = {
                @Index(name = "index_siret", columnList = "siret", unique = true)
        })
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Siret {
    @Id
    @Column(updatable = false, nullable = false, unique = true, name = "siret_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String siret;

    private String fullAddress;

    private Date createDate;

    private String fullName;




}
