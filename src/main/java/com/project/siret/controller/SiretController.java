package com.project.siret.controller;


import com.project.siret.data.data_transfert_object.SiretDTO;
import com.project.siret.mapper.MapperSiret;
import com.project.siret.service.siret.SiretService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Class Controller for Siret
 *
 * @author  Nicolas Razanatsimba
 * @version 1.0
 * @since   2023-01-13
 */
@RestController
@Slf4j
@RequestMapping("/siret")
public class SiretController implements HealthIndicator {

    private final SiretService siretService;

    @Autowired
    public SiretController(SiretService siretService){
        this.siretService = siretService;
    }


    /**
     * Method to Get Siret Infos
     * @param idSiret
     *
     * @return
     */
    @GetMapping(path = "/get/api")
    private void getSiretInfos(@RequestBody String idSiret){
       this.siretService.getSiretInfosAndStore(idSiret);
    }

    /**
     * Method to Save Siret
     * @param siretDTO
     *
     * @return SiretDTO
     */
    @PostMapping(path = "/siret/create")
    private SiretDTO saveSiret(@RequestBody SiretDTO siretDTO){
        try{
            if(siretDTO == null){
                return null;
            }
            log.info("SIRET NAME ==", siretDTO.getFullName());
            return  MapperSiret.MAPPER.toDto(this.siretService.create(MapperSiret.MAPPER.toDomain(siretDTO)));
        } catch (Exception e){
            log.error("Exception===>", e.getMessage());
            log.error("Error in controller saveSiret using service save");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to Save List of Siret
     * @param siretDTOList
     *
     * @return List<siretDTO>
     */
    @PostMapping(path = "/siret/create/list")
    private List<SiretDTO> saveListSiret(@RequestBody List<SiretDTO> siretDTOList){
        try{
            log.info("BEGIN SAVE LIST SIRET...");
            return  MapperSiret.MAPPER.toDtoList(this.siretService.saveListSiret(MapperSiret.MAPPER.toDomainList(siretDTOList)));
        } catch (Exception e){
            log.error("Exception===>", e.getMessage());
            log.error("Error in controller saveListSiret using service save");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Health health() {
        return Health.up().build();
    }
}
