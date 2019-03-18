package com.register.user.error;

public class ResourceEmailAlreadyRegisteredDetails extends ErrorDetails{

	public ResourceEmailAlreadyRegisteredDetails() {
		
	}

	private ResourceEmailAlreadyRegisteredDetails(Builder builder) {
		setMessage(builder.message);
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String message;

		private Builder() {
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public ResourceEmailAlreadyRegisteredDetails build() {
			return new ResourceEmailAlreadyRegisteredDetails(this);
		}
	}
	
}
