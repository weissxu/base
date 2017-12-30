package base.mapper.test;

import java.util.List;

import base.entity.test.PersonEntity;
import base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper extends BaseMapper<PersonEntity>{

    @Select("SELECT id,name,gender,birthday,phone,address FROM person")
    @Results({
//        @Result(property = "phone",  column = "phone", javaType = UserSexEnum.class),
        @Result(property = "address", column = "address")
    })
    List<PersonEntity> findAll();
}
