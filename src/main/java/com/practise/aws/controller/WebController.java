package com.practise.aws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.aws.model.UserDetails;
import com.practise.aws.repo.UserCrudRepository;

@RestController
@RequestMapping("/userregistration")
public class WebController {
	


		@Autowired
		public UserCrudRepository repository;


		@RequestMapping("/save")
		public Map<String, Object> save(UserDetails user) {
			user=repository.save(user);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			  dataMap.put("message", "UserDetails created successfully");
			  dataMap.put("status", "1");
			  dataMap.put("UserDetails", user);
			     return dataMap;
		}

		@RequestMapping("/findall")
		public String findAll() {
			String result = "";
			Iterable<UserDetails> users = repository.findAll();

			for (UserDetails cust : users) {
				result += cust.toString() + "<br>";
			}

			return result;
		}

		@RequestMapping("/read")
		 public Map<String, Object> read(@RequestParam String userId) {
		  UserDetails user = repository.findOne(userId);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "UserDetails found successfully");
		  dataMap.put("status", "1");
		  dataMap.put("UserDetails", user);
		     return dataMap;
		 }

		@RequestMapping("/update")
		 public Map<String, Object> update(@RequestParam String userId, @RequestParam String firstName) {
			UserDetails user = repository.findOne(userId);
			user.setFirstName(firstName);
			user = repository.save(user);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "UserDetails updated successfully");
		  dataMap.put("status", "1");
		  dataMap.put("UserDetails", user);
		     return dataMap;
		 }
		
		
		@RequestMapping("/delete")
		 public Map<String, Object> delete(@RequestParam String userId) {
		  repository.delete(userId);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "UserDetails deleted successfully");
		  dataMap.put("status", "1");
		     return dataMap;
		 }
		 
		 /**
		  * GET /read  --> Read all booking from the database.
		  */
		 @RequestMapping("/read-all")
		 public Map<String, Object> readAll() {
		  List<UserDetails> user = (List<UserDetails>) repository.findAll();
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "UserDetails found successfully");
		  dataMap.put("totalUserDetails", user.size());
		  dataMap.put("status", "1");
		  dataMap.put("bookings", user);
		     return dataMap;
		 }
	}

