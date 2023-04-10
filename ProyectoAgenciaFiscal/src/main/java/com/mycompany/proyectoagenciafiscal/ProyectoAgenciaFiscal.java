/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoagenciafiscal;

import Entity.Automovil;
import Entity.Licencia;
import Entity.Persona;
import Entity.Placas;
import Presentacion.frmInicio;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diego
 */
public class ProyectoAgenciaFiscal {

    public static void main(String[] args) {
//        EntityManagerFactory enti = Persistence.createEntityManagerFactory("ConexionD");
//        //Entimanager
//        EntityManager entity = enti.createEntityManager();
//        //Transacion
//        
//        entity.getTransaction().begin();
//        //Crea persona
//        Persona p = new Persona("Pancho","Rfc2","Curp2","6441271967",new GregorianCalendar(2003, Calendar.JUNE, 1));
//        Automovil auto = new Automovil("2005", "ferrari", "Veneno", "gris", "aaa",p);
//        Automovil auto2 = new Automovil("3333", "carovolador", "Veneno", "gris", "aaa",p);
//        p.agregarAuto(auto);
//        p.agregarAuto(auto2);
//        Licencia lice  = new Licencia(0, new GregorianCalendar(2003, Calendar.JUNE, 1),100,p);
//        p.agregarTramite(lice);
//
//        
//      
//        
//        // guarda
//        entity.persist(p);
//        entity.getTransaction().commit();
//        entity.getTransaction().begin();
//        //Crea persona
////        Persona p2 = entity.find(Persona.class, 1);
//        Placas placa = new Placas("placa123", "ACTIVA", auto, 100, p);
////        Automovil autoencontrado=entity.find(Automovil.class,auto);
////        autoencontrado.agregaPlaca(placa);
//        entity.persist(placa);
////        entity.merge(autoencontrado);
//        
//        
//        // guarda
//        entity.getTransaction().commit();
//        entity.close();
//        enti.close();
//        EntityManagerFactory enti = Persistence.createEntityManagerFactory("ConexionD");
//        //Entimanager
//        EntityManager entity = enti.createEntityManager();
//        //Transacion
//        
//        entity.getTransaction().begin();
//        //Crea persona
//        Persona p = new Persona("Diego","estoesunarfc","estoesunacrup","minumero",new GregorianCalendar(2003, Calendar.JUNE, 1));
//        Automovil auto = new Automovil("1111", "Carro de piedra", "Veneno", "gris", "nox",p);
////        Automovil auto2 = new Automovil("3333", "carovolador", "Veneno", "gris", "aaa",p);
//        p.agregarAuto(auto);
////        p.agregarAuto(auto2);
//        Licencia lice  = new Licencia(0, new GregorianCalendar(2003, Calendar.JUNE, 1),100,p);
//        p.agregarTramite(lice);
//
//        
//      
//        
//        // guarda
//        entity.persist(p);
//        entity.getTransaction().commit();
//        entity.getTransaction().begin();
//        //Crea persona
////        Persona p2 = entity.find(Persona.class, 1);
//        Placas placa = new Placas("estaessuplaca", "ACTIVA", auto, 100, p);
////        Automovil autoencontrado=entity.find(Automovil.class,auto);
////        autoencontrado.agregaPlaca(placa);
//        entity.persist(placa);
////        entity.merge(autoencontrado);
//        
//        
//        // guarda
//        entity.getTransaction().commit();
//        entity.close();
//        enti.close();
    
    frmInicio frminicio = new frmInicio();
     frminicio.setVisible(true);
    }
}
