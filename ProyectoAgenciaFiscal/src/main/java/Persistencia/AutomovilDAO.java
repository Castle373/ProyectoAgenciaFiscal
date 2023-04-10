/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Automovil;
import Entity.Persona;
import IPersistencia.IAutomovilDAO;
import IPersistencia.IConexionBD;
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
public class AutomovilDAO implements IAutomovilDAO {

    private IConexionBD conexionBD;

    public AutomovilDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Automovil> listaAutosPersona(int idPersona) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Automovil> query = entityManager.createQuery("SELECT a FROM Automovil a WHERE a.persona.id = :idPersona", Automovil.class);
        query.setParameter("idPersona", idPersona);
        List<Automovil> listaAutos = query.getResultList();
        entityManager.getTransaction().commit();
        return listaAutos;
    }

    @Override
    public List<Automovil> listaAutosPersona(int id, String filtro) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();

        TypedQuery<Automovil> query = entityManager.createQuery(
                "SELECT a FROM Automovil a WHERE a.persona.id = :id "
                + "AND (a.NumeroDeSerie LIKE :filtro "
                + "OR a.marca LIKE :filtro "
                + "OR a.modelo LIKE :filtro "
                + "OR a.linea LIKE :filtro)",
                Automovil.class
        );
        query.setParameter("id", id);
        query.setParameter("filtro", "%" + filtro + "%");

        List<Automovil> listaAutos = query.getResultList();
        entityManager.getTransaction().commit();

        return listaAutos;
    }

    @Override
    public Automovil agregaAuto(Automovil auto) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(auto);
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return auto;
    }

    @Override
    public List<Automovil> listaAutos() {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Automovil> query = entityManager.createQuery("SELECT a FROM Automovil a", Automovil.class);
        List<Automovil> listaAuto = query.getResultList();
        entityManager.getTransaction().commit();
        return listaAuto;
    }

}
