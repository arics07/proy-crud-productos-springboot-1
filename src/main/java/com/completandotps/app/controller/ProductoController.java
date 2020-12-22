package com.completandotps.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.completandotps.app.models.Producto;
import com.completandotps.app.services.IProductoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;  //verrrrrr
	
	//Método POST para crear un nuevo Producto //Persisto o guardo en la BBDD
	@PostMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		Producto productoData = productoService.save(producto);
		
		//Si el servicio me devolvió un resultado exitoso o 200 devuelvo al Front todos los datos del Producto creado
		return ResponseEntity.ok(productoData);
	}
	
	//Método GET para obtener los datos de un producto por su ID
	@GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> findAll(){
		
		//Instancio una nueva lista de Productos
		List<Producto> productos = new ArrayList<Producto>();
		
		// Llamo al servicio creado y obtengo al lista
		productos = productoService.findAll();
		
		//Si el servicio me devolvió un resultado exitoso o 200
		//devuelvo al Front end todos los datos del Producto solicitado
		return ResponseEntity.ok(productos);
	}
	
	//Método GET para obtener los datos de 1 producto por su ID
	@GetMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> findByIdProducto(@PathVariable String idProducto) {
		
		//Instancio in nuevo objeto Producto
		Producto producto = new Producto();
		
		// Llamo al servicio creado y le paso por parámetro el idProducto
		producto = productoService.IdProducto(idProducto);
		
		//Si el servicio me devuelve un resultado exitoso o 200 devuelco al Front todos los datos del producto solicitado
		return ResponseEntity.ok(producto);
	}
	
	//Método PUT para modificar un prodicto existente
	// Persisto y actualizo en la BBDD
	@PutMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
		
		//Llamo al servicio creado y le paso los nuevos datos
		//NO TENGO QUE MODIFICAR EL ID, tiene que ser el mismo
		Producto productoData = productoService.save(producto);
		
		//Si el servicio me devuelce un resultado exitoso
		//Devuelvo al Front todos los datos del Producto actualizado
		return ResponseEntity.ok(productoData);
	}
	
	//Método DELETE para eliminar los datos de un producto por si ID
	@DeleteMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> deleteFindByIdProducto(@PathVariable String idProducto) {
		
		//Instancio un nuevo objeto producto
		Producto producto = new Producto();
		
		//Llamo al servicio creado y le paso por parámetro el idProducto
		producto = productoService.deleteById(idProducto);
		
		//Si el servicio me devuelve un resultado exitoso o 200
		// Elimino todos los datos del Producto solicitado
		return ResponseEntity.ok(producto);
	}
}
