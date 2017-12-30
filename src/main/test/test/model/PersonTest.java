package test.model;

import com.alibaba.fastjson.JSON;

import base.entity.test.PersonEntity;
import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson() {
		PersonEntity entity=new PersonEntity("siwei", 1);
		System.out.println(JSON.toJSONString(entity));
	}
}
