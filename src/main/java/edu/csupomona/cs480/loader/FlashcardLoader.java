package edu.csupomona.cs480.loader;

import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.data.repository.FlashcardRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Loads defined FlashCards each start in database
 */
@Component
public class FlashcardLoader implements ApplicationListener<ContextRefreshedEvent>{

    private FlashcardRepository flashcardRepository;
    private Logger log = Logger.getLogger(FlashcardLoader.class);

    @Autowired
    public void setFlashcardRepository(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Flashcard bio = new Flashcard();
        bio.setTerm("Fish");
        bio.setDefinition("Animal that lives in water.");
        bio.setSetId(UUID.randomUUID().toString());
        bio.setUserId("1");
        bio.setTitle("Bio");
        flashcardRepository.save(bio);
        log.info("Saved Bio Card - id" + bio.getId() + " "  + bio.getTerm());

        String set1Id = UUID.randomUUID().toString();

        Flashcard history1 = new Flashcard();
        history1.setTerm("First President");
        history1.setDefinition("George Washington.");
        history1.setSetId(set1Id);
        history1.setUserId("2");
        history1.setTitle("History");
        flashcardRepository.save(history1);
        log.info("Saved history1 Card - id" + history1.getId() + " "  + history1.getTerm());

        Flashcard history2 = new Flashcard();
        history2.setTerm("Second President");
        history2.setDefinition("John Adams.");
        history2.setSetId(set1Id);
        history2.setUserId("2");
        history2.setTitle("History");
        flashcardRepository.save(history2);
        log.info("Saved history2 Card - id" + history2.getId() + " "  + history2.getTerm());

        Flashcard history3 = new Flashcard();
        history3.setTerm("Third President");
        history3.setDefinition("Thomas Jefferson.");
        history3.setSetId(set1Id);
        history3.setUserId("2");
        history3.setTitle("History");
        flashcardRepository.save(history3);
        log.info("Saved history3 Card - id" + history3.getId() + " "  + history3.getTerm());





    }
}
