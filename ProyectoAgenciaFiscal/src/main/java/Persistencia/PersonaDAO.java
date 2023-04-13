/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Persona;
import IPersistencia.IConexionBD;
import IPersistencia.IPersonaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
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
}
