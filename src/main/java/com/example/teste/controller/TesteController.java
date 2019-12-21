package com.example.teste.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class TesteController {
	
	
	public static Object dados;
	
	@PostMapping()
	public Object createUpdateProduct(@Valid @RequestBody Object request) {
		dados = request;
		return request;
	}
	
	@PostMapping("/{mkt}")
	public Object createUpdateProduct(@RequestBody Object request, @PathVariable("mkt") String mkt) {
		dados = request;
		return request;
	}
	
	@PostMapping("/{mkt}/{sellerId}")
	public Object createUpdateProduct(@RequestBody Object request, @PathVariable("mkt") String mkt, @PathVariable("sellerId") String seller) {
		dados = request;
		return request;
	}
	
	
	@GetMapping()
	public Object get() {
		return dados;
	}
	
}
