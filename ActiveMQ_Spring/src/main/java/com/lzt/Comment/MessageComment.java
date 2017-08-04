package com.lzt.Comment;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class MessageComment implements MessageListener{

	public void onMessage(Message message) {
		System.out.println("我是公共回复接收类:");
		try {
			System.out.println("回复内容是:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
