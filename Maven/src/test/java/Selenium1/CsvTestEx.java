package Selenium1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class CsvTestEx {
	
	@Test
	public void demo() throws IOException, CsvException {
		FileReader file=new FileReader("./Data/Book1.csv");
		CSVReader reader=new CSVReader(file);
		List<String[]> str = reader.readAll();
		reader.readNext();
		
		for (String[] strings : str) {
			for (String strings2 : strings) {
				System.out.println(strings2);
			}
		}
		
		FileWriter file1=new FileWriter("./Data/Book2.csv");
		CSVWriter write=new CSVWriter(file1);
		String[] headling= {"name","id"};
		String[] name= {"Qsp","123"};
		String[] name1= {"Jsp","369"};
		String[] name2= {"Pysp","269"};
		
		write.writeNext(headling);
		write.writeNext(name);
		write.writeNext(name1);
		write.writeNext(name2);
		
		write.flush();
	}

}
