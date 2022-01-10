package techproedenglish01.techproedenglish01api;

import java.util.HashMap;
import java.util.Map;

public class Data {

private Integer id;
private String employeeName;
private Integer employeeSalary;
private Integer employeeAge;
private String profileImage;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getEmployeeName() {
return employeeName;
}

public void setEmployeeName(String employeeName) {
this.employeeName = employeeName;
}

public Integer getEmployeeSalary() {
return employeeSalary;
}

public void setEmployeeSalary(Integer employeeSalary) {
this.employeeSalary = employeeSalary;
}

public Integer getEmployeeAge() {
return employeeAge;
}

public void setEmployeeAge(Integer employeeAge) {
this.employeeAge = employeeAge;
}

public String getProfileImage() {
return profileImage;
}

public void setProfileImage(String profileImage) {
this.profileImage = profileImage;
}





@Override
public String toString() {
	return "Data [id=" + id + ", employeeName=" + employeeName + ", employeeSalary=" + employeeSalary + ", employeeAge="
			+ employeeAge + ", profileImage=" + profileImage + "]";
}

public Data(Integer id, String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage) {
	super();
	this.id = id;
	this.employeeName = employeeName;
	this.employeeSalary = employeeSalary;
	this.employeeAge = employeeAge;
	this.profileImage = profileImage;
}

public Data() {
	super();
}

}