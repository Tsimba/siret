package com.project.siret;

import com.project.siret.data.domain_object.Siret;
import com.project.siret.service.siret.SiretService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class SiretApplicationTests {

	@Autowired
	private  SiretService siretService;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveSiret() throws Exception{
		Siret siret = new Siret();
		siret.setSiret("31302979500017");
		siret.setCreateDate(new Date());
		siret.setFullAddress("Rue de Paris");
		siret.setFullName("Name of siret");
		Siret saveSiret = siretService.create(siret);
		assertThat(saveSiret).isNotNull();

	}

	@Test
	public void saveListeSiret() throws Exception{

		List<Siret> siretList = new ArrayList<>();
		
		Siret siret = new Siret();
		siret.setSiret("31302979500017");
		siret.setCreateDate(new Date());
		siret.setFullAddress("Rue de Paris");
		siret.setFullName("Name of siret");
		siretList.add(siret);

		Siret siret1 = new Siret();
		siret1.setSiret("41339442000033");
		siret1.setCreateDate(new Date());
		siret1.setFullAddress("Rue de Mada");
		siret1.setFullName("Name of siret Next");
		siretList.add(siret1);

		Siret siret2 = new Siret();
		siret2.setSiret("41339442000090");
		siret2.setCreateDate(new Date());
		siret2.setFullAddress("Rue de Tana");
		siret2.setFullName("Name of siret End");
		siretList.add(siret2);

		List<Siret> saveListSiret = siretService.saveListSiret(siretList);
		assertThat(saveListSiret).isNotEmpty();

	}


}
