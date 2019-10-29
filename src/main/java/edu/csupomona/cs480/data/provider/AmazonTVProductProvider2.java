package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.TVItem;

public class AmazonTVProductProvider2 implements TVProductProvider {

	@Override
	public List<TVItem> listAllTvItems() {
		List<TVItem> tvItems = new ArrayList<TVItem>();
		Document doc;
		try {
			doc = Jsoup.connect("https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=4k+tv+samsung&_sacat=0").get();
			System.out.println(doc.title());
	    	
			List<String> titleList = new ArrayList<String>();
	    	Elements titleTags = doc.select("h3.s-item__title");
	    	for (Element headline : titleTags) {
	    	  System.out.println( headline.text());
	    	  titleList.add(headline.text());
	    	}
	    	
	    	List<String> priceList = new ArrayList<String>();
	    	Elements priceTags = doc.select("span.s-item__price");
	    	for (Element headline : priceTags) {
	    	  System.out.println( headline.text());
	    	  priceList.add(headline.text());
	    	}
	    	
	    	List<String> urlList = new ArrayList<String>();
	    	Elements imageTags = doc.select("img.s-item__image-img");
	    	for (Element headline : imageTags) {
	    	  System.out.println( headline.attr("src"));
	    	  urlList.add(headline.attr("src"));
	    	}
	    	
	    	for(int i = 0; i < 10; i++) {
	    		TVItem tvItem = new TVItem();
	    		tvItem.setTitle(titleList.get(i));
	    		tvItem.setPrice(priceList.get(i));
	    		tvItem.setImageUrl(urlList.get(i));
	    		tvItems.add(tvItem);
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return tvItems;
	}
	
//	public static void main(String[] args) {
//		AmazonTVProductProvider2 eBayTVPorductProvider = new AmazonTVProductProvider2();
//		System.out.println(eBayTVPorductProvider.listAllTvItems());
//	}

}
