package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.configuration.RepositoryConfiguration;
import edu.csupomona.cs480.data.entity.Flashcard;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class FlashcardRepositoryTest {
    private FlashcardRepository flashcardRepository;

    @Autowired
    public void setFlashcardRepository(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    /**
     * Test that a flashcard can be saved
     */
    @Test
    public void testSaveFlashcard1() {
        Flashcard flashcard = new Flashcard();
        flashcard.setSetId("Famous Software Developers");
        flashcard.setTerm("Linus Torvald");
        assertNotNull(flashcard.getTerm());
        flashcardRepository.save(flashcard);
        assertEquals(flashcardRepository.findBySetId("Famous Software Developers").get(0).getTerm(), flashcard.getTerm());
    }
    
    @Test
    public void testSaveFlashcard2() {
    	Flashcard expectedFlashcard = new Flashcard();
    	expectedFlashcard.setTerm("Binary Search Tree");
    	expectedFlashcard.setDefinition("We learn this just because of the interview");
    	flashcardRepository.save(expectedFlashcard);
    	Flashcard actualFlashcard = flashcardRepository.findOne(expectedFlashcard.getId());
    	assertEquals(expectedFlashcard.getTerm(), actualFlashcard.getTerm());
    	assertEquals(expectedFlashcard.getDefinition(), actualFlashcard.getDefinition());
    }
    
    @Test
    public void testDeleteFlashcard() {
    	Flashcard expectedFlashcard = new Flashcard();
    	expectedFlashcard.setTerm("Binary Search Tree");
    	expectedFlashcard.setDefinition("We learn this just because of the interview");
    	flashcardRepository.save(expectedFlashcard);
    	flashcardRepository.delete(expectedFlashcard.getId());
    	Flashcard actualFlashcard = flashcardRepository.findOne(expectedFlashcard.getId());
    	assertNull(actualFlashcard);
    	assertEquals(flashcardRepository.count(), 0);
    }
}
