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
}
