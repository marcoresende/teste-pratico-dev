package com.github.marcoresende.testepraticodev.core.rest;

import java.io.Serializable;
import java.util.List;

public interface Response extends Serializable{
	
	public List<Message> getMessages();
	
	public void setMessages(List<Message> messages);

    public void addMessage(Message message);
}
