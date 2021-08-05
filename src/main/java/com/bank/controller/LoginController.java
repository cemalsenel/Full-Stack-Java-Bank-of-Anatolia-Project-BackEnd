package com.bank.controller;


import com.bank.payload.request.SignUpForm;
import com.bank.payload.response.Response;
import com.bank.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserRepo userRepo;
    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody SignUpForm signUpForm){
        //Response object
        Response response = new Response();

        //check the mail and username in sign up form
        if(userRepo.existsByUsername(signUpForm.getUsername())){
            response.setMessage("Error : Username is already taken.");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }

        if(userRepo.existsByEmail(signUpForm.getEmail())){
            response.setMessage("Error : Email is already taken.");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }

        //create a new user
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
