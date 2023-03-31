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
//        Persona p = new Persona("Diego","Rfc","Curp","6441271967",new GregorianCalendar(2003, Calendar.JUNE, 1));
//        Automovil auto = new Automovil("2003", "ferrari", "Veneno", "gris", "aaa",p);
//        p.agregarAuto(auto);
//        Licencia lice  = new Licencia(0, new GregorianCalendar(2003, Calendar.JUNE, 1),100,new GregorianCalendar(2003, Calendar.JUNE, 1),p);
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
//        Placas placa = new Placas("placa123", "ACTIVA", new GregorianCalendar(2003, Calendar.JUNE, 1), auto, 100, new GregorianCalendar(2003, Calendar.JUNE, 1), p);
////        Automovil autoencontrado=entity.find(Automovil.class,auto);
////        autoencontrado.agregaPlaca(placa);
//        entity.persist(placa);
////        entity.merge(autoencontrado);
//        
//        
//        // guarda
//        entity.persist(p);
//        entity.getTransaction().commit();
//        entity.close();
//        enti.close();
    frmInicio frminicio = new frmInicio();
     frminicio.setVisible(true);
    }
}
