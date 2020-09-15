package builder;

class ApiRequest {
	private String request;
	
	public ApiRequest(String adress, String arguments) {
		request = adress + arguments;
	}
	
	public void openRequest() {
		// OPENS REQUEST
		logRequest();
	}
	
	private void logRequest() {
		System.out.println("new request at: " + request);
	}
}

class ApiRequestBuilder {
	private String adress;
	private StringBuilder arguments = new StringBuilder(); // Stringbuilder??
	private int counter = 0;
	
	public ApiRequestBuilder setAdress(String adress) {
		this.adress = adress;
		return this;
	}
	
	public ApiRequestBuilder addArgument(String name, String parameter) {
		arguments.append( (counter == 0 ? "?" : "&") + name + "=" + parameter);
		counter++;
		return this;
	}
	
	public ApiRequest build() {
		return new ApiRequest(adress, arguments.toString());
	}
}

public class BuilderExample {
	public static void main(String[] args) {
		ApiRequest request = new ApiRequestBuilder().setAdress("http://localhost:3523/createPerson")
				.addArgument("name", "Marcel").addArgument("age", "24").addArgument("height", "175").addArgument("city", "Rotterdam").build();
		request.openRequest();
	}
}


