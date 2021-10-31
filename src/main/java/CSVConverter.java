package main.java;

import java.io.*;
import java.util.*;

/**
 * 
 * @author sofia
 *
 * Implementation of the interface Converter for CSV files
 */

public class CSVConverter implements Converter {


	/**
	 *  separator character for columns. 
	 */
	public static final String COLUMN_SEPARATOR =",";
	
	private static List<String> headerLine;
	
	@Override
	public Collection<Buyer> read(String source) throws IOException {
		Map<String, Buyer> map = new HashMap<>();

		try (BufferedReader buffReader = new BufferedReader(new FileReader(source))) {
		  
		    String header = buffReader.readLine();
		    String[] valuesOnFirstRow = header.split(COLUMN_SEPARATOR);
		    headerLine = Arrays.asList(valuesOnFirstRow);
		    
		    String line;
		    while ((line = buffReader.readLine()) != null) {
		        String[] valuesOnCurrentRow = line.split(COLUMN_SEPARATOR);
		        
		        if(!map.containsKey(valuesOnCurrentRow[0])) {
		        	List<List<String>> invoices = new ArrayList<>();
		        	invoices.add(Arrays.asList(valuesOnCurrentRow));
		        	Buyer buyer = new Buyer(valuesOnCurrentRow[0],invoices);
		        	map.put(valuesOnCurrentRow[0], buyer);
		        }
		        
		        else {
		        	Buyer buyer = map.get(valuesOnCurrentRow[0]);
		        	List<List<String>> invoices = buyer.getInvoices();
		        	invoices.add(Arrays.asList(valuesOnCurrentRow));
		        	buyer.setAttributes(invoices);
		        	map.put(valuesOnCurrentRow[0], buyer);
		        }
		    }
		}
		
		return map.values();
	}

	@Override
	public void writeBuyersInDifferentSources(Collection<Buyer> buyers) throws IOException {

		for (Buyer buyer : buyers) {
			FileWriter csvWriter = new FileWriter(buyer.getName() + ".csv");
			csvWriter.append(String.join(COLUMN_SEPARATOR, headerLine));
			csvWriter.append("\n");
			
			for (List<String> row : buyer.getInvoices()) {
				csvWriter.append(String.join(COLUMN_SEPARATOR, row));
				csvWriter.append("\n");
			}
			
			csvWriter.flush();
			csvWriter.close();
		}

	}


}
