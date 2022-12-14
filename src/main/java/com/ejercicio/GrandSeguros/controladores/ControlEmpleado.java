package com.ejercicio.GrandSeguros.controladores;

import com.ejercicio.GrandSeguros.entidades.Empleado;
import com.ejercicio.GrandSeguros.entidades.Empresa;
import com.ejercicio.GrandSeguros.servicios.ServiciosEmpleado;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
public class ControlEmpleado {

    ServiciosEmpleado servicesEmpleado;



    public ControlEmpleado(ServiciosEmpleado servicesEmpleado){
        this.servicesEmpleado = servicesEmpleado;

    }
    /*@GetMapping("/users")
    public List<Empleado> VerUsuarios(){
        return this.servicesEmpleado.getListaEmpleado();
    }*/

    @PostMapping("/users")
    public RedirectView crearEmpleado(@ModelAttribute Empleado usu, Model modelusu){
        modelusu.addAttribute((usu));
        this.servicesEmpleado.crearEmpleado(usu);
        return new RedirectView("/users");

    }

    @GetMapping("/users/{id}")
    public Empleado VerUsuario(@PathVariable Long id){
        return this.servicesEmpleado.getEmpleado(id);
    }

    @PatchMapping("/users/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Map<Object, Object> objectMap){
        return this.servicesEmpleado.updateEmpleado(id, objectMap);
    }

    @DeleteMapping("/users/{id}")
    public Empleado eliminarEmpleado(@PathVariable(value = "id") Long id){
        return this.servicesEmpleado.eliminarEmpleado(id);
    }

}





