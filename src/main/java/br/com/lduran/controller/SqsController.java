package br.com.lduran.controller;

import br.com.lduran.service.SqsMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SqsController
{
	@Autowired
	private SqsMessageProducer messageProducer;

	@PostMapping("/sendMessage")
	public ResponseEntity<?> sendMessage(@RequestParam("message") String message)
	{
		messageProducer.sendMessage(message);

		return ResponseEntity.ok().build();
	}
}
