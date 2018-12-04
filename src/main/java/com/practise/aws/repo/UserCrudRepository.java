package com.practise.aws.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.practise.aws.model.UserDetails;

@Transactional
public interface UserCrudRepository extends CrudRepository<UserDetails, String> {

	List<UserDetails> findByEmail(String email);
}