package com.gustavo.gestao_api_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@SpringBootApplication
public class GestaoApiRestApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(GestaoApiRestApplication.class, args);

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'às' HH:mm'hrs' ", new Locale("pt", "BR"));
		String nowFormatada = now.format(formatter);

		System.out.println("Sistema funcionando corretamente no dia: " + nowFormatada);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ENCODE " + passwordEncoder.encode("123456") );

		// como o spring security verifica as credenciais quando o usuario for logar no sistema
		boolean result = passwordEncoder.matches("123456", "$2a$10$K1odOK387dhqXRx3kOyDDeKu4CZ1y5KYPcSF1vkHf26mjQixR7hpG");
		System.out.println("Resultado = " + result);
	}
}
