package com.example.validationModules;

import com.example.validationModules.Entities.User;
import com.example.validationModules.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    UserService userService;

    Scanner scanner = new Scanner(System.in);
    int runner = 0;

    @Override
    public void run(String... args) throws Exception {
        while(runner != 99){
            printActions();
            runner = Integer.parseInt(scanner.nextLine());

            switch (runner){
                case 1:
                    addUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    getUsers();
                    break;
                case 5:
                    getUserById();
                    break;
                case 6:
                    runner = 99;
                    break;
            }
        }
    }

    private void addUser(){
        System.out.println("Enter user's name:");
        String name = scanner.nextLine();
        System.out.println("Enter user's surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter user's phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter user's email:");
        String email = scanner.nextLine();
        System.out.println("Enter user's address:");
        String address = scanner.nextLine();
        System.out.println("Enter user's password:");
        String password = scanner.nextLine();

        System.out.println(userService.add(new User(name, surname, phoneNumber, email, address, password)));
    }

    private void updateUser(){
        System.out.println("Enter user's ID that you wish to edit");
        int id = Integer.parseInt(scanner.nextLine());

        User user = userService.findById(id);

        System.out.println("Please enter data you wish to change, if you want to keep old value, just press enter");

        System.out.println("Enter user's name:");
        String name = scanner.nextLine();
        if(!name.equals("")) user.setName(name);

        System.out.println("Enter user's surname:");
        String surname = scanner.nextLine();
        if(!surname.equals("")) user.setSurname(surname);

        System.out.println("Enter user's phone number");
        String phoneNumber = scanner.nextLine();
        if(!phoneNumber.equals("")) user.setPhoneNumber(phoneNumber);

        System.out.println("Enter user's email:");
        String email = scanner.nextLine();
        if(!email.equals("")) user.setEmail(email);

        System.out.println("Enter user's address:");
        String address = scanner.nextLine();
        if(!address.equals("")) user.setAddress(address);

        System.out.println("Enter user's password:");
        String password = scanner.nextLine();
        if(!password.equals("")) user.setPassword(password);

        System.out.println(userService.update(user));
    }

    private void deleteUser(){
        System.out.println("Enter user's ID that you wish to delete");
        int id = Integer.parseInt(scanner.nextLine());

        userService.deleteById(id);
    }

    private void getUsers(){
        System.out.println(userService.getAllUsers());
    }

    private void getUserById(){
        System.out.println("Enter user's ID that you wish to see");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(userService.findById(id));
    }


    private void printActions(){
        System.out.println("Select action:");
        System.out.println("1. Add user");
        System.out.println("2. Update user");
        System.out.println("3. Delete user");
        System.out.println("4. Get all users");
        System.out.println("5. Get user by ID");
        System.out.println("6. Exit");
    }
}
