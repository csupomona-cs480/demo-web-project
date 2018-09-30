package edu.csupomona.cs480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.GpsProduct;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.GpsProductManager;
import edu.csupomona.cs480.data.provider.UserManager;
// Warren Xie - Google Guava Library Import
import com.google.common.base.Optional;

// Joshua Yi - Commons IO Library Import
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;

//Brandon Wong - Commons Text
import org.apache.commons.text;

// YeukNam Lam - Commons Math Library Import
// Import common PRNG interface and factory class that instantiates the PRNG.
//import org.apache.commons.rng.UniformRandomProvider;
//import org.apache.commons.rng.RandomSource;

/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;
	@Autowired
	private GpsProductManager gpsProductManager;
	
	@RequestMapping(value = "/codingronin/thetsoe", method = RequestMethod.GET)
	String tpsoeCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Thet Soe";
	}
	
	@RequestMapping(value ="/codingronin/warren", method = RequestMethod.GET)
	String warrenRonin() {
		return "One for All!";
	}
	@RequestMapping(value = "/codingronin/yo_its_brandon", method = RequestMethod.GET)
	String namePrint2() {
		//run with application locally to check your changes with the URL: http://localhost.8080/
		return "Brandon's here!";
	
	}
	
	@RequestMapping(value = "/codingronin/YeukNam Lam", method = RequestMethod.GET)
	String namePrint() {
		//run with application locally to check your changes with the URL: http://localhost.8080/
		return "This is YeukNam Lam, Did you guys fork the whole project to your PC?";
	}
	

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs580/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK-CS480-Demo";
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}
	
	@RequestMapping(value = "/cs480/gps/list", method = RequestMethod.GET)
	List<GpsProduct> listGpsProducts() {
		return gpsProductManager.listAllGpsProducts();
	}

	/**
	 * This API returns the size of the User List
	 * http://localhost:8080/cs480/users/size
	 * Author: Joshua Yi - ChipuChipu
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/size", method = RequestMethod.GET)
	int getNumOfUsers() {
		try
		{
			return userManager.listAllUsers().size();
		}
		catch (Exception e) {return -1;}
	}
	
	@RequestMapping(value = "/cs480/gps/size", method = RequestMethod.GET)
	int getNumOfGpsProducts() {
		try
		{
			return gpsProductManager.listAllGpsProducts().size();
		}
		catch (Exception e) {return -1;}
	}
	
	/**
	 * This API returns a string read in from Google.com
	 * Uses Apache Commons IO Library
	 * http://localhost:8080/cs480/users/readGoogleUrl
	 * Author: Joshua Yi - ChipuChipu
	 * @return
	 */	
	@RequestMapping(value = "/cs480/users/readGoogleUrl", method = RequestMethod.GET)
	String readGoogleUrl()
	{
		
		try
		{
			InputStream in = new URL("https://google.com").openStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inR);
			String line = br.readLine();
			int index = line.indexOf("<head>");
			int endIndex = line.indexOf("name");
			String subLine = line.substring(index, endIndex);
			
			System.out.println("Size of subLine:" + subLine.length());
			return "SUCCESS!";
			
		} catch(Exception e) 
		{
			e.printStackTrace();
			return "FAILED!";
		}
	}
	
	/*
	 * Warren Xie 
	 */
	@RequestMapping(value = "cs480/users/readWarren", method = RequestMethod.GET)
	Integer guavaTesting() {
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		
		
		Optional<Integer> a = Optional.fromNullable(value1);
		Optional<Integer> b = Optional.of(value2);
		
		return sum(a,b);
	}
	
	/*
	 * Brandon Wong
	 */
	@RequestMapping(value = "cs480/users/RandomText", method = RequestMethod.GET)
	String randString() {
		String s = "";
		s.generate(10);
		return s; 
	}
	
	public Integer sum( Optional<Integer>a,Optional<Integer>b) {
		System.out.println("A is: "+ a.isPresent());
		
		System.out.println("B is: "+b.isPresent());
		
		Integer value1 = a.or(new Integer(0));
		
		Integer value2 = b.get();
		
		return value1 + value2;
	}
	
	/*
	 * This API generate a randon number with Gaussian method
	 * Uses Apache Commons Math Library
	 * http://localhost:8080/cs480/users/randomNum
	 * Author: YeukNam Lam
	 * @ return
	 */
	/*
	@RequestMapping(value = "/cs480/users/randomNum", method = RequestMethod.GET)
	string randomNum()
	{
		// Create (and possibly seed) a PRNG (could use any of the CM-provided generators).
		long seed = 17399225432L; // Fixed seed means same results every time 
		UniformRandomProvider rg = RandomSource.create(RandomSource.MT, seed);

		// Create a GaussianRandomGenerator using "rg" as its source of randomness.
		GaussianRandomGenerator rawGenerator = new GaussianRandomGenerator(rg);

		// Create a CorrelatedRandomVectorGenerator using "rawGenerator" for the components.
		CorrelatedRandomVectorGenerator generator = 
   		new CorrelatedRandomVectorGenerator(mean, covariance, 1.0e-12 * covariance.getNorm(), rawGenerator);
		
		return "Not Finish";
	}
	*/
	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}

}
