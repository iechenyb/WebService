package com.cyb.cxf;
import javax.xml.ws.Endpoint;
//publish webservice
public class WebServiceApp {
	public static void main(String[] args) {
        System.out.println("publish web service start");
        HelloWorldImpl implementor= new HelloWorldImpl();
        String address="http://localhost:8080/helloCXF";
        Endpoint.publish(address, implementor);
        System.out.println("publish web service end");
    }
}
