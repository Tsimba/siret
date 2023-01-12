package com.project.siret.mapper;

import com.project.siret.data.data_transfert_object.SiretDTO;
import com.project.siret.data.domain_object.Siret;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperSiret {
    MapperSiret MAPPER = Mappers.getMapper(MapperSiret.class);

    Siret toDomain(SiretDTO siretDTO);

    SiretDTO toDto(Siret siret);

    List<Siret> toDomainList(List<SiretDTO> siretDTOList);

    List<SiretDTO> toDtoList(List<Siret> siretList);

}
