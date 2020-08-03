package com.harold.app.test.httpRequestTest;

public class Greeting {
	// A JSON resource representation class
	
	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
}
