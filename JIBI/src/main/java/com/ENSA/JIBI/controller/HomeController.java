package com.ENSA.JIBI.controller;

import com.ENSA.JIBI.repository.AdminRepository;
import com.ENSA.JIBI.repository.ClientRepository;
import com.ENSA.JIBI.request.SignupRequestClient;
import com.ENSA.JIBI.services.AgentService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/api/auth")
public class HomeController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AgentService agentService;
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/client/add")

    public ResponseEntity<?> registerClient(  @RequestBody SignupRequestClient signupRequestClient) throws IOException, MessagingException {
        if (clientRepository.existsByUsername(signupRequestClient.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (clientRepository.existsByEmail(signupRequestClient.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account


        boolean isCreated = agentService.createClient(signupRequestClient.getUsername(),
                signupRequestClient.getNom(),
                signupRequestClient.getPrenom(),
                signupRequestClient.getEmail(),
                signupRequestClient.getNumTel()

        );

        System.out.println("hello");

        if (isCreated) {
            return ResponseEntity.ok().body("Client created successfully.");
        } else {
            return ResponseEntity.status(500).body("Error: Client creation failed!");
        }
    }






}
