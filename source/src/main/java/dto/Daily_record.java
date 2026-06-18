package dto;

import java.io.Serializable;

public class Daily_record implements Serializable {
	private String mind;
	private String body;
	
public Daily_record(String mind,String bosy) {
	this.mind=mind;
	this.body=body;
}

public Daily_record(){
	this.mind="";
	this.body="";
}
public String getMind() {
	return mind;
}
public void setMind(String mind) {
	this.mind = mind;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
}
