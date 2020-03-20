package com.user.demo.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.user.demo.model.User;

@Component
public class Processor implements ItemProcessor<User,User>{

public static final Map<String,String> NAMES = new HashMap<>();
public Processor() {
	NAMES.put("1","emp1");
	NAMES.put("2","emp2");
	NAMES.put("3","emp3");
}

	@Override
	public User process(User user) throws Exception {
		
		String nameCode=user.getName();
		String name=NAMES.get(nameCode);
		user.setName(String.format("converted from[%s] to [%s]", nameCode,name));
		return user;
		
	}
	
//	@Override
//	  public User process(final User User) throws Exception {
//	    final String name = User.getName();
//	    final int age = User.getAge();
//	    final String pan = User.getPan().toUpperCase();
//	    final String aadhar = User.getAadhar();
//	    final String gender = User.getGender();
//	    final int salary = User.getSalary();
//
//	    final User processedUser = new User(1,name, gender,salary,age,pan, aadhar);
//	    return processedUser;
//	  }

	
}
