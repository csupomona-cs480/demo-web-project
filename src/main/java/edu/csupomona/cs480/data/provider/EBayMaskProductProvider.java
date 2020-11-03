package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.MaskProduct;

public class EBayMaskProductProvider implements MaskProductProvider {

	@Override
	public List<MaskProduct> listAllMaskProducts() {
		List<MaskProduct> maskList = new ArrayList<>();		
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=mask&_sacat=0").get();
			
			// get all the titles
			List<String> titleList = new ArrayList<>();
			Elements titleDivs = doc.select("h3.s-item__title");
			for (Element titleDiv : titleDivs) {
				System.out.println(titleDiv.text());
				titleList.add(titleDiv.text());
			}

			// get all the prices
			List<String> priceList = new ArrayList<>();
			Elements priceDivs = doc.select("span.s-item__price");
			for (Element priceDiv : priceDivs) {
				System.out.println(priceDiv.text());
				priceList.add(priceDiv.text());
			}

			// get all the prices
			List<String> imageList = new ArrayList<>();
			Elements imageDivs = doc.select("img.s-item__image-img");
			for (Element imageDiv : imageDivs) {
				System.out.println(imageDiv.attr("src"));
				imageList.add(imageDiv.attr("src"));
			}
			
			for(int i = 0; i < 20; i++) {
				MaskProduct mask = new MaskProduct();
				mask.setTitle(titleList.get(i));
				mask.setPrice(priceList.get(i));
				mask.setImageUrl(imageList.get(i));
				maskList.add(mask);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maskList;
	}

}
