package br.com.lduran.controller;

import br.com.lduran.config.ParameterStoreConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ParameterStoreController
{
	@Autowired
	private ParameterStoreConfig PsConfig;

	@GetMapping("/parameterStoreConfig")
	public String configuration()
	{
		return PsConfig.getHelloWorld();
	}
}
