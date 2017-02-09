package com.cyb.xfire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;


@WebServlet("/XFireEnter")
public class XFireEnter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public XFireEnter() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String basePath = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
		String webPath = this.getServletConfig().getServletContext().getRealPath("/");
		System.out.println("DOGET:"+basePath);
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());		
		Service helloService = new ObjectServiceFactory().create(IHelloService.class);
		String url = basePath+"services/HelloService";
		IHelloService hs = (IHelloService) factory.create(helloService,url);
		System.out.println(hs.sayHello("张三"));
		User user = new User();
		user.setName("哈哈");
		System.out.println(hs.getUser(user).getName());
		
		Service worldService = new ObjectServiceFactory().create(IWorldService.class);
		String url1 = "http://localhost/webservice/services/WorldService";
		IWorldService ws = (IWorldService) factory.create(worldService,url1);
		System.out.println(ws.sayHello("李四"));
		User user1 = new User();
		user1.setName("王五");
		System.out.println(ws.getUser(user1).getName());//param is user
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String basePath = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
		String webPath = this.getServletConfig().getServletContext().getRealPath("/");
		System.out.println("DOPOST"+basePath);
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());		
		Service helloService = new ObjectServiceFactory().create(IHelloService.class);
		String url = basePath+"services/HelloService";
		IHelloService hs = (IHelloService) factory.create(helloService,url);
		System.out.println(hs.sayHello("张三"));
		User user = new User();
		user.setName("哈哈");
		System.out.println(hs.getUser(user).getName());
		
		Service worldService = new ObjectServiceFactory().create(IWorldService.class);
		String url1 = "http://localhost/webservice/services/WorldService";
		IWorldService ws = (IWorldService) factory.create(worldService,url1);
		System.out.println(ws.sayHello("李四"));
		User user1 = new User();
		user1.setName("王五");
		System.out.println(ws.getUser(user1).getName());//param is user
	}

}
