package classes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String rollno;
private String address;
private String cl;
private String gender;
private String dob;
public Students() {}

public Students(int id) {
	this.id = id;
}

public Students(String name, String rollno, String address,String cl,String gender,String dob) {
	super();
	this.name = name;
	this.rollno = rollno;
	this.address =address;
	this.cl=cl;
	this.gender=gender;
	this.dob=dob;
}

public Students(int id, String name, String rollno, String address, String cl,String gender,String dob) {
	super();
	this.id = id;
	this.name = name;
	this.rollno = rollno;
	this.address = address;
	this.cl=cl;
	this.gender=gender;
	this.dob=dob;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCl() {
	return cl;
}
public void setCl(String cl) {
	this.cl = cl;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}

}