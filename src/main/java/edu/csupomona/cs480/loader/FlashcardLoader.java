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
        String bioId = UUID.randomUUID().toString();
        log.info("uuid -- " + bioId);
        bio.setSetId(bioId);
        bio.setUserId("1");
        bio.setTitle("Bio");
        flashcardRepository.save(bio);
        log.info("Saved Bio Card - id" + bio.getId() + " "  + bio.getTerm());

        String set1Id = UUID.randomUUID().toString();
        log.info("uuid -- " + set1Id);

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


        set1Id = UUID.randomUUID().toString();
        log.info("uuid -- " + set1Id);

        Flashcard music1 = new Flashcard();
        music1.setTerm("Mozart");
        music1.setDefinition("Classical");
        music1.setSetId(set1Id);
        music1.setUserId("2");
        music1.setTitle("Music");
        flashcardRepository.save(music1);
        log.info("Saved music1 Card - id" + music1.getId() + " "  + music1.getTerm());

        Flashcard music2 = new Flashcard();
        music2.setTerm("Kanye West");
        music2.setDefinition("Rap");
        music2.setSetId(set1Id);
        music2.setUserId("2");
        music2.setTitle("Music");
        flashcardRepository.save(music2);
        log.info("Saved music2 Card - id" + music2.getId() + " "  + music2.getTerm());

        Flashcard music3 = new Flashcard();
        music3.setTerm("Taylor Swift");
        music3.setDefinition("Pop");
        music3.setSetId(set1Id);
        music3.setUserId("2");
        music3.setTitle("Music");
        flashcardRepository.save(music3);
        log.info("Saved music3 Card - id" + music3.getId() + " "  + music3.getTerm());



    }
}
