package com.dioSpringDesignPatterns.dioS.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dioSpringDesignPatterns.dioS.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}
