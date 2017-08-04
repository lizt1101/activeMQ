package com.lzt.SessionAwareMessageListener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class SessionAwareReceive implements SessionAwareMessageListener<Message>{

	private Destination destination;  
	
	public void onMessage(Message message, Session session) throws JMSException {
		System.out.println("SessionAwareMessageListener接收到一条消息!");
		System.out.println("消息名字是:"+((TextMessage)message).getText());
		//返回接收到消息的信号
		MessageProducer producer = session.createProducer(destination);  
        Message textMessage = session.createTextMessage("已接收到信息。。。");  
        producer.send(textMessage);
		
	}
	 public Destination getDestination() {  
	        return destination;  
	    }  
	    public void setDestination(Destination destination) {  
	        this.destination = destination;  
	    }  
}














