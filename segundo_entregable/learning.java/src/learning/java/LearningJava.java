package learning.java;
import java.io.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


import com.sun.net.httpserver.HttpServer;

import com.wizeline.BO.BankAccountBO;
import com.wizeline.BO.BankAccountBOImpl;
import com.wizeline.BO.UserBO;
import com.wizeline.BO.UserBOImpl;

import com.wizeline.DTO.BankAccountDTO;
import com.wizeline.DTO.ResponseDTO;
import com.wizeline.DTO.UserDTO;
import com.wizeline.Exceptions.ExceptionGenerica;
import com.wizeline.utils.Utils;
import com.wizeline.enums.*;
//arreglos
import java.util.ArrayList;
import java.util.Arrays;
//lista
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;
 
import com.wizeline.DTO.ResponseDTO;

public class LearningJava extends Thread {

	private static final Logger LOGGER = Logger.getLogger(LearningJava.class.getName());
	private static final Object SUCCESS_CODE = "OK000";
	
	//Implementación de concurrencia
	private static String responseTextThread="";
	private ResponseDTO response;
	private static String textThread;
	

	public static void main(String[] args) throws IOException {
	    
		
		
		
		HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

	        ProcesaTipoServicio procesaTipoServicio = new ProcesaTipoServicio();
	        ServiceProcessing serviceProcessing = procesaTipoServicio.procesaTipoServicio(server, path1);
	        serviceProcessing.procesaService(server, path1);

	        ServiceProcessing serviceProcessing2 = procesaTipoServicio.procesaTipoServicio(server, path2);
	        serviceProcessing2.procesaService(server, path2);

	        ServiceProcessing serviceProcessing3 = procesaTipoServicio.procesaTipoServicio(server, path3);
	        serviceProcessing3.procesaService(server, path3);

	        ServiceProcessing serviceProcessing4 = procesaTipoServicio.procesaTipoServicio(server, path4);
	        serviceProcessing4.procesaService(server, path4);

		
		Logger logger=Logger.getInstance();
		logger.log("patron de diseño singleton");
		
		
		
		
		LOGGER.info("LearningJava - Iniciando servicio REST");
HttpServer server=HttpServer.create(new InetSocketAddress(8081),0);
		
		server.createContext("/api/login", (exchange -> {
			
			LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");
			ResponseDTO response = new ResponseDTO();
			String responseText = "";
if(exchange==null);{
LOGGER.info("no se recibio ningun dato");
}			
if ("GET".equals(exchange.getRequestMethod())) {
				LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
				UserDTO user = new UserDTO();
				user = user.getParameters(splitQuery(exchange.getRequestURI()));
				response = login(user.getUser(), user.getPassword());
				JSONObject json = new JSONObject(response);
				responseText = json.toString();
				exchange.getResponseHeaders().set("contextType", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, responseText.getBytes().length);
			} else {
				exchange.sendResponseHeaders(405, -1);
			}

			OutputStream output = exchange.getResponseBody();

			LOGGER.info("LearningJava - Cerrando recursos ...");
			output.write(responseText.getBytes());
			output.flush();
			output.close();
			exchange.close();
		}));
		server.createContext("/api/createUser", (exchange -> {
			LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");
			
			ResponseDTO response = new ResponseDTO();
			String responseText = "";
			exchange.getRequestBody();
			if ("POST".equals(exchange.getRequestMethod())) {
				LOGGER.info("LearningJava - Procesando peticion HTTP de tipo POST");
				UserDTO user = new UserDTO();
				
				user = user.getParameters(splitQuery(exchange.getRequestURI()));
				response = createUser(user.getUser(), user.getPassword());
				JSONObject json = new JSONObject(response);
				responseText = json.toString();
				exchange.getResponseHeaders().set("contextType", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, responseText.getBytes().length);
			} else {
				exchange.sendResponseHeaders(405, -1);
			}
			OutputStream output = exchange.getResponseBody();

			LOGGER.info("LearningJava - Cerrando recursos ...");
			output.write(responseText.getBytes());
			output.flush();
			output.close();
			exchange.close();
		}));
		
		
		
		
		
		server.createContext("/api/getUserAccount", (exchange -> {
			   LOGGER.info("LearningJava - Inicia procesamiento de petición ...");
			   ResponseDTO response = new ResponseDTO();
			   Instant iniciDeEjecucion=Instant.now();
			   
			   String responseText = "";
			   /** Validates the type of http request */
			   if ("GET".equals(exchange.getRequestMethod())) {
			    LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
			    UserDTO user = new UserDTO();
			    Map<String, String> params = splitQuery(exchange.getRequestURI());
			    user = user.getParameters(params);
			 
			    // Valida formato del parametro fecha (date) [dd-mm-yyyy]
			    String lastUsage = params.get("date");
			    if (Utils.isDateFormatValid(lastUsage)) {
			     // Valida el password del usuario (paswword)
			     if (Utils.isPasswordValid(user.getPassword())) {
			      response = login(user.getUser(), user.getPassword());
			      if (response.getCode().equals(SUCCESS_CODE)) {
			       BankAccountDTO bankAccountDTO = getAccountDetails(user.getUser(), lastUsage);
			       JSONObject json = new JSONObject(bankAccountDTO);
			       responseText = json.toString();
			       exchange.getResponseHeaders().add("Content-type", "application/json");
			       exchange.sendResponseHeaders(200, responseText.getBytes().length);
			       LOGGER.info("Success!");
			      }
			     } else 
			     {
			      responseText = "Password Incorrecto";
			      exchange.getResponseHeaders().add("Content-type", "application/json");
			      exchange.sendResponseHeaders(401, responseText.getBytes().length);
			     }
			    } else {
			     responseText = "Formato de fecha Incorrecto";
			     exchange.getResponseHeaders().add("Content-type", "application/json");
			     exchange.sendResponseHeaders(400, responseText.getBytes().length);
			    }
			    
			    
			    
			   }else {
				   exchange.sendResponseHeaders(405,-1);
				   
			   }
			    /**
			     * Always remember to close the resource you open. Avoid memory leaks
			     */
			   
			  
			   OutputStream output = exchange.getResponseBody();
			 Instant finalDeEjecucion=Instant.now();
			 //String total=new String(String.valueOf(Duration.between(iniciDeEjecucion, finalDeEjecucion).toMillis()).concat("segundos"));  
			
			 
			 
			 LOGGER.info("LearningJava - Cerrando recursos");
			 String total=new String(String.valueOf(Duration.between(iniciDeEjecucion, finalDeEjecucion).toMillis()).concat("segundos"));  
			 LOGGER.info("tiempo de respuesta:".concat(total));
			 output.write(responseText.getBytes());
			   output.flush();
			   output.close();
			   exchange.close();
			  }));

		
	server.createContext("/api/createUsers",(exchange ->{
		LOGGER.info("LearningJava-Inicia procesamiento de peticion ...");
		ResponseDTO response =new ResponseDTO();
		exchange.getRequestBody();
		
	
		
		
		
		if("POST".equals(exchange.getRequestMethod())) {
			LOGGER.info("LearningJava-procesando peticion HTTP de tipo POST");
			StringBuilder text=new StringBuilder();
			try(Scanner scanner=new Scanner(exchange.getRequestBody())){
				
		while(scanner.hasNext()) {
		text.append(scanner.next());
		}
		}catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new ExceptionGenerica("Fallo al obtener el request del body");
        }
			textThread=text.toString();
			LOGGER.info(textThread);
			LearningJava thread=new LearningJava();
			thread.start();
			while(thread.isAlive());
			exchange.getResponseHeaders().set("contentType","application/json; charset=UTF-8");
			exchange.sendResponseHeaders(200,responseTextThread.getBytes().length);
		}else {
			exchange.sendResponseHeaders(405, -1);
		}
			
		OutputStream output=exchange.getResponseBody();
		LOGGER.info("LearningJava-Cerrando recursos");
		output.write(responseTextThread.getBytes());
		output.flush();
        output.close();
        exchange.close();
	}));	
		
	server.createContext("/api/getAccountsGroupByType", (exchange -> {
       String msgProcPeticion="LearningJava - Procesando peticion HTTP de tipo GET";
		LOGGER.info(msgProcPeticion);
        
        Instant inicioDeEjecucion = Instant.now();
        BankAccountBO bankAccountBO = new BankAccountBOImpl();
        String responseText = "";
        /** Validates the type of http request  */
        if ("GET".equals(exchange.getRequestMethod())) {
            LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
            List<BankAccountDTO> accounts = bankAccountBO.getAccounts();
            
            // Aqui implementaremos la programación funcional
            Map<String, List<BankAccountDTO>> groupedAccounts;
           //primer colector
            Function<BankAccountDTO, String> groupFunction = (account) -> account.getAccountType().toString();
          //segundo colector
            groupedAccounts = accounts.stream().collect(Collectors.groupingBy(groupFunction));
            groupedAccounts = accounts.stream().collect(Collectors.filterBy(groupFunction));
            JSONObject json = new JSONObject(groupedAccounts);
            responseText = json.toString();
            exchange.getResponseHeaders().add("Content-type", "application/json");
            exchange.sendResponseHeaders(200, responseText.getBytes().length);
        } else {
            /** 405 Method Not Allowed */
            exchange.sendResponseHeaders(405, -1);
        }
        OutputStream output = exchange.getResponseBody();
        Instant finalDeEjecucion = Instant.now();
        /**
         * Always remember to close the resources you open.
         * Avoid memory leaks
         */
        LOGGER.info("LearningJava - Cerrando recursos ...");
        String total = new String(String.valueOf(Duration.between(inicioDeEjecucion, finalDeEjecucion).toMillis()).concat(" segundos."));
        LOGGER.info("Tiempo de respuesta: ".concat(total));
        output.write(responseText.getBytes());
        output.flush();
        output.close();
        exchange.close();
    }));	
		server.setExecutor(null);
		server.start();
		LOGGER.info("LearningJava - Server started on port 8081");
	
	}
//concurrencia con tres hilos
	//anotacion
	@Override
	public void run(){	
	   
		try {
	         String user = "user";
	         String pass = "password";
	         JSONArray jsonArray = new JSONArray(textThread);
	         JSONObject user1 = new JSONObject(jsonArray.get(0).toString());
	         JSONObject user2 = new JSONObject(jsonArray.get(1).toString());
	         JSONObject user3 = new JSONObject(jsonArray.get(2).toString());

	         // Creamos usuario 1
	         response = createUser(user1.getString(user), user1.getString(pass));
	         responseTextThread = new JSONObject(response).toString();
	         LOGGER.info("Usuario 1: " + responseTextThread);
	         Thread.sleep(1000);

	         // Creamos usuario 2
	         response = createUser(user2.getString(user), user2.getString(pass));
	         responseTextThread = new JSONObject(response).toString();
	         LOGGER.info("Usuario 2: " + responseTextThread);
	         Thread.sleep(1000);

	         // Creamos usuario 3
	         response = createUser(user3.getString(user), user3.getString(pass));
	         responseTextThread = new JSONObject(response).toString();
	         LOGGER.info("Usuario 3: " + responseTextThread);
	     } catch (Exception e) {
	        LOGGER.severe(e.getMessage());
	    	 throw new ExceptionGenerica(e.getMessage());
	     }
	}
	
	
	//anotacion
	@Deprecated(since = "Anotaciones update")
	 private void createUsers() {
	     try {
	         String user = "user";
	         String pass = "password";
	         JSONArray jsonArray = new JSONArray(textThread);
	         JSONObject user1 = new JSONObject(jsonArray.get(0).toString());
	         JSONObject user2 = new JSONObject(jsonArray.get(1).toString());
	         JSONObject user3 = new JSONObject(jsonArray.get(2).toString());

	         ResponseDTO response = createUser(user1.getString(user), user1.getString(pass));
	         responseTextThread = new JSONObject(response).toString();
	         LOGGER.info("Usuario 1: " + responseTextThread);
	         Thread.sleep(1000);

	         response = createUser(user2.getString(user), user2.getString(pass));
	         responseTextThread = new JSONObject(response).toString();
	         LOGGER.info("Usuario 2: " + responseTextThread);
	         Thread.sleep(1000);

	         response = createUser(user3.getString(user), user3.getString(pass));
	         responseTextThread = new JSONObject(response).toString();
	         LOGGER.info("Usuario 3: " + responseTextThread);
	     } catch (InterruptedException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
	private static BankAccountDTO getAccountDetails(String user,String lastUsage) {
		BankAccountBO bankAccountBO = new BankAccountBOImpl();
		return bankAccountBO.getAccountDetails(user,lastUsage);
	}

	
	@SuppressWarnings("unused")
	private static ResponseDTO login(String User, String password) {
		UserBO userBo = new UserBOImpl();
		return userBo.login(User, password);
	}
	
	private static ResponseDTO createUser(String User, String password) {
		UserBO userBo = new UserBOImpl();
		return userBo.createUser(User, password);
	}

	public static Map<String, String> splitQuery(URI uri) throws UnsupportedEncodingException {
		Map<String, String> query_pairs = new LinkedHashMap<>();
		String query = uri.getQuery();
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
					URLDecoder.decode(pair.substring(idx + 1), "UTF8"));
		}

		return query_pairs;
	}

	
	
	
	
	
	
	
}

