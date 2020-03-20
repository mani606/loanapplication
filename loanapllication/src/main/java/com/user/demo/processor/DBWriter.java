package com.user.demo.processor;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.demo.model.User;
import com.user.demo.repository.UserRepository;



@Component
public class DBWriter implements ItemWriter<User> {
	
	@Autowired
  private UserRepository useRepository;
	
	@Override
	public void write(List<? extends User> user) throws Exception {
		
		System.out.println("Data Saved for Users:"+ user);
		useRepository.saveAll(user);
		
	}


	
}
