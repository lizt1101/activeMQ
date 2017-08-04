package com.lzt.MessageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

public class MessageListenerReceive implements MessageListener{

	public void onMessage(Message message) {
		try {
			System.out.println("1:接收消息");
			System.out.println("messageListener接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
