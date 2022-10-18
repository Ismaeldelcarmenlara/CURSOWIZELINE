

package com.wizeline.maven.learningjavamaven.service;

import static com.wizeline.maven.learningjavamaven.utils.Utils.getCountry;
import static com.wizeline.maven.learningjavamaven.utils.Utils.pickRandomAccountType;
import static com.wizeline.maven.learningjavamaven.utils.Utils.randomAcountNumber;
import static com.wizeline.maven.learningjavamaven.utils.Utils.randomBalance;
import static com.wizeline.maven.learningjavamaven.utils.Utils.randomInt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.wizeline.maven.learningjavamaven.enums.Country;
import com.wizeline.maven.learningjavamaven.model.BankAccountDTO;
import com.wizeline.maven.learningjavamaven.repository.BankingAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	private static final Logger LOGGER = Logger.getLogger(BankAccountServiceImpl.class.getName());

	@Autowired
	private BankingAccountRepository bankAccountRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<BankAccountDTO> getAccounts() {
		
		
		// Creación  de dato BankAccount
		public BankAccountDTO buildBankAccount(String user, boolean isActive, Country country, LocalDateTime lastUsage) {
			BankAccountDTO bankAccountDTO = new BankAccountDTO();
			bankAccountDTO.setAccountNumber(randomAcountNumber());
			bankAccountDTO.setAccountName("Dummy Account ".concat(randomInt()));
			bankAccountDTO.setUserName(user);
			bankAccountDTO.setAccountBalance(randomBalance());
			bankAccountDTO.setAccountType(pickRandomAccountType());
			bankAccountDTO.setCountry(getCountry(country));
			bankAccountDTO.getLastUsage();
			bankAccountDTO.setCreationDate(lastUsage);
			bankAccountDTO.setAccountActive(isActive);
			return bankAccountDTO;
		}
		
		
		
		//lista  de cuentas existentes
		List<BankAccountDTO> accountDTOList = new ArrayList<>();
		BankAccountDTO bankAccountOne = buildBankAccount("user3@wizeline.com", true, Country.MX, LocalDateTime.now());
		accountDTOList.add(bankAccountOne);

		// guarda la en base de datos
		mongoTemplate.save(bankAccountOne);

		BankAccountDTO bankAccountTwo = buildBankAccount("user1@wizeline.com", false, Country.FR,
				LocalDateTime.now().minusMonths(2));
		accountDTOList.add(bankAccountTwo);

		// Guardar cada record en la db de mongo (en la coleccion bankAccountCollection)
		mongoTemplate.save(bankAccountTwo);

		BankAccountDTO bankAccountThree = buildBankAccount("user2@wizeline.com", false, Country.US,
				LocalDateTime.now().minusYears(4));
		accountDTOList.add(bankAccountThree);

		// Guardar cada record en la db de mongo (en la coleccion bankAccountCollection)
		mongoTemplate.save(bankAccountThree);

		
		mongoTemplate.findAll(BankAccountDTO.class).stream().map(bankAccountDTO -> bankAccountDTO.getUserName())
				.forEach((user) -> {
					LOGGER.info("User stored in bankAccountCollection " + user);
				});

		return accountDTOList;
	}
	
	
	
	
	//actualiza datos
		public UpdateResult actualizarDato(String user) {

			Query query = new Query();
			UpdateResult updateResult;
			query.addCriteria(Criteria.where("userName").is(user));

			Update updateData = Update.update("nombre de la cuent", "actualizacion de dato por servicio: tipo REST");

			updateResult = mongoTemplate.updateMulti(query, updateData, BankAccountDTO.class);

			return updateResult;

		}
	

	@Override
	public void deleteAccounts() {
		//borra todos los datos que estan dentro de la coleccion
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").exists(true)); 

		mongoTemplate.remove(query, "bankAccountCollection");

	}

	@Override
	public List<BankAccountDTO> getAccountByUser(String user) {
		
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(user));
		return mongoTemplate.find(query, BankAccountDTO.class);
	}

	@Override
	public BankAccountDTO getAccountDetails(String user, String lastUsage) {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate usage = LocalDate.parse(lastUsage, dateformatter);
		return buildBankAccount(user, true, Country.MX, usage.atStartOfDay());
	}

	
	


}
