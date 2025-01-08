package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reading_Logindata {
	Properties prop;
	public Reading_Logindata() {
		File file=new File("C:\\Users\\Hp\\eclipse-workspace\\Automatiopractice\\Configuration\\data.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getUsername() {
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}
	public String getAmount() {
		String amount=prop.getProperty("amount");
		return amount;
	}

}
