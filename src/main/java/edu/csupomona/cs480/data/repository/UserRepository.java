package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
}
