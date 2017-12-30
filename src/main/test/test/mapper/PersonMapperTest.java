package test.mapper;

import java.util.Date;

import base.Application;
import base.entity.test.PersonEntity;
import base.mapper.test.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration 
@SpringBootTest(classes = Application.class)
public class PersonMapperTest {

	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(PersonMapperTest.class);
	@Autowired
	private PersonMapper personMapper;

	@Test
	public void testInsert() throws Exception {
		PersonEntity entity = new PersonEntity("xusiwei", 0);
		entity.setBirthday(new Date());
		entity.setPhone("15700115969");

		personMapper.insert(entity);
		entity.setAddress("xiamen");
		personMapper.insert(entity);
		entity.setName("mike");
		personMapper.insert(entity);
		
		logger.info("success!");

	}

}
