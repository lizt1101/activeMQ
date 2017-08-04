package com.lzt.MessageListenerAdapter;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("simpleJMSSender")
public class SimpleJMSSender {
	
	@Autowired
	@Qualifier("myJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("CommonDestination")
	private Destination commonDestination;
	
	public void MessageListenerAdapter() {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				// 设置消息内容
				msg.setText("Hello World activeMq!");
				System.out.println("Adapter发送消息:Send Hello World activeMq");
				//当接收消息的消费者有返回数据时，指定该返回的消息的目的地
				msg.setJMSReplyTo(commonDestination);
				return msg;
			}
		});

	}

}
