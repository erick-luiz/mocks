package com.example.teste.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.model.Saida;

@RestController
@RequestMapping("/api/notification")
public class TesteController {
	
	
	public static List<Saida> dados = new ArrayList<>();
	
	@PostMapping({"/**","/{1}","/{1}/{2}","/{1}/{2}/{3}","/{1}/{2}/{3}/{4}"})
	public ResponseEntity<?> postRequest(@RequestBody Object request, @RequestParam Map<String,String> allRequestParams,
			@RequestHeader Map<String,String> allRequestHeader,  @PathVariable Map<String, String> pathVarsMap) {
		fillDataRequest(request, allRequestParams, allRequestHeader, pathVarsMap.toString(), "POST");
		return ResponseEntity.status(201).body("");
	}
	
	@PutMapping({"/**","/{1}","/{1}/{2}","/{1}/{2}/{3}","/{1}/{2}/{3}/{4}"})
	public ResponseEntity<?> putRequest(@RequestBody Object request, @RequestParam Map<String,String> allRequestParams,
			@RequestHeader Map<String,String> allRequestHeader, @PathVariable Map<String, String> pathVarsMap) {
		fillDataRequest(request, allRequestParams, allRequestHeader, pathVarsMap.toString(), "PUT");
		return ResponseEntity.status(200).body("");
	}

	private void fillDataRequest(Object request, Map<String, String> allRequestParams,
			Map<String, String> allRequestHeader, String path, String method) {
		Saida out =  new Saida();
		out.setBody(request);
		out.setParams(allRequestParams.toString());
		out.setHeaders(allRequestHeader.toString());
		out.setData(LocalDateTime.now());
		out.setPath(path);
		out.setMethod(method);
		dados.add(out);
	}

	@GetMapping("/**")
	public List<Saida> get() {
		return dados;
	}
	
}
