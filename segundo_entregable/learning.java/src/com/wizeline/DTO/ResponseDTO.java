package com.wizeline.DTO;





public class ResponseDTO {
	
	
	private ResponseDTO(ResponseDTOBuilder builder){
		this.status = builder.status;
		this.code = builder.code;
		this.errors = builder.errors;
		}
	//SOBRECARGA DE METODO
 ResponseDTO(String status,String code,ErrorDTO errors) {
	ResponseDTO usr=new ResponseDTO();
	status =usr.getStatus();
	code = usr.getCode();
	errors = usr.getErrors();	
}
	

   
 

public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}







public static final class ResponseDTOBuilder {
    	
 private String status;
   private String code;
    	
    	private ErrorDTO errors = new ErrorDTO();
    	
    	
    public ResponseDTOBuilder() {}
    
    
    public ResponseDTOBuilder status(String status) {
    	this.status= status;
    	return this;
    }
    public ResponseDTOBuilder code(String code) {
    	this.code= code;
    	return this;
    }
    
    
    public ResponseDTOBuilder errors(ErrorDTO errorDTO) {
    	this.errors= errorDTO;
    	return this;
    }
    
    
    //devuelve el objeto ya contruido
    public ResponseDTO1 build() {
    	ResponseDTO1 responseDTO =  new ResponseDTO1(this);
        validateUserObject(responseDTO);
        return responseDTO;
    }
    private void validateUserObject(ResponseDTO1 responseDTO) {
        //aplicar validaciones...
       
    }
    
    
    
    
    
    	
    	
    }

	
	
	
	
	
	
private String status;
private String code;
private ErrorDTO errors=new ErrorDTO();




public ErrorDTO getErrors() {
	return errors;
}
public void setErrors(ErrorDTO errors) {
	this.errors = errors;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}




}
