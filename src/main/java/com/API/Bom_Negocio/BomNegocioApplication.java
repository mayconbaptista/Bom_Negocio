package com.API.Bom_Negocio;

import com.API.Bom_Negocio.Controller.AnuncioController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BomNegocioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BomNegocioApplication.class, args);
	}
}
