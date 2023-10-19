package core;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
           private static int cnt=0;
           private int id;
           private String email;
           private String fristName;
           private String lastName;
           private String password;
           private ServicePlan plan;
           private int regAmnt;
           private LocalDate paiddate;
		public Customer(String email, String fristName, String lastName, String password,ServicePlan plan,int amnt,LocalDate d) {
			super();
			this.id=++cnt;
			this.email = email;
			this.fristName = fristName;
			this.lastName = lastName;
			this.password = password;
			this.plan=plan;
			this.regAmnt=amnt;
			paiddate=d;
		}
		@Override
		public String toString() {
			return "Customer [id = "+id+" email=" + email + ", fristName=" + fristName + ", lastName=" + lastName + ", password="
					+ password + "SerivePlan = "+plan.name()+" AdditionalCost = "+regAmnt+" last paid date = "+paiddate+" ]";
		}
		@Override
		public int compareTo(Customer c) {
			return c.getDate().compareTo(this.getDate());
		}
		
        public String getPassword() {
        	return password;
        }
        public String getEmail() {
        	return email;
        }
	    public void setPassword(String pass) {
	    	password=pass;
	    	System.out.println("successfully change password");
	    }
	    public LocalDate getDate() {
	    	return paiddate;
	    }
}
