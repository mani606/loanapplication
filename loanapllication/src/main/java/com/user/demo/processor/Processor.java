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
	NAMES.put("101","ANITHA");
	NAMES.put("102","manoj");
	NAMES.put("103","navaneeth");
}

	@Override
	public User process(User user) throws Exception {
		
		String nameCode=user.getName();
		String name=NAMES.get(nameCode);
		user.setName(String.format("converted from[%s] to [%s]", nameCode,name));
		return user;
		
	}

	
}
