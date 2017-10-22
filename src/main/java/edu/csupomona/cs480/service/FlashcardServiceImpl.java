package edu.csupomona.cs480.service;


import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.data.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    private FlashcardRepository flashcardRepository;

    @Autowired
    public void setFlashcardRepository(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @Override
    public Iterable<Flashcard> listAllFlashcards() {
        return flashcardRepository.findAll();
    }

    @Override
    public Flashcard getFlashcardById(Integer id) {
        return flashcardRepository.findOne(id);
    }

    @Override
    public Flashcard saveFlashcard(Flashcard flashcard) {
        return flashcardRepository.save(flashcard);
    }

    @Override
    public void deleteFlashcard(Integer id) {
        flashcardRepository.delete(id);
    }

    @Override
    public List<Flashcard> listAllFlashcardsByUserIdAndSetId(Integer userId, String setId) {
        return flashcardRepository.findByUserIdAndSetId(userId, setId);
    }

    @Override
    public List<Flashcard> listAllFlashcardsBySetId(String setId) {
        return flashcardRepository.findBySetId(setId);
    }

    @Override
    public List<Flashcard> listAllFlashcardsByUserId(String userId) {
        return flashcardRepository.findByUserId(userId);
    }
}
