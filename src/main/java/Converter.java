package main.java;

import java.io.IOException;
import java.util.*;

public interface Converter {
	
	/**
	 * Reads from source to collection of buyers
	 * @param source - name of source with data for buyers
	 * @return collection of buyers
	 * @throws IOException 
	 */
	public Collection<Buyer> read(String source) throws IOException;
	
	/**
	 * Writes the collection of buyers to different source for each buyer
	 * @param buyers
	 */
	public void writeBuyersInDifferentSources(Collection<Buyer> buyers) throws IOException;


}
