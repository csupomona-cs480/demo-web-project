package edu.csupomona.cs480.data.provider;

import java.util.List;

import org.junit.Test;

import edu.csupomona.cs480.data.FireSafetyItem;
import org.junit.Assert;

public class WalmartFireSafetyProviderTest {

	@Test
	public void testListFireSafetyItems() {
		WalmartFireSafetyProvider walmartFireSafetyProvider
				= new WalmartFireSafetyProvider();
		List<FireSafetyItem> items = walmartFireSafetyProvider.listFireSafetyItems();
		Assert.assertEquals(10, items.size());
	}
}
