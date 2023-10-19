package utility;

import java.time.LocalDate;
import java.util.Map;

import ExceptionHandling.CustomerException;
import core.Customer;
import core.ServicePlan;

public class CustomerValidationRules  {
	public static Customer checkInput(String email, String fristName, String lastName, String password,String plan,int amnt,String date,Map<String,Customer>obj)throws IllegalArgumentException, CustomerException 
	{             dups(email,obj);
                 ServicePlan validPlan = ServicePlan.valueOf(plan.toUpperCase());
                 if(validPlan.getAdditionalCost()!=amnt)
                	 throw new CustomerException("Invalid Amount!!!!");
                 LocalDate validDate = LocalDate.parse(date);
                 Customer customer = new Customer(email,fristName,lastName,password,validPlan,amnt,validDate);
                 return customer;
	}
	public static void dups(String email,Map<String,Customer>obj) throws CustomerException
	{      
		if(obj.containsKey(email))
	        	 throw new CustomerException("duplicate email not allowed!!!");
	}
	public static Customer signIn(String email,String pass,Map<String,Customer>customers) throws CustomerException {
		Customer c =customers.get(email);
   	 if(c!=null) {
   		 if(c.getPassword().equals(pass)) {
   			 System.out.println("sign in Successfully");
   		 return c;
   		 }
   		 else
   			 throw new CustomerException("wrong password!!!");
	}
   	 else
   		 throw new CustomerException("Account not Exist!!!!");
}
}