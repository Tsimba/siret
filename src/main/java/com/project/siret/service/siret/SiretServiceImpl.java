package com.project.siret.service.siret;

import com.project.siret.data.domain_object.Siret;
import com.project.siret.repository.SiretReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * Class for Service of Siret
 *
 * @author  Nicolas Razanatsimba
 * @version 1.0
 * @since   2023-01-13
 */
@Service
public class SiretServiceImpl implements  SiretService{

    private final SiretReposotory siretReposotory;

    @Autowired
    public SiretServiceImpl(SiretReposotory siretReposotory){
        this.siretReposotory = siretReposotory;
    }


    /**
     * Method to save siret
     * @param siret
     *
     * @return Siret
     */
    @Override
    public Siret create(Siret siret) {
        return this.siretReposotory.save(siret);
    }

    /**
     * Method to save List siret
     * @param siretList
     *
     * @return List Siret
     */
    @Override
    public List<Siret> saveListSiret(List<Siret> siretList) {
        return this.siretReposotory.saveAll(siretList);
    }

    /**
     * Method to get Siret Infos
     * @param idSiret
     *
     * @return
     */
    @Override
    public void getSiretInfosAndStore(String idSiret) {
        String uri = "https://api.insee.fr/entreprises/sirene/V3/siret/";

        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity=new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();
        Siret result =  restTemplate.exchange(uri + idSiret, HttpMethod.GET,entity, Siret.class).getBody();
        if(result != null){
            this.create(result);
        }
    }
}
