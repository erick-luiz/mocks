package com.example.teste.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.model.Saida;

@RestController
@RequestMapping("/api/notification")
public class TesteController {
	
	
	public static Saida dados = new Saida();
	
	@PostMapping()
	public ResponseEntity<?> createUpdateProduct(@RequestBody Object request, @RequestParam Map<String,String> allRequestParams,
			@RequestHeader Map<String,String> allRequestHeader) {
		dados.setBody(request);
		dados.setParams(allRequestParams.toString());
		dados.setHeaders(allRequestHeader.toString());
		return ResponseEntity.status(201).body("");
	}
	
	@PostMapping("/{mkt}")
	public ResponseEntity<?> createUpdateProduct1(@RequestBody Object request, @PathVariable("mkt") String mkt, 
			@RequestParam Map<String,String> allRequestParams,
			@RequestHeader Map<String,String> allRequestHeader) {
		dados.setBody(request);
		dados.setPath(mkt);
		dados.setParams(allRequestParams.toString());
		dados.setHeaders(allRequestHeader.toString());
		return ResponseEntity.status(201).body("");
	}
	
	@PostMapping("/{mkt}/{sellerId}")
	public Object createUpdateProduct2(@RequestBody Object request, @PathVariable("mkt") String mkt, @PathVariable("sellerId") String seller, 
			@RequestParam Map<String,String> allRequestParams,
			@RequestHeader Map<String,String> allRequestHeader) {
		dados.setBody(request);
		dados.setPath(mkt + "/" + seller); 
		dados.setParams(allRequestParams.toString());
		dados.setHeaders(allRequestHeader.toString());
		return ResponseEntity.status(201).body("");
	}

	@GetMapping()
	public Object get() {
		return dados;
	}
	
}
