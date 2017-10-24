package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.configuration.RepositoryConfiguration;
import edu.csupomona.cs480.data.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class UserRepositoryTest {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testSaveUser1() {
        User user = new User();
        user.setName("Billy Bronco");
        user.setEmail("bbronco@cpp.edu");

        assertNotNull(user.getName());
        userRepository.save(user);
    }

    @Test
    public void testSaveUser2() {
        User user = new User();
        user.setName("Billy Bronco");
        user.setEmail("bbronco@cpp.edu");

        assertNotNull(user.getName());
        userRepository.save(user);
        User user2 = userRepository.findOne(user.getId());
        assertNotNull(user2.getId());
    }

    @Test
    public void testSaveUser3() {
        User user = new User();
        user.setName("Billy Bronco");
        user.setEmail("bbronco@cpp.edu");

        assertNotNull(user.getName());
        userRepository.save(user);
        User user2 = userRepository.findOne(user.getId());
        assertNotNull(user2.getId());

        assertEquals(user.getId(), user2.getId());

    }


}
