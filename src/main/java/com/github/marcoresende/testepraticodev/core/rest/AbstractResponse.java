package com.github.marcoresende.testepraticodev.core.rest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractResponse implements Response {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Message> messages = new ArrayList<Message>();

    @JsonProperty("messages")
    @Override
    public List<Message> getMessages() {
        return this.messages;
    }

    @Override
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public boolean hasMessagesWithSeverity(Message.Severity severity) {
        for (Message m : this.messages) {
            if (severity.equals(m.getSeverity())) {
                return true;
            }
        }
        return false;
    }

    public List<Message> getMessagesWithSeverity(Message.Severity severity) {
        List<Message> filteredMessages = new ArrayList<Message>();
        for (Message m : this.messages) {
            if (severity.equals(m.getSeverity())) {
                filteredMessages.add(m);
            }
        }
        return filteredMessages;
    }

}
