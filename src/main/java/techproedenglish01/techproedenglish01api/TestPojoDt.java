package techproedenglish01.techproedenglish01api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestPojoDt {

@SerializedName("name")
@Expose
private String name;
@SerializedName("salary")
@Expose
private String salary;
@SerializedName("age")
@Expose
private String age;

private String status;

private String message;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getSalary() {
return salary;
}

public void setSalary(String salary) {
this.salary = salary;
}

public String getAge() {
return age;
}

public void setAge(String age) {
this.age = age;
}

public TestPojoDt(String name, String salary, String age) {
	this.name = name;
	this.salary = salary;
	this.age = age;
}

public TestPojoDt() {
}

@Override
public String toString() {
	return "TestPojoDt [name=" + name + ", salary=" + salary + ", age=" + age + "]";
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}