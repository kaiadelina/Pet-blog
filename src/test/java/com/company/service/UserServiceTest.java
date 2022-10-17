package com.company.service;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.company.TestUtils.createUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void loadUserByUsernameTest() {
        String username = "Vasya";

        when(userRepository.findByNickname(username)).thenReturn(createUser());
        UserDetails response = userService.loadUserByUsername(username);

        assertEquals(username, response.getUsername());
    }

    @Test
    void saveUserTest() {
        User request = new User(null, "Vasya", "1111", null, null);

        when(userRepository.findByNickname("Vasya")).thenReturn(null);
        when(userRepository.save(any())).thenReturn(createUser());

        boolean response = userService.saveUser(request);
        assertTrue(response);
    }
}