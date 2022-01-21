package com.dioSpringDesignPatterns.dioS.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dioSpringDesignPatterns.dioS.Configuration.FeignConfiguration;
import com.dioSpringDesignPatterns.dioS.model.Address;

@FeignClient(name = "viacep", url = "http://viacep.com.br/ws", configuration = FeignConfiguration.class)
public interface AddressService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{postalCode}/json/")
	Address searchPostalCode(@PathVariable("postalCode") String postalCode);

}
