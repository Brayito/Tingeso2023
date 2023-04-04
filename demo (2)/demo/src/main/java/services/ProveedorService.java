package services;

import entities.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProveedorRepository;


import java.util.ArrayList;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public void guardarProveedor(String codigoProveedor, String nombre, String clasificacion, String retencion){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setCodigoProveedores(codigoProveedor);
        proveedor.setNombre(nombre);
        proveedor.setClasificacion(clasificacion);
        proveedor.setRetencion(retencion);
        proveedorRepository.save(proveedor);
    }
    public ArrayList<ProveedorEntity> obtenerProveedores(){
        return (ArrayList<ProveedorEntity>) proveedorRepository.findAll();
    }

    public ProveedorEntity obtenerCodigo(String codigo){
        return proveedorRepository.findByCodigo(codigo);
    }

    public ProveedorEntity findByCodigo(String codigo){
        return proveedorRepository.findByCodigo(codigo);
    }
}