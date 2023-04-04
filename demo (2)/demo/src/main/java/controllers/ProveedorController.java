package controllers;

import entities.ProveedorEntity;
import services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ProveedorController{

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/lista-proveedores")
    public String listar(Model model){
        ArrayList<ProveedorEntity> proveedores =proveedorService.obtenerProveedores();
        model.addAttribute("proveedores", proveedores);
        return "index";
    }

    @PostMapping("/nuevo-proveedor")
    public String nuevoProveedor(@RequestParam("codigoProveedores") String codigoProveedores,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("clasificacion") String clasificacion,
                                 @RequestParam("retencion") String retencion){
        proveedorService.guardarProveedor(codigoProveedores, nombre, clasificacion, retencion);
        return "redirect:/nuevo-proveedor";
    }

}