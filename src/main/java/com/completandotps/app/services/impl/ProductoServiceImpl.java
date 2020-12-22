package com.completandotps.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.completandotps.app.models.Producto;
import com.completandotps.app.repository.IProductoRepository;
import com.completandotps.app.services.IProductoService;

@Service("productoService") 
public class ProductoServiceImpl implements IProductoService{

	//Inyecto el repository
	//para usar sus funciones e implementar
	//en la logica de los servicios
	
	@Autowired
	IProductoRepository productoRepository;
	
	
	//con este contrato o metodo de mi capa actual
	//creo la logica para poder hacer la consulta con mi BD Mongo
	
	@Override
	public Producto IdProducto(String idProducto) {
		
		//instancio un nuevo objeto producto
		Producto producto = null;
		
		//Envolvemos en una validacion
		//para que en caso que falle por algun motivo esa consulta 
		//me imprima en la consola en que parte fallo mi app
		try {
			producto = productoRepository.findById(idProducto);
			
		} catch (Exception e){
			
			e.printStackTrace();	
			
		}
		
		//En caso de éxito devuelvo todos los datos que contiene Producto
		return producto;
	}
	
	@Override
	public Producto save(Producto entity) {
		//Instancio un nuevo objeto producto
		Producto producto = null;
		
		//Envolvemos en una validación para que en que caso que falle por algún motivo
		//esa consulta me imprima en la consola en que parte falló mi app
		
		try {
			producto = productoRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//En caso de exito devuelvo todos los datos que contiene Producto
		return producto;
	}

	@Override
	public List<Producto> findAll() {
		//Instancio una lista de Producto
		List<Producto> lstProductos = new ArrayList<Producto>();
		
		//Envolvemos en una validación para que en caso que falle la consulta
		//me imprima en la consola en qué parte falló mi app
		
		try {
			lstProductos = productoRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//en caso de éxito devuelvo la Lista de todos los Producto
		return lstProductos;
	}
	
	@Override
	public Producto update(Producto entity) {
		//Instancio un nuevo objeto producto
		Producto producto = null;
		
		//Envolvemos en una validación para que en caso falle por algún motivo esa consulta
		//me imprima en la consola en que parte falló mi app
		try {
			producto = productoRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//En caso de éxito devuelvo todos los datos que contiene Producto
		return producto;
	}

	@Override
	public Producto deleteById(String idProducto) {
		//Instancio un nuevo objeto producto
		Producto producto = null;
		
		//Envolvemos en uan validación para que en caso que falle, me imrpima en la consola que parte falló
		try {
			producto = productoRepository.deleteById(idProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//En caso de éxito devuelvo todos los datos que contiene Producto
		return producto;
	}
	
}
