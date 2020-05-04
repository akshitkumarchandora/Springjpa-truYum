package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class App {
	@Autowired
	private static MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context=SpringApplication.run(App.class, args);
		
		menuItemService=context.getBean(MenuItemService.class);
		testModifyItem();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem(1l);
		
		//testing all methods of MethodItemService::
		//new App().testGetMenuItem(1);
		//new App().testGetMenuItemListAdmin();
		//new App().testGetMenuItemListCustomer();
		//new App().testModifcation();
		
	}
	
	private static void testModifyItem()//use this test to insert or update Menu ITem Object
	{
		MenuItem menuItem=menuItemService.getMenuItem(1l);
		//menuItem.setId(1l);
		//menuItem.setName("Chatpat");
		//menuItem.setPrice(30.00);
		//menuItem.setFreeDelivery(false);
		//menuItem.setActive(true);
		//menuItem.setDateOfLaunch(DateUtil.convertToDate("12/05/1998"));
		menuItem.setCategory("Starters");
		menuItemService.modifyMenuItem(menuItem);
		
	}
	private static void testGetMenuItemListAdmin()
	{
		LOGGER.info("Start");	
		LOGGER.debug("MenuItems:: {}",menuItemService.getMenuItemListAdmin());
		LOGGER.info("End");
	}
	
	private static void testGetMenuItemListCustomer()
	{
		LOGGER.info("Start");	
		LOGGER.debug("MenuItems for customer :: {}",menuItemService.getMenuItemListCustomer());
		LOGGER.info("End");
	}
	
	
	private static void testGetMenuItem(long id)
	{
		LOGGER.info("Start");	
		LOGGER.debug("Item:: {}",menuItemService.getMenuItem(id));
		LOGGER.info("End");
	}
//	public List<MenuItem> testGetMenuItemListAdmin()
//	{
//		@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
//		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
//		return menuItemService.getMenuItemListAdmin();
//	}
//	
//	public List<MenuItem> testGetMenuItemListCustomer()
//	{
//		@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
//		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
//		return menuItemService.getMenuItemListCustomer();
//	}
//	
//	public MenuItem testGetMenuItem(long id)
//	{
//		@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
//		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
//		return menuItemService.getMenuItem(id);
//	}
//	
//	
//	
//	public void testModifcation()
//	{
//		@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
//		menuItemService=(MenuItemService)ctx.getBean("menuItemService");
//		
//		MenuItem menuItem=testGetMenuItem(1);
//		System.out.println("Before Modification :: "+ menuItem);
//		menuItem.setPrice(500f);
//		menuItemService.modifyMenuItem(menuItem);
//		
//		System.out.println("After Modification :: "+menuItemService.getMenuItem(1));
//		
//	}
	
	

}
