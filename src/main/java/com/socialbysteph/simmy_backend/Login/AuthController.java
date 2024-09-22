package com.socialbysteph.simmy_backend.Login;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class AuthController {
    private List<User> users = new ArrayList<>();

    public AuthController() {
        this.users.add(new User("vaibhavmalhotra99@gmail.com", "1"));
        this.users.add(new User("vastavm99@gmail.com", "2"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return new User("No User", "-1");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public boolean registerUser(@RequestBody User user) {
        System.out.println(user);
        try {
            this.users.add(user);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/emails")
    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        for (User user : users) {
            emails.add(user.getUsername());
        }
        System.out.println(emails);
        return emails;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public User loginUser(@RequestBody User checkUser) {
        for (User user : users) {
            if (user.getUsername().equals(checkUser.getUsername()) && user.getPassword().equals(checkUser.getPassword())) {
                return user;
            }
        }
        return new User();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/delete/{username}")
    public boolean removeUser(@PathVariable String username) {
        boolean isRemoved = false; // Initialize the flag to false

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(username)) {
                isRemoved = true;  // Set flag to true when user is removed
                iterator.remove();  // Remove the user from the list
            }
        }
        return isRemoved; // Return whether a user was removed or not
    }
}
