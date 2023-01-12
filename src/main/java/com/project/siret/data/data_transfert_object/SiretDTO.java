package com.project.siret.data.data_transfert_object;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nicolas on 13/01/2023.
 */

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SiretDTO implements Serializable {

    private Integer id;

    private String siret;

    private String fullAddress;

    private Date createDate;

    private String fullName;




}
