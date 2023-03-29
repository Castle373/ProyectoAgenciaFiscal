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
//        Persona p = new Persona("Diego","Rfc","6441271967",new GregorianCalendar(2003, Calendar.JUNE, 1));
//        //Persona solicita licencia y placa
//        Licencia lice  = new Licencia(0, new GregorianCalendar(2003, Calendar.JUNE, 1),100,new GregorianCalendar(2003, Calendar.JUNE, 1),p);
//        Automovil auto = new Automovil("2003", "ferrari", "Veneno", "gris", "aaa");
//        Placas placa = new Placas("ddd-123","ACTIVO",auto,150,new GregorianCalendar(2003, Calendar.JUNE, 1), p);
//        //auto con placa
//        auto.agregaPlaca(placa);
//        
//        // guarda
//        entity.persist(lice);
//        entity.persist(auto);
//        entity.persist(placa);
//        entity.getTransaction().commit();
//
//        entity.close();
//        
//        enti.close();
    frmInicio frminicio = new frmInicio();
     frminicio.setVisible(true);
    }
}
