package com.bits.cexp.deposit.dto;


public class CustomerDTO {

	    private long customerId;	

		private String firstName;    

		private String lastName;
		
	    private String customerAddress;

		private String email;
		
		public CustomerDTO() {

		}
		
		public CustomerDTO(String firstName, String lastName, String customerAddress, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.customerAddress = customerAddress;
			this.email = email;
		}	
		
		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getCustomerAddress() {
			return customerAddress;
		}

		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}	

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}	

		@Override
		public String toString() {
			return "Customer "
					+ "[id=" + customerId + 
					", firstName=" + firstName + 
					", lastName=" + lastName + 
					", customerAddress=" + customerAddress + 
					", email=" + email +
					"]";
		}	
		
				
}
