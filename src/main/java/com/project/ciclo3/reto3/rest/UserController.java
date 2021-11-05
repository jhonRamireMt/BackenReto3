package com.project.ciclo3.reto3.rest;


import java.io.IOException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {



    /*
    Este metodo permite el inicio de sesion en github desde la ubicacion raiz
    * Posteriormente se realiza un redireccionamiento hacia el front end donde
    * se consumiran todos los APIs
    * */

//    @GetMapping("/")
//    public void user(@AuthenticationPrincipal OAuth2User principal, HttpServletResponse index) throws IOException {
//        String user = principal.getAttribute("name");
//        if(!user.equals("")){
//            //index.sendRedirect("http://144.22.57.2/frontEndReto3/index.html"); // opcion de produccion
//            index.sendRedirect("http://127.0.0.1:5500/index.html"); // opcion para localhost
//
//        }else{
//            index.sendError(401);
//        }
//    }

//    @GetMapping("/")
//    public void redirectToCabinTwo(HttpServletResponse httpServletResponse) throws IOException {
//        httpServletResponse.sendRedirect("http://127.0.0.1:5500/");
//  }

//    @GetMapping("/index")
//    public void index(HttpServletResponse index) throws IOException {
//        index.sendRedirect("index.html");
//    }
}

