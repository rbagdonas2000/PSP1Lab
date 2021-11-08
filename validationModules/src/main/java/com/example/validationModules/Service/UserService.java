package com.example.validationModules.Service;

import com.example.validationModules.Entities.User;
import com.example.validationModules.Repository.UserRepository;
import com.example.validationModules.Validators.EmailValidator;
import com.example.validationModules.Validators.PasswordChecker;
import com.example.validationModules.Validators.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private PasswordChecker passwordChecker = new PasswordChecker();

    private EmailValidator emailValidator = new EmailValidator();

    private PhoneValidator phoneValidator = new PhoneValidator();

    public String add(User user){
        if(!emailValidator.isValidEmail(user.getEmail())){
            return "Email is not valid";
        }
        else if(!phoneValidator.isValidPhone(user.getPhoneNumber())){
            return "Phone number is not valid";
        }
        else if(!passwordChecker.isValidPassowrd(user.getPassword())){
            return "Password is not valid";
        }
        return userRepository.save(user).toString();
    }

    public String update(User user){
        if(!emailValidator.isValidEmail(user.getEmail())){
            return "Email is not valid";
        }
        else if(!phoneValidator.isValidPhone(user.getPhoneNumber())){
            return "Phone number is not valid";
        }
        else if(!passwordChecker.isValidPassowrd(user.getPassword())){
            return "Password is not valid";
        }
        else
            return userRepository.save(user).toString();
    }

    public void deleteById(int id) { userRepository.deleteById(id); }

    public List<User> getAllUsers() { return (List<User>) userRepository.findAll();}

    public User findById(int id) { return userRepository.findById(id).get(); }
}
