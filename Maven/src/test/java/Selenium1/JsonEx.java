package Selenium1;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonEx {
	
	@Test
	public void demo() throws IOException, ParseException {
		FileReader file=new FileReader("./Data/Demo.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(file);
		JSONObject json=(JSONObject) obj;
		System.out.println(json.get("name"));
		System.out.println(json.get("url"));
		System.out.println(json.get("email"));
		System.out.println(json.get("password"));
		System.out.println(json.get("boolean"));
		System.out.println(json.get("hobbies"));
		System.out.println(json.get("songs.song1"));
	}

}
