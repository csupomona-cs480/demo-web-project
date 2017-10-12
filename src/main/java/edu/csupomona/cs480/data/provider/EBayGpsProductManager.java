package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.GpsProduct;

public class EBayGpsProductManager implements GpsProductManager {

	@Override
	public List<GpsProduct> listAllGpsProducts() {
		List<GpsProduct> gpsProducts = new ArrayList<>();
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR12.TRC2.A0.H0.Xgps.TRS0&_nkw=gps&_sacat=0").get();
			
			Elements newsHeadlines = doc.select("ul li span.bold");
			System.out.println(newsHeadlines);
			for(int i = 0; i < 10; i++) {
				GpsProduct gpsProduct = new GpsProduct();
				gpsProduct.setPrice(newsHeadlines.get(i).text());
				gpsProducts.add(gpsProduct);
			}
			
			for(int i = 0; i < 10; i++) {
				Elements titles = doc.select("h3.lvtitle a");
				System.out.println(titles);
				gpsProducts.get(i).setTitle(titles.get(i).text());
			}
			
			for(int i = 0; i < 10; i++) {
				Elements imageUrls = doc.select("div.lvpicinner a img");
				System.out.println(imageUrls);
				gpsProducts.get(i).setImageUrl(imageUrls.get(i).attr("src"));
			}					

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(gpsProducts);
		return gpsProducts;
	}
	
	public static void main(String[] args) {
		EBayGpsProductManager m = new EBayGpsProductManager();
		m.listAllGpsProducts();
	}

}
