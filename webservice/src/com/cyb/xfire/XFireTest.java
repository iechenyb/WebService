package com.cyb.xfire;
import java.net.MalformedURLException;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
/**
 * config : web.xml ,web-inf/META-INF/xfire/services.xml
 * 1 start project  webservice 
 * 2 visit http://localhost/webservice/services in explore
 * 3 run XFireTest
 * @author DHUser
 *
 */
public class XFireTest {
	public static void main(String args[]) throws MalformedURLException {
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());		
		Service helloService = new ObjectServiceFactory().create(IHelloService.class);
		String url = "http://localhost/webservice/services/HelloService";
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
