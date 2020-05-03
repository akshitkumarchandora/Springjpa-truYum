package com.cognizant.truyum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class App {
	@Autowired
	private MenuItemService menuItemService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		//testing all methods of MethodItemService::
		//new App().testGetMenuItem(1);
		//new App().testGetMenuItemListAdmin();
		//new App().testGetMenuItemListCustomer();
		new App().testModifcation();
		
	}
	public List<MenuItem> testGetMenuItemListAdmin()
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
		return menuItemService.getMenuItemListAdmin();
	}
	
	public List<MenuItem> testGetMenuItemListCustomer()
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
		return menuItemService.getMenuItemListCustomer();
	}
	
	public MenuItem testGetMenuItem(long id)
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
		return menuItemService.getMenuItem(id);
	}
	
	
	
	public void testModifcation()
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
		
		MenuItem menuItem=testGetMenuItem(1);
		System.out.println("Before Modification :: "+ menuItem);
		menuItem.setPrice(500f);
		menuItemService.modifyMenuItem(menuItem);
		
		System.out.println("After Modification :: "+menuItemService.getMenuItem(1));
		
	}
	
	

}
