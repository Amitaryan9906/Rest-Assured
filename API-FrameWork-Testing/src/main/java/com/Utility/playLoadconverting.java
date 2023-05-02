package com.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class playLoadconverting {
	public static String generatePlayloadString(String fileName) throws IOException {
	    String filePath=System.getProperty("user.dir")+"//src//main//java//com//resources//"+fileName;
	    
	    return new String(Files.readAllBytes(Paths.get(filePath)));
		}
}
