package com.ENSA.JIBI.services;

import com.ENSA.JIBI.models.Client;
import com.ENSA.JIBI.repository.AgentRepository;
import com.ENSA.JIBI.repository.ClientRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class AgentService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final AgentRepository agentRepository;

    @Autowired
    private final EmailService emailService;
//
//
    @Autowired
    private final PasswordEncoder passwordEncoder;

    final String letterLower = "abcdefghijklmnopqrstuvwxyz";
    final String letterUpper= letterLower.toUpperCase();
    final String number = "0123456789";
    final String caractereSpeciaux = "!@#$%&*_?':,;~°^";
    final String passworwdCombinaison= letterLower+ letterUpper + number + caractereSpeciaux;
    public String genererPassword() {

        SecureRandom random = new SecureRandom();
        String password="";
        password+=letterLower.charAt(random.nextInt(letterLower.length()));
        password+=letterUpper.charAt(random.nextInt(letterUpper.length()));
        password+=number.charAt(random.nextInt(number.length()));
        password+=caractereSpeciaux.charAt(random.nextInt(caractereSpeciaux.length()));

        for(int i=0;i<5;i++) {
            password+=passworwdCombinaison.charAt(random.nextInt(passworwdCombinaison.length()));
        }

        return password;
    }



    public Boolean createClient(String username,String nom, String prenom, String email, String numTel) throws IOException, MessagingException, MessagingException {

        Client user=new Client();


        user.setUsername(username);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setNumTel(numTel);

        String pass=this.genererPassword();
        System.out.println(pass);
        log.info("Password for Client generated: "+pass);


//        user.setFirstAuth(true);
        user.setPassword(passwordEncoder.encode(pass));
//        user.setPassword(pass);
        clientRepository.save(user);

        String content="<h1> Hello Client "+ nom +" "+prenom+" and Welcome To JIBI  application.</h1> </br>" +
                " <h3> please use these informations to Login to your Account: </h3>" +
                "<ul>" +
                "<li style='color:blue;'> User Name :  "+email+" </li> " +
                "<li style='color:blue;'> Password : "+pass+" </li> " +
                "</ul>";
        emailService.sendEmail(email,content);
        System.out.println("Mail Sent Successfully Agent Service");
        return  true;

    }

    public Client getClient(String numTel) {
        log.info("afficher le client par agent {}", numTel);
        return clientRepository.findByNumTel(numTel);
    }
    public List<Client> getClients() {
        log.info("afficher tout les client par agent");
        return clientRepository.findAll();
    }
//    public void changePassword(String uid, String newPassword) {
//        Agent agent = agentRepository.findByUsername(uid);
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        if(agent.getFirstAuth() == true){ agent.setFirstAuth(false);}
//        agent.setPassword(encodedPassword);
//        agentRepository.save(agent);
//    }
//    public Boolean agentHaschangedPassword(String username){
//        Agent agent = agentRepository.findByUsername(username);
//
//        if (agent.getFirstAuth()) return false;
//        else return true;
//    }
}
