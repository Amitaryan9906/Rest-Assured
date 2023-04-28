package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlayLoadConverting {

	public static String generatePlayloadString(String fileName) throws IOException {
    String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\"+fileName;
    
    return new String(Files.readAllBytes(Paths.get(filePath)));
	}
}
