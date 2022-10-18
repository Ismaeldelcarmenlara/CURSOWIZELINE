/*
 * Copyright (c) 2022 Nextiva, Inc. to Present.
 * All rights reserved.
 */
 package com.wizeline.maven.learningjavamaven.service;

import java.util.List;

import com.mongodb.client.result.UpdateResult;
import com.wizeline.maven.learningjavamaven.model.BankAccountDTO;


public interface BankAccountService {

   
    List<BankAccountDTO> getAccounts();

    BankAccountDTO getAccountDetails(String user, String lastUsage);

    void deleteAccounts();

    List<BankAccountDTO> getAccountByUser(String user);
    
    UpdateResult actualizarDato(String user);

}
