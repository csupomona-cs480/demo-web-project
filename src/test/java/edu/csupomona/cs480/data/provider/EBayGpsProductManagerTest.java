package edu.csupomona.cs480.data.provider;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.csupomona.cs480.data.GpsProduct;

public class EBayGpsProductManagerTest {

	@Test
	public void testListAllGpsProducts() {
		EBayGpsProductManager ebBayGpsProductManager = new EBayGpsProductManager();
		List<GpsProduct> gpsProducts = ebBayGpsProductManager.listAllGpsProducts();
		Assert.assertNotNull(gpsProducts);
		Assert.assertEquals(10, gpsProducts.size());

		GpsProduct firstGps = gpsProducts.get(0);
		Assert.assertNotNull(firstGps);
		Assert.assertEquals("$99.99", firstGps.getPrice());
		Assert.assertTrue(firstGps.getTitle().contains("2589LMT"));
	}
}
