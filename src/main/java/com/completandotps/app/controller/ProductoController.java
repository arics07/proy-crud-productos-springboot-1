package com.completandotps.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.completandotps.app.models.Producto;
import com.completandotps.app.services.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;  //verrrrrr
	
	//Método GET para obtener los datos de un producto por su ID
	@GetMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto>findByProducto(@PathVariable String idProducto){
		
		//Instancio un nuevo objeto producto
		Producto producto = new Producto();
		
		//Llamo al servicio creado y le paso por parámetro el idProducto
		producto = productoService.IdProducto(idProducto);
		
		//Si el servicio me devolvió un resultado exitoso o 200
		//devuelvo al Front end todos los datos del Producto solicitado
		return ResponseEntity.ok(producto);
	}
}
