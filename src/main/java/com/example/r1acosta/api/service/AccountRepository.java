package com.example.r1acosta.api.service;

import com.example.r1acosta.api.model.Account;
import org.springframework.data.repository.CrudRepository;
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
