/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoagenciafiscal;

import Entity.Automovil;
import Entity.Historial;
import Entity.Licencia;
import Entity.Persona;
import Entity.Placas;
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
    EntityManagerFactory enti = Persistence.createEntityManagerFactory("ConexionD");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        //Transacion
        
        entity.getTransaction().begin();
        //Crea persona
        Persona p = new Persona("Diego","Rfc","6441271967",new GregorianCalendar(2003, Calendar.JUNE, 1));
        //Persona solicita licencia y placa
        Licencia lice  = new Licencia(0, new GregorianCalendar(2003, Calendar.JUNE, 1),100,new GregorianCalendar(2003, Calendar.JUNE, 1),p);
        Placas placa = new Placas("ddd-123", new GregorianCalendar(2003, Calendar.JUNE, 1),150,new GregorianCalendar(2003, Calendar.JUNE, 1), p);
        //auto con placa
        Automovil auto = new Automovil("2003", "ferrari", "Veneno", "gris", "aaa",placa);
        Historial histo = new Historial(new GregorianCalendar(2003, Calendar.JUNE, 1), auto);

        // guarda
        entity.persist(lice);
        entity.persist(placa);
        entity.persist(auto);
        entity.persist(histo);



        entity.getTransaction().commit();
//        //Persona solicita otra placa
//        entity.getTransaction().begin();
//        Automovil autoencontrado=entity.find(Automovil.class,1);
//        Placas placa2 = new Placas("nue-vapla", new GregorianCalendar(2003, Calendar.JUNE, 1),150,new GregorianCalendar(2003, Calendar.JUNE, 1), p);
//        placa2.setHistorial(autoencontrado.getHistorial());
//        
//        entity.persist(placa2);
//        
//        autoencontrado.setPlacas(placa2);
//       
//        entity.merge(autoencontrado);     
//   
//        entity.getTransaction().commit();
          entity.getTransaction().begin();
          Placas p2=entity.find(Placas.class,2);
          if (p2!=null) {
          p2.setHistorial(histo);
          entity.merge(p2);  
          }   
          p2=entity.find(Placas.class,1);
          if (p2!=null) {
          p2.setHistorial(histo);
          entity.merge(p2);  
          } 
          entity.getTransaction().commit();
        entity.close();
        
        enti.close();
    }
}
