package com.completandotps.app.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.completandotps.app.models.Producto;

@Repository("IProductoRepository")
public interface IProductoRepository extends MongoRepository<Producto, Serializable>{

	//DENTRO DE ESTE BLOQUE DE CÓDIGO VOY A HACER LAS CONSULTAS
	//QUE NECESITE CONTRA MONGO DB
	
	//Internamente actúa como unaquerry de consulta
	//Busca en base de datos un producto por medio del ID
	Producto findById(String id);
}
