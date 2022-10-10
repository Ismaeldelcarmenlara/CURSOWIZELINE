
package com.wizeline.maven.learningjava.service;

import java.util.List;

import com.wizeline.maven.learningjava.model.BankAccountDTO;


public interface BankAccountService {

    
     //regresa  todas las cuentas existentes en formato de lista.

    List<BankAccountDTO> getAccounts();

    /**
     * Gets account details.
     *
     * @param user      nombre de usuario.
     * @param lastUsage último uso de la cuenta.
     * @return detalles de una sola cuenta.
     */
    BankAccountDTO getAccountDetails(String user, String lastUsage);

    void deleteAccounts();
    void createusers();
    void updateusers();
    
    List<BankAccountDTO> getAccountByUser(String user);

    
    
}
