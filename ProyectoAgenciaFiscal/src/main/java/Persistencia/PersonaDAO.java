/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Persona;
import IPersistencia.IConexionBD;
import IPersistencia.IPersonaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabriel
 */
public class PersonaDAO implements IPersonaDAO{
    private IConexionBD conexionBD;

    public PersonaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public List<Persona> listaPersonas() {
       
       EntityManager entityManager = this.conexionBD.crearConexion();
       entityManager.getTransaction().begin();
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
       
       TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);
       List<Persona> listasPersonas = query.getResultList();
       entityManager.getTransaction().commit();
       
       return listasPersonas;
    }
    public List<Persona> listaPersonas(String nombre, String rfc, String curp) {
   EntityManager entityManager = this.conexionBD.crearConexion();
   entityManager.getTransaction().begin();
   CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
   CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
   Root<Persona> persona = criteriaQuery.from(Persona.class);
   criteriaQuery.select(persona);

   List<Predicate> predicados = new ArrayList<Predicate>();

   if (nombre != null && !nombre.isEmpty()) {
       predicados.add(criteriaBuilder.like(criteriaBuilder.lower(persona.get("nombre")), "%" + nombre.toLowerCase() + "%"));
   }

   if (rfc != null && !rfc.isEmpty()) {
       predicados.add(criteriaBuilder.equal(persona.get("rfc"), rfc));
   }

   if (curp != null && !curp.isEmpty()) {
       predicados.add(criteriaBuilder.equal(persona.get("curp"), curp));
   }

   if (!predicados.isEmpty()) {
       criteriaQuery.where(predicados.toArray(new Predicate[predicados.size()]));
   }

   TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);
   List<Persona> listasPersonas = query.getResultList();
   entityManager.getTransaction().commit();

   return listasPersonas;
}
    
    
 @Override
public List<Persona> listaPersonas(String filtro) {
   EntityManager entityManager = this.conexionBD.crearConexion();
   entityManager.getTransaction().begin();
   CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
   CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
   Root<Persona> persona = criteriaQuery.from(Persona.class);
   criteriaQuery.select(persona);

   if (filtro != null && !filtro.isEmpty()) {
       filtro = "%" + filtro.toLowerCase() + "%";
       Predicate predicadoNombre = criteriaBuilder.like(criteriaBuilder.lower(persona.get("nombre")), filtro);
       Predicate predicadoRFC = criteriaBuilder.like(criteriaBuilder.lower(persona.get("rfc")), filtro);
       Predicate predicadoCURP = criteriaBuilder.like(criteriaBuilder.lower(persona.get("curp")), filtro);
       criteriaQuery.where(criteriaBuilder.or(predicadoNombre, predicadoRFC, predicadoCURP));
   }

   TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);
   List<Persona> listasPersonas = query.getResultList();
   entityManager.getTransaction().commit();

   return listasPersonas;
}

    @Override
    public Persona agregarPersona(Persona persona) {
       EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(persona);
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return persona; 
    }

    @Override
    public Persona editarPersona(Persona persona) {
       EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(persona);
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return persona;  
    }
  
    @Override
    public int Edad(Persona persona) {
     
   Calendar calendario=persona.getFechaNacimiento();
   int anio=calendario.get(Calendar.YEAR);
   int mes=calendario.get(Calendar.MONTH);
   int dia=calendario.get(Calendar.DAY_OF_MONTH);
        Calendar fechaNacimiento = new GregorianCalendar(anio, mes, dia);
Calendar ahora = Calendar.getInstance();

long edadEnDias = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis())
                        / 1000 / 60 / 60 / 24;

int anos = Double.valueOf(edadEnDias / 365.25d).intValue();
return anos;
    }
}
