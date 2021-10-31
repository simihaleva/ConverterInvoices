package main.java;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {


	public static void main(String args[]) throws IOException {
		CSVConverter csvConverter = new CSVConverter();
		Collection<Buyer> entries =  new ArrayList<>();
		entries = csvConverter.read("src"+ File.separator +"main" + File.separator
				+"resources"+ File.separator +"invoices.csv");
		csvConverter.writeBuyersInDifferentSources(entries);
	}
}
