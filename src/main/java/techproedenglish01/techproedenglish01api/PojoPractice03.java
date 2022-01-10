package techproedenglish01.techproedenglish01api;

import java.util.HashMap;
import java.util.Map;

public class PojoPractice03 {

private String status;
private Data data;
private String message;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}







public PojoPractice03(String status, Data data, String message, Map<String, Object> additionalProperties) {
	this.status = status;
	this.data = data;
	this.message = message;
}

public PojoPractice03() {
}

@Override
public String toString() {
	return "PojoPractice03 [status=" + status + ", data=" + data + ", message=" + message +"]";
}

public PojoPractice03(String status, Data data, String message) {
	super();
	this.status = status;
	this.data = data;
	this.message = message;
}



}
