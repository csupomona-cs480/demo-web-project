package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.GPSItem;

public class DefaultGPSPriceProvider implements GPSPriceProvider {


	@Override
	public List<GPSItem> listAllGPSItems() {
		List<GPSItem> items = new ArrayList<GPSItem>();

		Document doc;
		try {

			// need http protocol
			doc = Jsoup.connect("http://www.ebay.com/sch/Garmin-Vehicle-Electronics-and-GPS/3270/bn_883221/i.html").get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements prices = doc.select("li.lvprice.prc");
			for (Element price : prices) {
				// get the value from href attribute
				// System.out.println("\nlink : " + link.attr("href"));
				System.out.println("text : " + price.text());
			}

			Elements names = doc.select("h3.lvtitle");
			for (Element name : names) {
				// get the value from href attribute
				// System.out.println("\nlink : " + link.attr("href"));
				System.out.println("text : " + name.text());
			}

			for(int i = 0; i < prices.size(); i++) {
				items.add(new GPSItem(names.get(i).text(), prices.get(i).text()));
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
