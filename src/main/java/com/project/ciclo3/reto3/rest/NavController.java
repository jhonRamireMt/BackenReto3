package com.project.ciclo3.reto3.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @GetMapping("/index.html")
    public String goHome(){
        return "index";
    }

    @GetMapping("/index.html#servicios")
    public String goAdministration(){
        return "index.html#servicios";
    }

    @GetMapping("/cabin.html")
    public String goCabin(){
        return "cabin";
    }

    @GetMapping("/categoria.html")
    public String goCategoria(){
        return "categoria";
    }
    @GetMapping("/mensaje.html")
    public String goMensaje(){
        return "mensaje";
    }

    @GetMapping("/reportes.html")
    public String goReportes(){
        return "reportes";
    }

    @GetMapping("/reserva.html")
    public String goReservas(){
        return "reserva";
    }

    @GetMapping("/cliente.html")
    public String goCliente(){
        return "cliente";
    }

    @GetMapping("/gestionarCabaña.html")
    public String goGestionarCabaña(){
        return "gestionarCabaña";
    }

    @GetMapping("/gestionarCategoria.html")
    public String goGestionarCategoria(){
        return "gestionarCategoria";
    }

    @GetMapping("/gestionarCliente.html")
    public String goGestionarCliente(){
        return "gestionarCliente";
    }

    @GetMapping("/gestionarMensaje.html")
    public String goGestionarMensaje(){
        return "gestionarMensaje";
    }

    @GetMapping("/gestionarReservacion.html")
    public String goGestioanrReservation(){
        return "gestionarReservacion";
    }

    @GetMapping("/crearCalificacion.html")
    public String goCrearCalificacion(){
        return "crearCalificacion";
    }


}
