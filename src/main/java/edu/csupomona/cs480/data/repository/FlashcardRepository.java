package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.Flashcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CrudRepository is an interface that gives access to CRUD operations without
 * the need to write them ourselves.
 *
 * Each method that begins with "findBy" is a query in the repository for the specified element.
 */
public interface FlashcardRepository extends CrudRepository<Flashcard, Integer>{

    List<Flashcard> findByUserIdAndSetId(@Param("userId") Integer userId, @Param("setId") String setId);
    List<Flashcard> findBySetId(@Param("setId") String setId);
    List<Flashcard> findByUserId(@Param("userId") String userId);

}
