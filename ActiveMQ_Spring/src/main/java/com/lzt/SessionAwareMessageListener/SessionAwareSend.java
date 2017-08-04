package com.lzt.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("sessionAwareSend")
public class SessionAwareSend {
	
	@Autowired
	@Qualifier("SessionJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void AwareSend() {
		jmsTemplate.send(new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setText("小明");
				System.out.println("SessionAwareMessageListener发送姓名:小明");
				return message;
			}	
		});
	}

}
