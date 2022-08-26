package com.marcosfausto.cursomc.services;

import com.marcosfausto.cursomc.domain.Cliente;
import com.marcosfausto.cursomc.repositories.ClienteRepository;
import com.marcosfausto.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private BCryptPasswordEncoder pe;
    
    @Autowired
    private EmailService emailService;

    private Random rand = new Random();
    
    public void sendNewPassword(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }
        
        String newPass = newPassword();
        cliente.setSenha(pe.encode(newPass));
        
        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente,newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) { // gera um dígito
            return (char) (rand.nextInt(10) + 48); // bound 0 a 9, 48 é número unicode do 0
        } else if (opt == 1) { // gera letra maíscula
            return (char) (rand.nextInt(26) + 65); // bound A a Z (26), 65 é o número unicode de A maiúsculo
        } else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 65); // bound A a Z (26), 65 é o número unicode de a minúsculo
        }
    }


}
