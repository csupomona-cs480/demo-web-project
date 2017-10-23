package edu.csupomona.cs480.loader;

import edu.csupomona.cs480.data.entity.User;
import edu.csupomona.cs480.data.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User user1 = new User();
        user1.setName("Billy Bronco");
        user1.setUserId("1");
        user1.setEmail("bbronco@cpp.edu");
        userRepository.save(user1);
        log.info("user 1: " + user1.getName() + " " + user1.getId());

        User user2 = new User();
        user2.setName("SnackOverflow");
        user2.setUserId("2");
        user2.setEmail("snack@cpp.edu");
        userRepository.save(user2);
        log.info("user 2: " + user2.getName() + " " + user2.getId());
    }
}
