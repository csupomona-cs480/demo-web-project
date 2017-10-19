package edu.csupomona.cs480.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csupomona.cs480.data.FlashCardSet;
import edu.csupomona.cs480.data.provider.FlashCardSetManager;
import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.random.JDKRandomGenerator;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.UniformRandomGenerator;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.UserManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
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
	private FlashCardSetManager flashCardSetManager;

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	@RequestMapping(value = "/cs480/greetings", method = RequestMethod.GET)
	String greeting() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Hello User. How are you?";
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
	/**
	 * This API displays the total number of users in the current database.
	 * 
	 * @return the total number of users in the database
	 */
	@RequestMapping(value = "/cs480/users/total", method = RequestMethod.GET)
	int getTotalUsers(){
		return userManager.listAllUsers().size();
	}

    /**
     * This API displays the student userIds with queried major.
     */
    @RequestMapping(value = "/cs480/major/{major}", method = RequestMethod.GET)
    List<User> getMajors(@PathVariable("major") String major) {
        List<User> allUsers = listAllUsers();
        List<User> withMajor = new ArrayList<>();
        for(int i = 0; i < allUsers.size(); i++) {
            User current = allUsers.get(i);
            if (current.getMajor().equals(major)) {
                withMajor.add(current);
            }
        }
        return withMajor;
    }
    @RequestMapping(value = "/cs480/users/pdf", method = RequestMethod.GET)
    void getPdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("application/pdf");
            try {
                // step 1
                Document document = new Document();
                // step 2
                PdfWriter.getInstance(document, response.getOutputStream());
                // step 3
                document.open();
                // step 4
                document.add(new Paragraph("Current Users in Database as of "+new Date().toString()+":"));
                for(User user : userManager.listAllUsers())
                	document.add(new Paragraph(user.getName()));
                // step 5
                document.close();
            } catch (DocumentException de) {
                throw new IOException(de.getMessage());
            }
        }
    
    

	/**
	 * Usage of Java Joda-Time library to display a Joda-Time DateTime object from a
     * less detailed java.util.Date object
	 * @return Joda-Time date containing day, month, year, hour, sec, etc...
	 */
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	DateTime currentDateTime() {
    	return new DateTime(new Date());
	}
	
	/**
	 * Usage of Java Jsoup to parse all stories from hacker news, a news website
	 */
	@RequestMapping(value = "/hackernews", method = RequestMethod.GET) 
	String latestNews() throws IOException {
		org.jsoup.nodes.Document doc = Jsoup.connect("https://news.ycombinator.com/").get();
		Elements newsHeadline = doc.select("a.storylink");
		return newsHeadline.toString();
	}

	/**
	 * Usage of Java Apache Math Commons to do some simple complex arithmetic
	 */
	@RequestMapping(value = "/complexmath", method = RequestMethod.GET)
	String randomComplexSum() {
		UniformRandomGenerator random = new UniformRandomGenerator(new JDKRandomGenerator());
		Complex complex1 = new Complex(random.nextNormalizedDouble(), random.nextNormalizedDouble());
		Complex complex2 = new Complex(random.nextNormalizedDouble(), random.nextNormalizedDouble());
		Complex complexSum = complex1.add(complex2);
		return "[ " + complex1.getReal() + ", " +  + complex1.getImaginary() + " ] + [ " + complex2.getReal() + ", " +  + complex2.getImaginary() + " ] = [ " + complexSum.getReal() + ", " +  + complexSum.getImaginary() + " ]" ;
	}


	//Actual project code starts here


	/**
	 * @param id the id of the wanted set
	 * @return the full body of the wanted set
	 */
	@RequestMapping(value = "/set/{id}", method = RequestMethod.GET)
	FlashCardSet getSet(@PathVariable("id") String id) {
		FlashCardSet f = flashCardSetManager.getFlashCardSet(id);

		//Here the object is successfully parsed automatically
		return f;
	}


	/**
	 * @return whether the set was successfully changed or not
	 */
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	boolean updateSet(@RequestBody String flashCardSetJSON) {

		//TODO: Get automatic parsing of the JSON to work
		//Manual parsing of the inbound JSON
		FlashCardSet flashCardSet = flashCardSetManager.parseJSON(flashCardSetJSON);

		if (flashCardSet != null) {
			flashCardSetManager.updateFlashCardSet(flashCardSet);
			return true;
		}
		return false;
	}


	/**
	 * @return a list of all of the id, name pairs
	 */
	@RequestMapping(value = "/sets", method = RequestMethod.GET)
	List<String[]> getAllSetIdNamePairs() {
		return flashCardSetManager.listAllFlashCardSetIdNamePairs();
	}


	/**
	 * @param id the id of the set you want to delete
	 */
	@RequestMapping(value = "/set/{id}", method = RequestMethod.DELETE)
	void deleteSet(@PathVariable("id") String id) {
		flashCardSetManager.deleteFlashCardSet(id);
	}

}