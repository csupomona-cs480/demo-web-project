package edu.csupomona.cs480.data.provider;

import java.util.List;

import org.junit.Test;

import edu.csupomona.cs480.data.GpsProduct;
import org.junit.Assert;

public class EBayGpsProductManagerTest {

	@Test
	public void testListAllGpsProducts() {
		EBayGpsProductManager eBayGpsProductManager = new EBayGpsProductManager();
		List<GpsProduct> gpsProductList = eBayGpsProductManager.listAllGpsProducts();
		Assert.assertEquals(10, gpsProductList.size());
		
		for(GpsProduct gps : gpsProductList) {
			Assert.assertNotNull(gps);
			Assert.assertTrue(!gps.getName().isEmpty());
			Assert.assertTrue(!gps.getImgUrl().isEmpty() && gps.getImgUrl().startsWith("http"));
			Assert.assertTrue(!gps.getPrice().isEmpty());
		}
		
		int counter = 0;
		for(boolean b : EBayGpsProductManager.lines) {
			if (b) {
				counter++;
			}
		}
		System.out.println(counter + " / " + EBayGpsProductManager.lines.length);
		Assert.fail("for test");
	}
}
