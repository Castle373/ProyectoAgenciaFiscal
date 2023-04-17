/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Automovil;
import Entity.Persona;
import Entity.Placas;
import IPersistencia.IAutomovilDAO;
import IPersistencia.IConexionBD;
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
 * @author diego
 */
public class AutomovilDAO implements IAutomovilDAO {

    /**
     * Atributos de la clase.
     */
    private IConexionBD conexionBD;

    /**
     * Crea un nuevo objeto AutomovilDAO con la conexión a la base de datos.
     *
     * @param conexionBD Conexión a la base de datos.
     */
    public AutomovilDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene una lista de Automoviles que pertenecen a una Persona
     * especificada por su ID.
     *
     * @param idPersona ID de la Persona dueña de los Automoviles.
     * @return Lista de Automoviles que pertenecen a la Persona.
     */
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

    /**
     *
     * Obtiene una lista de Automoviles que pertenecen a una Persona
     * especificada por su ID y que cumplen con un criterio de filtro.
     *
     * @param id ID de la Persona dueña de los Automoviles.
     * @param filtro Cadena de texto para filtrar los Automoviles por modelo,
     * marca, etc.
     * @return Lista de Automoviles que pertenecen a la Persona y cumplen con el
     * filtro especificado.
     */
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

    /**
     * Agrega un nuevo Automovil al sistema.
     *
     * @param auto Nuevo Automovil a agregar.
     * @return El Automovil agregado con su ID asignado.
     */
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

    /**
     *
     * Obtiene una lista de todos los Automoviles registrados en el sistema.
     *
     * @return Lista de Automoviles registrados.
     */
    @Override
    public List<Automovil> listaAutos() {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Automovil> query = entityManager.createQuery("SELECT a FROM Automovil a", Automovil.class);
        List<Automovil> listaAuto = query.getResultList();
        entityManager.getTransaction().commit();
        return listaAuto;
    }

    /**
     *
     * Obtiene una lista de Automoviles que no tienen una Persona dueña
     * asignada.
     *
     * @return Lista de Automoviles sin dueño asignado.
     */
    @Override
    public List<Automovil> listaAutosSinPersona() {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Automovil> query = entityManager.createQuery("SELECT a FROM Automovil a WHERE a.persona IS NULL", Automovil.class);
        List<Automovil> listaAutoSinPersona = query.getResultList();
        entityManager.getTransaction().commit();
        return listaAutoSinPersona;
    }

    /**
     *
     * Obtiene una lista de Automoviles que no tienen una Persona dueña
     * asignada.
     *
     * @return Lista de Automoviles sin dueño asignado.
     */
    public List<Automovil> listaAutosSinPersona2() {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Automovil> query = entityManager.createQuery("SELECT a FROM Automovil a LEFT JOIN a.persona p WHERE a.persona IS NULL", Automovil.class);
        List<Automovil> listaAutoSinPersona = query.getResultList();
        entityManager.getTransaction().commit();
        return listaAutoSinPersona;
    }

    /**
     *
     * Cambia el dueño de un Automovil especificado por su ID.
     *
     * @param auto Automovil al que se le cambiará el dueño.
     * @param persona Nueva Persona dueña del Automovil.
     * @return El Automovil actualizado con su nuevo dueño asignado.
     */
    @Override
    public Automovil cambiarDueño(Automovil auto, Persona persona) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            Automovil automovil = entityManager.find(Automovil.class, auto.getId());
            if (automovil != null) {

                automovil.setPersona(persona);
                entityManager.merge(automovil);
                entityManager.getTransaction().commit();
                return automovil;
            }
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return null;
    }

    /**
     *
     * Elimina el dueño de un Automovil especificado por su ID.
     *
     * @param auto Automovil al que se le eliminará el dueño.
     * @return El Automovil actualizado sin dueño asignado.
     */
    @Override
    public Automovil bajaDueño(Automovil auto) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            Automovil automovil = entityManager.find(Automovil.class, auto.getId());
            if (automovil != null) {
                List<Placas> placas = automovil.getPlacas();
                for (Placas placa : placas) {
                    if (placa.getEstado().equals("ACTIVA")) {
                        // cambiar el estado a Desactivado y agregar la fecha de inactividad
                        placa.setEstado("INACTIVA");
                        placa.setFechaInactividad(new GregorianCalendar());
                        entityManager.merge(placa);
                    }
                }
                Persona persona = automovil.getPersona();
                automovil.setPersona(null);
                entityManager.merge(automovil);
                entityManager.getTransaction().commit();
                return automovil;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return null;
    }

}
