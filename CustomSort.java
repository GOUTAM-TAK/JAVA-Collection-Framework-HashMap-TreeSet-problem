package utility;

import java.util.Comparator;

import core.Customer;

public class CustomSort implements Comparator<Customer> {
        @Override       
	public int compare(Customer c1,Customer c2) {
            	  return c2.getEmail().compareTo(c1.getEmail()); 
               }
}
