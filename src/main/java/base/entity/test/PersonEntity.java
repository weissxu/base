package base.entity.test;

import java.util.Date;
/**
 * 
 * @author siwei
 *
 */
public class PersonEntity {
	private Long id;
	private String name;
	private Integer gender;
	private Date birthday;
//	private Integer age;
	private String phone;
	private String address;
	
	public PersonEntity() {
	}
	public PersonEntity(String name, Integer gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
