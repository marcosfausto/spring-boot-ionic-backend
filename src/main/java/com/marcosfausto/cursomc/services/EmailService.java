package com.marcosfausto.cursomc.services;

import com.marcosfausto.cursomc.domain.Cliente;
import com.marcosfausto.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
