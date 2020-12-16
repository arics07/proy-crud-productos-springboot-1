package com.completandotps.app.services.impl;

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
	private IProductoRepository productoRepository;
	
	
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

}
