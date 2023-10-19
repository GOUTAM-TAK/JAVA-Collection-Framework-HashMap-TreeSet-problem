package utility;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import core.Customer;
import core.ServicePlan;

public class CustomerUtility {
	public static void sortEMail(Map<String, Customer> customers) {
		TreeSet<Customer> sortCustomer = new TreeSet<>(new CustomSort());
		sortCustomer.addAll(customers.values());
		for (Customer cs : sortCustomer)
			System.out.println(cs);
	}
	public static Map<String,Customer> populatedMap(){
		Map<String,Customer>list = new HashMap<>();
		list.put("goutam",new Customer("goutam","gou","tak","rock",ServicePlan.valueOf("SILVER"),1000,LocalDate.parse("2019-09-17")));
		list.put("govinda",new Customer("govinda","gov","tak","cdac",ServicePlan.valueOf("GOLD"),2000,LocalDate.parse("2020-09-21")));
		list.put("aayush",new Customer("aayush","aay","kum","kumar",ServicePlan.valueOf("PLATANIUM"),5000,LocalDate.parse("2023-10-17")));
	return list;
	}
	public static void specificCustomers(Map<String,Customer>customers) {
		TreeSet<Customer>list = new TreeSet<>();
		
		list.addAll(customers.values());
		LocalDate today =LocalDate.now();
		for(Customer c :list) {
			if(Period.between(c.getDate(), today).toTotalMonths()>6)
                 System.out.println(c);
		}
	}
}
