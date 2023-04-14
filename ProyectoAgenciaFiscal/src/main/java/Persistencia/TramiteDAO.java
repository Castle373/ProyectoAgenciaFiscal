/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Licencia;
import Entity.Persona;
import Entity.Placas;
import Entity.Tramite;
import IPersistencia.IConexionBD;
import IPersistencia.ITramiteDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
 */
public class TramiteDAO implements ITramiteDAO {

    private IConexionBD conexionBD;

    public TramiteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Tramite> listaTramite(boolean tipo1, boolean tipo2, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> tramite = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(tramite);

        Join<Tramite, Persona> persona = tramite.join("persona");

        List<Predicate> predicados = new ArrayList<Predicate>();

        if (tipo1 && !tipo2) {
            Predicate p1 = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class), tramite.type());
            predicados.add(p1);
        } else if (tipo2 && !tipo1) {
            Predicate p2 = criteriaBuilder.equal(criteriaBuilder.literal(Placas.class), tramite.type());
            predicados.add(p2);
        } else if (tipo1 && tipo2) {
            Predicate p1 = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class), tramite.type());
            Predicate p2 = criteriaBuilder.equal(criteriaBuilder.literal(Placas.class), tramite.type());
            predicados.add(criteriaBuilder.or(p1, p2));
        }

        if (nombre != null && !nombre.isEmpty()) {
            predicados.add(criteriaBuilder.like(criteriaBuilder.lower(persona.get("nombre")), "%" + nombre.toLowerCase() + "%"));
        }

        if (fechaInicio != null && fechaFin != null) {
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(fechaInicio);
            java.sql.Date fechaFinSQL = java.sql.Date.valueOf(fechaFin);
            predicados.add(criteriaBuilder.between(tramite.get("fechaTramite"), fechaInicioSQL, fechaFinSQL));
        }

        if (!predicados.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.and(predicados.toArray(new Predicate[predicados.size()])));
        }

        TypedQuery<Tramite> query = entityManager.createQuery(criteriaQuery);
        List<Tramite> listaTramites = query.getResultList();
        entityManager.getTransaction().commit();

        return listaTramites;
    }

    @Override
    public List<Tramite> listaTramitePersona(Persona persona) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t WHERE t.persona.id = :idPersona", Tramite.class);
        query.setParameter("idPersona", persona.getId());
        List<Tramite> listaTramite = query.getResultList();
        entityManager.getTransaction().commit();
        return listaTramite;
    }

}
