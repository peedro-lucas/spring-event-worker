//package com.pepo.demo.backend.controller;
//
//import com.pepo.demo.backend.dto.EmailRequestDTO;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/emails")
//public class EmailController {
//    private final EmailService emailService;
//
//    public EmailController(EmailService emailService){
//        this.emailService = emailService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO request){
//        emailService.processEmail(request);
//        return ResponseEntity.ok("Email Recebido com sucesso!");
//    }
//}
