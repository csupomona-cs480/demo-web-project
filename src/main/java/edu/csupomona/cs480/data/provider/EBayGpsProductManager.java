package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.GpsProduct;

public class EBayGpsProductManager implements GpsProductManager {

	public static boolean[] lines = new boolean[20];
	
	@Override
	public List<GpsProduct> listAllGpsProducts() {
		lines[0] = true;
		List<GpsProduct> productList = new ArrayList<>();
		lines[1] = true;
		for(int i = 0; i < 10; i++) {
			lines[2] = true;
			productList.add(new GpsProduct());
		}
		
		lines[3] = true;
		Document doc;
		
		lines[4] = true;
		try {
			
			lines[5] = true;
			doc = Jsoup.connect("http://www.ebay.com/sch/i.html?_from=R40&_trksid=p2050601.m570.l1313.TR0.TRC0.H0.Xgps.TRS0&_nkw=gps&_sacat=0").get();
			lines[6] = true;
			Elements products = doc.select("h3.lvtitle a.vip");
			lines[7] = true;
			for(int i = 0; i < 10; i++) {
				lines[8] = true;
				System.out.println(products.get(i).text());
				lines[9] = true;
				productList.get(i).setName(products.get(i).text());
			}

			lines[10] = true;
			products = doc.select("li.lvprice span.bold");
			lines[11] = true;
			for(int i = 0; i < 10; i++) {
				lines[12] = true;
				System.out.println(products.get(i).text());
				lines[13] = true;
				productList.get(i).setPrice(products.get(i).text());
			}

			lines[14] = true;
			products = doc.select("div.lvpicinner img.img");
			lines[15] = true;
			for(int i = 0; i < 10; i++) {
				lines[16] = true;
				System.out.println(products.get(i).attr("src"));
				lines[17] = true;
				productList.get(i).setImgUrl(products.get(i).attr("src"));
			}
		} catch (IOException e) {
			lines[18] = true;
			e.printStackTrace();
		}
		lines[19] = true;
		return productList;
	}

}
