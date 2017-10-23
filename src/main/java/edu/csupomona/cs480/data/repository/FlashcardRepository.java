package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.Flashcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlashcardRepository extends CrudRepository<Flashcard, Integer>{

    public List<Flashcard> findByUserIdAndSetId(@Param("userId") Integer userId, @Param("setId") String setId);
    public List<Flashcard> findBySetId(@Param("setId") String setId);
    public List<Flashcard> findByUserId(@Param("userId") String userId);

}
