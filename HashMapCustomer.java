package tester;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import static utility.CustomerUtility.*;
import ExceptionHandling.CustomerException;
import core.*;
import static utility.CustomerValidationRules.*;

import utility.CustomSort;
import utility.CustomerValidationRules;

public class HashMapCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Customer> customers = new HashMap<>();
			customers.putAll(populatedMap());
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("choose option : \n" + "1)sign up \n"
							+ "2)sign in \n3)display all customers sorted by email descending\n"
							+ "4)Reset Password \n5)Un Subscribe account\n"
							+ "6)Display all Customers who not paid since 6 month or more\n" + "0)Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter your details as follows : String email, " + "\nString fristName, "
								+ "\nString lastName, String password,"
								+ "\nplan[SILVER(1000), GOLD(2000), DIAMOND(5000), PLATANIUM(10000)]," + "\namnt"
								+ " Date(yyyy-mm-dd)");
						String email = sc.next();
							
						customers.put(email, checkInput(email, sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),
								sc.next(), customers));
						System.out.println("successfully registered!!!");
						break;
					case 2:
						System.out.println("Enter your email and password as respectively");
						signIn(sc.next(), sc.next(), customers);
						break;
					case 3:
						System.out.println("Display all Customer sorted by email in desending order");
						sortEMail(customers);
						break;
					case 4:
						System.out.println("for Change password,Enter email,old password,new password");
						Customer c = signIn(sc.next(), sc.next(), customers);
						c.setPassword(sc.next());
						break;
					case 5:System.out.println("Enter Email and Password");
					 email = sc.next();
					 signIn(email,sc.next(), customers);
					 System.out.println("remove element is : "+customers.remove(email));
					 System.out.println("after removal all CUstomers are ");
					 sortEMail(customers);
						break;
					case 6:System.out.println("all Customers who not paid since 6 month old or more...");
					      specificCustomers(customers); 
						break;
					case 0:
						System.out.println("Thank you!!!");
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}
}
