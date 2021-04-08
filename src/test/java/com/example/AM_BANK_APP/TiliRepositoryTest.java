package com.example.AM_BANK_APP;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.AM_BANK_APP.domain.Tili;
import com.example.AM_BANK_APP.domain.TiliRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TiliRepositoryTest {

	@Autowired
	private TiliRepository repository;
		
		
		@Test
		public void listing() {
		
		List<Tili> tilit = repository.listTilit();
		assertThat(tilit).hasSize(2);
		assertThat(tilit.get(0).getOmistaja()).isEqualTo("Anna A");
}
	
	@Test
	public void createNewTili() {
		
		Tili tili= new Tili("1",2500.0, "Matti M");
		repository.insertWithQuery(tili);
		assertThat(tili.getTilinro()).isNotNull();
	}
}