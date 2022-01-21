package com.dioSpringDesignPatterns.dioS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@SerializedName("cep")
	private String postalCode;
	@SerializedName("logradouro")
	private String street;
	@SerializedName("complemento")
	private String complement;
	@SerializedName("bairro")
	private String neighborhood;
	@SerializedName("localidade")
	private String city;
	@SerializedName("uf")
	private String state;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
}
