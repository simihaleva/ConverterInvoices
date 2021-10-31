package main.java;

import java.util.*;

/**
 * 
 * @author sofia
 * 
 * Object which describes a buyer with his name and
 * all the data for his invoices
 * 
 */
public class Buyer {
	
	String name;
	List<List<String>> invoices;
	
	public Buyer() {}
	
	public Buyer(String name, List<List<String>> invoices) {
		this.name = name;
		this.invoices = invoices;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<List<String>> getInvoices() {
		return invoices;
	}
	public void setAttributes(List<List<String>> invoices) {
		this.invoices = invoices;
	}
	
}
