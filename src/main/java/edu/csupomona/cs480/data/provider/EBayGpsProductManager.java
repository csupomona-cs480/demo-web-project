package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.GpsProduct;

public class EBayGpsProductManager implements GpsProductManager {

	@Override
	public List<GpsProduct> listAllGpsProducts() {
		List<GpsProduct> productList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			productList.add(new GpsProduct());
		}
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.ebay.com/sch/i.html?_from=R40&_trksid=p2050601.m570.l1313.TR0.TRC0.H0.Xgps.TRS0&_nkw=gps&_sacat=0").get();
			Elements products = doc.select("h3.lvtitle a.vip");

			for(int i = 0; i < 10; i++) {
				System.out.println(products.get(i).text());
				productList.get(i).setName(products.get(i).text());
			}

			products = doc.select("li.lvprice span.bold");
			for(int i = 0; i < 10; i++) {
				System.out.println(products.get(i).text());
				productList.get(i).setPrice(products.get(i).text());
			}

			products = doc.select("div.lvpicinner img.img");
			for(int i = 0; i < 10; i++) {
				System.out.println(products.get(i).attr("src"));
				productList.get(i).setImgUrl(products.get(i).attr("src"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productList;
	}

}
