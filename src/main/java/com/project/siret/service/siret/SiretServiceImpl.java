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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class SiretServiceImpl implements  SiretService{

    private final SiretReposotory siretReposotory;

    @Autowired
    public SiretServiceImpl(SiretReposotory siretReposotory){
        this.siretReposotory = siretReposotory;
    }


    @Override
    public Siret create(Siret siret) {
        return this.siretReposotory.save(siret);
    }

    @Override
    public List<Siret> saveListSiret(List<Siret> siretList) {
        return this.siretReposotory.saveAll(siretList);
    }

    @Override
    public void getSiretInfosAndStore() {
        List<String> siretIdList = new ArrayList<>();
        siretIdList.add("31302979500017");
        siretIdList.add("41339442000033");
        siretIdList.add("41339442000090");
        siretIdList.add("41339442000116");
        siretIdList.add("41776304200013");
        siretIdList.add("43438147100011");
        siretIdList.add("45251723800013");
        siretIdList.add("52170053400014");
        siretIdList.add("75254783600011");
        siretIdList.add("47962817400042");
        siretIdList.add("97080195700014");

        String uri = "https://api.insee.fr/entreprises/sirene/V3/siret/";

        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity=new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();
        for(String idSiret : siretIdList){
            Siret result =  restTemplate.exchange(uri + idSiret, HttpMethod.GET,entity, Siret.class).getBody();
            if(result != null){
                this.create(result);
            }
        }

    }
}
