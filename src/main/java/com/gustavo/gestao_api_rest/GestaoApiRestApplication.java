package com.gustavo.gestao_api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@SpringBootApplication
public class GestaoApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoApiRestApplication.class, args);

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'às' HH:mm'hrs' ", new Locale("pt", "BR"));
		String nowFormatada = now.format(formatter);

		System.out.println("Sistema funcionando corretamente no dia: " + nowFormatada);
	}

}
