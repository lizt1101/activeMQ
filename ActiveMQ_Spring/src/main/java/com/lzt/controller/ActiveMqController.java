package com.lzt.controller;

/**
 * 
 *lizitao
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzt.MessageListener.MessageListenerSend;
import com.lzt.MessageListenerAdapter.SimpleJMSSender;
import com.lzt.SessionAwareMessageListener.SessionAwareSend;

@Controller
public class ActiveMqController {
	
	@Resource
	private SimpleJMSSender simpleJMSSender;
	@Resource
	private SessionAwareSend sessionAwareSend;
	@Resource
	private MessageListenerSend messageListenerSend;
	
	@RequestMapping("/test.do")
	public String test01(){
		return "test";
		
	}
	//测试监听器是MessageListener
	@RequestMapping("/MessageTest.do")
	public void MessageListener(){
		messageListenerSend.MessageListener();
	}
	
	//测试监听器是MessageListenerAdapter
	@RequestMapping("/AdapteTest.do")
	public void MessageListenerAdapteTest(){
		simpleJMSSender.MessageListenerAdapter();
	}
	//测试监听器是SessionAwareMessageListener
	@RequestMapping("/SessionAwareTest.do")
	public void SessionAwareMessageListenerTest(){
		sessionAwareSend.AwareSend();
	}

}







