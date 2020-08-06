package com.github.marcoresende.testepraticodev.core.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

public abstract class AbstractResource {
	
	@Context
    private HttpServletRequest servletRequest;
	
	protected javax.ws.rs.core.Response toRestResponse(Response response, Status status) {
        return javax.ws.rs.core.Response.status(status).entity(response).build();
    }
	
	protected HttpServletRequest getRequest() {
		return this.servletRequest;
	}
	
}
