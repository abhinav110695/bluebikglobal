package com.bankapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankapp.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	
	@Query(
			  value = "SELECT ac_us FROM USER u WHERE u.user_id = ?", 
			  nativeQuery = true)

	public Integer accountNumber(Integer user_id);

	public Account save(Optional<Account> ac);
	
}
