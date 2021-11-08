package com.example.validationModules.Service;

import com.example.validationModules.Entities.User;
import com.example.validationModules.Repository.UserRepository;
import com.example.validationModules.Validators.EmailValidator;
import com.example.validationModules.Validators.PasswordChecker;
import com.example.validationModules.Validators.PhoneValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private static User user;

    @BeforeAll
    public static void setup(){
        EmailValidator emailValidator = new EmailValidator();
        PhoneValidator phoneValidator = new PhoneValidator();
        PasswordChecker passwordChecker = new PasswordChecker();
        user = new User("Rokas", "Bagdonas", "+37060545494",
                "rokas@gmail.com", "Joniskio g. 7", "Rok@s113");
    }

    @Test
    void testGetAllUsers(){
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        List<User> found = userService.getAllUsers();

        assertEquals(1, found.size());
    }

    @Test
    void testFindById(){
        when(userRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(user));

        User found = userService.findById(0);

        assertEquals(user, found);
    }

    @Test
    void testAdd(){
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        String added = userService.add(user);

        verify(userRepository).save(Mockito.any(User.class));

        assertEquals("User with ID: 0, Rokas Bagdonas, phone number: +37060545494, email: rokas@gmail.com, address: Joniskio g. 7" +
                ", password: Rok@s113", added);
    }

    @Test
    void testDelete(){
        userService.deleteById(1);

        verify(userRepository).deleteById(Mockito.anyInt());
    }
}
