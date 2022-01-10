package techproedenglish01.techproedenglish01api;

public class PojoPractice05 {

private String employeeName;
private String employeeSalary;
private String employeeAge;
private String profileImage;
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

private String status;
private String message;

public String getEmployeeName() {
return employeeName;
}

public void setEmployeeName(String employeeName) {
this.employeeName = employeeName;
}

public String getEmployeeSalary() {
return employeeSalary;
}

public void setEmployeeSalary(String employeeSalary) {
this.employeeSalary = employeeSalary;
}

public String getEmployeeAge() {
return employeeAge;
}

public void setEmployeeAge(String employeeAge) {
this.employeeAge = employeeAge;
}

public String getProfileImage() {
return profileImage;
}

public void setProfileImage(String profileImage) {
this.profileImage = profileImage;
}

public PojoPractice05(String employeeName, String employeeSalary, String employeeAge, String profileImage) {
	this.employeeName = employeeName;
	this.employeeSalary = employeeSalary;
	this.employeeAge = employeeAge;
	this.profileImage = profileImage;
}

public PojoPractice05() {
}

@Override
public String toString() {
	return "PojoPractice05 [employeeName=" + employeeName + ", employeeSalary=" + employeeSalary + ", employeeAge="
			+ employeeAge + ", profileImage=" + profileImage + ", status=" + status + ", message=" + message + "]";
}

public PojoPractice05(String employeeName, String employeeSalary, String employeeAge, String profileImage,
		String status, String message) {
	super();
	this.employeeName = employeeName;
	this.employeeSalary = employeeSalary;
	this.employeeAge = employeeAge;
	this.profileImage = profileImage;
	this.status = status;
	this.message = message;
}



}
