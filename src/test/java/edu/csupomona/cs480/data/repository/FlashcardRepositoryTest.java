package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.configuration.RepositoryConfiguration;
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


}
