package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }
    public String getUserName(){
        String email=pro.getProperty("username");
        return email;

    }
    public String getPassword(){
        String password=pro.getProperty("password");
        return password;

    }
    public String getChromePath(){
        String chromepath=pro.getProperty("chromepath");
        return chromepath;
    }
}
