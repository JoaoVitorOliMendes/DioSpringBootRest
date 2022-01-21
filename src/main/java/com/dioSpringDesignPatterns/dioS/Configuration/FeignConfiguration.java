package com.dioSpringDesignPatterns.dioS.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dioSpringDesignPatterns.dioS.model.Address;
import com.google.gson.Gson;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;

@Configuration
public class FeignConfiguration {

	@Bean
	public Decoder decoder() {
		return new GsonDecoder();
	}
	
}
