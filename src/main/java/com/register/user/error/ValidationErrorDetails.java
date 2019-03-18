package com.register.user.error;

public class ValidationErrorDetails extends ErrorDetails{

	public ValidationErrorDetails() {
		
	}

	private ValidationErrorDetails(Builder builder) {
		this.setMessage(builder.message);
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

		public ValidationErrorDetails build() {
			return new ValidationErrorDetails(this);
		}
	}
	
}
