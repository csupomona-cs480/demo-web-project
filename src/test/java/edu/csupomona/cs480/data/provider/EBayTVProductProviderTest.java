package edu.csupomona.cs480.data.provider;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.csupomona.cs480.data.TVItem;

public class EBayTVProductProviderTest {

	@Test
	public void testListAllTvItems() {
		EBayTVProductProvider eBayTVPorductProvider = new EBayTVProductProvider();
		List<TVItem> tvItems = eBayTVPorductProvider.listAllTvItems();
		Assert.assertEquals(10, tvItems.size());
		for(TVItem tv : tvItems) {
			Assert.assertNotNull(tv);
			Assert.assertNotNull(tv.getTitle());
			Assert.assertNotNull(tv.getPrice());
			Assert.assertNotNull(tv.getImageUrl());
			Assert.assertTrue(tv.getImageUrl().startsWith("http"));
		}
	}
}
