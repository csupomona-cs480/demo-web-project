package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.Flashcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlashcardRepository extends CrudRepository<Flashcard, Integer>{

    List<Flashcard> findByUserIdAndSetId(@Param("userId") Integer userId, @Param("setId") String setId);
    List<Flashcard> findBySetId(@Param("setId") String setId);
    List<Flashcard> findByUserId(@Param("userId") String userId);

}
