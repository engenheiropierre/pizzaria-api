package br.com.uds.pizzariaapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = -5387237488318794061L;
	
	private HttpServletResponse response;
	private Long id;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
}
