package com.completandotps.app.services;

import java.util.List;

import com.completandotps.app.models.Producto;

public interface IProductoService {

	//Guarda un Producto
	public abstract Producto IdProducto(String idProducto);
	
	//Guarda un prodcuto
	public abstract Producto save(Producto producto);
	
	//Obtiene toda la Lista de productos existentes en la BBDD
	public abstract List<Producto> findAll();
	
	//Modifica los datos de un usuario
	public abstract Producto update(Producto entity);
	
	//Elimino un Producto
	public abstract Producto deleteById(String idProducto);
	
}
