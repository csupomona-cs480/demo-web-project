package edu.csupomona.cs480;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.csupomona.cs480.data.provider.FSUserManager;
import edu.csupomona.cs480.data.provider.FireSafetyProvider;
import edu.csupomona.cs480.data.provider.GpsProvider;
import edu.csupomona.cs480.data.provider.UserManager;
import edu.csupomona.cs480.data.provider.WalmartFireSafetyProvider;
import edu.csupomona.cs480.data.provider.WalmartGpsProvider;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

    /**
     * This is a good example of how Spring instantiates
     * objects. The instances generated from this method
     * will be used in this project, where the Autowired
     * annotation is applied.
     */
    @Bean
    public UserManager userManager() {
        UserManager userManager = new FSUserManager();
        return userManager;
    }
    
    @Bean
    public GpsProvider gpsProvider() {
    	GpsProvider gpsProvider = new WalmartGpsProvider();
    	return gpsProvider;
    }
   
    @Bean
    public FireSafetyProvider fireSafetyProvider() {
    	FireSafetyProvider fire = new WalmartFireSafetyProvider();
    	return fire;
    }
   

    /**
     * This is the running main method for the web application.
     * Please note that Spring requires that there is one and
     * ONLY one main method in your whole program. You can create
     * other main methods for testing or debugging purposes, but
     * you cannot put extra main method when building your project.
     */
    public static void main(String[] args) throws Exception {
        // Run Spring Boot
        SpringApplication.run(App.class, args);
    }
}
