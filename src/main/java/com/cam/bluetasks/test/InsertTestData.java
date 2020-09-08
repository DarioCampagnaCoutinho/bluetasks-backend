package com.cam.bluetasks.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cam.bluetasks.domain.task.Task;
import com.cam.bluetasks.domain.task.TaskRepository;
import com.cam.bluetasks.domain.user.AppUser;
import com.cam.bluetasks.domain.user.AppUserRepository;

@Component
public class InsertTestData {
	
	private AppUserRepository appUserRepository;
	
	private TaskRepository taskRepository;

	@Autowired
	public InsertTestData(AppUserRepository appUserRepository, TaskRepository taskRepository) {
		this.appUserRepository = appUserRepository;
		this.taskRepository = taskRepository;
	}
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//TODO: Temos que fazer criptográfia do password
		AppUser appUser = new AppUser("Dario", "123456", "Dario Campagna");
		appUserRepository.save(appUser);
		
		LocalDate baseData = LocalDate.parse("2025-09-09");
		
		for(int i = 0; i < 10; i++) {
			Task task1 = new Task("Tarefa #" + i, baseData.plusDays(i), false);
			task1.setAppUser(appUser);
			taskRepository.save(task1);
		}
	}
	
	
}