package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository is an interface that gives access to CRUD operations without
 * the need to write them ourselves.
 *
 * Each method that begins with "findBy" is a query in the repository for the specified element.
 */
public interface UserRepository extends CrudRepository<User, Integer>{
}
