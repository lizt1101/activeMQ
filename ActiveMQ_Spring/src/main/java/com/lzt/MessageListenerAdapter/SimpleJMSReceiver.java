package com.lzt.MessageListenerAdapter;

import javax.jms.JMSException;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

@Component
public class SimpleJMSReceiver{

	/*public void receive(TextMessage message) throws JmsException,JMSException, InterruptedException {
		Thread.sleep(1000);
		System.out.println("监听到消息:"+message.getText());
	}*/
	
	//测试该种监听器返回消息回复
	public String receive(String message) throws JmsException,JMSException, InterruptedException {
		System.out.println("Adapter receive监听到消息:"+message);
		return "lzt";
	}

	

}
