package com.dioSpringDesignPatterns.dioS.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dioSpringDesignPatterns.dioS.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String>{

}
