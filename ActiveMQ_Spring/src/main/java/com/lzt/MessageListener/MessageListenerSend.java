package com.lzt.MessageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerSend {
	
	@Autowired
	@Qualifier("MessageJmsTemplate")
	private JmsTemplate MessageJmsTemplate;
	
	public void MessageListener(){
		MessageJmsTemplate.send("messageListener",new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setText("hello activemq");
				System.out.println("hello activemq");
				return message;
			}
		});
	}

}
