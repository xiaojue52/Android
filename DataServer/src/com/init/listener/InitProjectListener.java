package com.init.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.project.po.ClassRoom;
import com.project.service.ClassRoomService;


public class InitProjectListener extends ContextLoaderListener{
	public void contextInitialized(ServletContextEvent event) {  
	    super.contextInitialized(event);  
	    ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());  
	    ClassRoomService initData = (ClassRoomService) applicationContext.getBean("ClassRoomService");
	    if(initData.getClassRoomsByHql("from ClassRoom").size()>0)return;
	    ClassRoom cls1 = new ClassRoom();
	    cls1.setName("401教室");
	    initData.saveClassRoom(cls1);
	    
	    ClassRoom cls2 = new ClassRoom();
	    cls2.setName("301教室");
	    initData.saveClassRoom(cls2);
	    
	    ClassRoom cls3 = new ClassRoom();
	    cls3.setName("201教室");
	    initData.saveClassRoom(cls3);
	    
	    ClassRoom cls4 = new ClassRoom();
	    cls4.setName("101教室");
	    initData.saveClassRoom(cls4);
	    
	    ClassRoom cls5 = new ClassRoom();
	    cls5.setName("402教室");
	    initData.saveClassRoom(cls5);
	    
	    ClassRoom cls6 = new ClassRoom();
	    cls6.setName("403教室");
	    initData.saveClassRoom(cls6);
	}
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		// TODO Auto-generated method stub
	}
}
