package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.GpsItem;

public class WalmartGpsProvider implements GpsProvider {

	@Override
	public List<GpsItem> listAllGpsItems() {
		List<GpsItem> gpsList = new ArrayList<>();
		List<String> priceList = new ArrayList<>();
		List<String> nameList = new ArrayList<>();
		List<String> imageList = new ArrayList<>();
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.walmart.com/search/?query=gps").get();

			
			System.out.println(doc.title());
			Elements newsHeadlines = doc.select("span.price-characteristic");
			for (Element headline : newsHeadlines) {
				System.out.println(headline.text());
				priceList.add(headline.text());
			}

			Elements names = doc.select("a.product-title-link span");
			for (Element name : names) {
				System.out.println(name.text());
				nameList.add(name.text());
			}

			Elements images = doc.select("img.prod-product-card--image-src");
			for (Element image : images) {
				System.out.println(image.attr("src"));
				imageList.add(image.attr("src"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ;i < 15; i++) {
			GpsItem gps = new GpsItem();
			gps.setName(nameList.get(i));
			gps.setPrice("$" + priceList.get(i));
			gps.setImageUrl(imageList.get(i));
			gpsList.add(gps);
		}
		return gpsList;
	}

}
