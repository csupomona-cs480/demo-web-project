package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.FireSafetyItem;

public class WalmartFireSafetyProvider implements FireSafetyProvider {

	@Override
	public List<FireSafetyItem> listFireSafetyItems() {
		List<FireSafetyItem> fireSafetyItems = new ArrayList<>();
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.walmart.com/browse/home-improvement/fire-safety/1072864_1068865_1231051").get();

			System.out.println(doc.title());
			List<String> nameList = new ArrayList<>();
			Elements newsHeadlines = doc.select("a.product-title-link");
			for (Element headline : newsHeadlines) {
				System.out.println(headline.attr("aria-label"));
				nameList.add(headline.attr("aria-label"));
			}

			List<String> priceList = new ArrayList<>();
			Elements priceTags = doc.select("span.price-characteristic");
			for (Element price : priceTags) {
				System.out.println(price.text());
				priceList.add("$" + price.text() + ".00");
			}

			List<String> imageUrlList = new ArrayList<>();
			Elements imageTags = doc.select("img.prod-product-card--image-src");
			for (Element image : imageTags) {
				System.out.println(image.attr("src"));
				imageUrlList.add(image.attr("src"));
			}
			
			for(int i = 0; i < 10; i++) {
				FireSafetyItem fireSafetyItem = new FireSafetyItem();
				fireSafetyItem.setName(nameList.get(i));
				fireSafetyItem.setPrice(priceList.get(i));
				fireSafetyItem.setImageUrl(imageUrlList.get(i));
				fireSafetyItems.add(fireSafetyItem);
			}
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return fireSafetyItems;
	}

}
