package edu.csupomona.cs480;

import edu.csupomona.cs480.data.FlashCardSet;
import edu.csupomona.cs480.data.provider.FSFlashCardSetManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class FSFlashCardSetManagerTest {

	private FSFlashCardSetManager fs = new FSFlashCardSetManager();

	@Test
	public void testFlashCardSetManagerCreationAndGet(){
		FlashCardSet f = new FlashCardSet();
		f.setName("Test");
		f.setId("Test ID 1");
		f.setUser("Test User");
		fs.updateFlashCardSet(f);
		FlashCardSet get = fs.getFlashCardSet("Test ID 1");
		assertEquals(f.getName(), get.getName());
		assertEquals(f.getId(), get.getId());
		assertEquals(f.getUser(), get.getUser());
	}

	@Test
	public void testSerializationAndDeserialization(){
		FlashCardSet f = new FlashCardSet();
		f.setName("Test");
		f.setId("Test ID 1");
		f.setUser("Test User");
		String s = fs.serializeJSON(f);
		FlashCardSet get = fs.parseJSON(s);
		assertEquals(f.getName(), get.getName());
		assertEquals(f.getId(), get.getId());
		assertEquals(f.getUser(), get.getUser());
	}

	@Test
	public void testDeletion(){
		FlashCardSet f1 = fs.getFlashCardSet("Test ID 1");
		fs.deleteFlashCardSet("Test ID 1");
		FlashCardSet f2 = fs.getFlashCardSet("Test ID 1");
		assertNotNull(f1);
		assertNull(f2);
	}

}
