package mx.com.cuamatziinc.ventas.commonsservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("/color")
	public ResponseEntity<?> saludar(){
		return ResponseEntity.ok().body("Hola mundo");
	}

}
