package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.data.entity.User;

public interface UserService {
    Iterable<User> listAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    void deleteUser(Integer id);
}
