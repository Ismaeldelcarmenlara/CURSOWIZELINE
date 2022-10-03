package com.wizeline.DTO;

import java.util.Map;

public class UserDTO {
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
private String user;
	
public UserDTO getParameters(Map<String,String>userParam) {	
UserDTO user=new UserDTO();
user.setUser(userParam.get("user"));
user.setPassword(userParam.get("password"));
return user;
}


//clase interna
public void claseinterna(){
if(user==null) {
System.out.println("no se recibio dato de usuario");
}else
{
System.out.println("procesando datos de usuario");	
	
}
	
}	
	
}


}
