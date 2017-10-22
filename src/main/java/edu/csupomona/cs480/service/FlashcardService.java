package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.Flashcard;

import java.util.List;

public interface FlashcardService {
    Iterable<Flashcard> listAllFlashcards();
    Flashcard getFlashcardById(Integer id);
    Flashcard saveFlashcard(Flashcard flashcard);
    void deleteFlashcard(Integer id);
    List<Flashcard> listAllFlashcardsByUserIdAndSetId(Integer userId, String setId);
    List<Flashcard> listAllFlashcardsBySetId(String setId);
    List<Flashcard> listAllFlashcardsByUserId(String userId);
}
