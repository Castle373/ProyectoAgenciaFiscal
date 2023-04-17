/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Placas;
import IPersistencia.IConexionBD;
import IPersistencia.IPlacasDAO;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author diego
 */
public class PlacasDAO implements IPlacasDAO {

    /**
     * Atributos de la clase.
     */
    private IConexionBD conexionBD;

    /**
     * Crea un nuevo objeto PlacasDAO con la conexión a la base de datos.
     *
     * @param conexionBD Conexión a la base de datos.
     */
    public PlacasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     *
     * Devuelve una lista de placas de un automóvil específico.
     *
     * @param idAutomovil ID del automóvil.
     * @return Lista de placas del automóvil.
     */
    @Override
    public List<Placas> listaPlacasAuto(int idAutomovil) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Placas> query = entityManager.createQuery("SELECT a FROM Placas a WHERE a.automovil.id = :idAutomovil", Placas.class);
        query.setParameter("idAutomovil", idAutomovil);
        List<Placas> listaAutos = query.getResultList();
        entityManager.getTransaction().commit();
        return listaAutos;
    }

    /**
     *
     * Agrega las placas de un automóvil al sistema.
     *
     * @param placas Placas del automóvil.
     * @return Objeto Placas agregado.
     */
    @Override
    public Placas agregarPlacas(Placas placas) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            // Buscar si existe una placa activa para el automóvil
            TypedQuery<Placas> query = entityManager.createQuery(
                    "SELECT p FROM Placas p WHERE p.automovil.id = :idAutomovil AND p.estado = :estadoActivo", Placas.class)
                    .setParameter("idAutomovil", placas.getAutomovil().getId())
                    .setParameter("estadoActivo", "ACTIVA");
            List<Placas> placasActivas = query.getResultList();

            // Si existe una placa activa, cambiar su estado a inactivo
            if (!placasActivas.isEmpty()) {
                Placas placaActiva = placasActivas.get(0);
                placaActiva.setEstado("INACTIVA");
                placaActiva.setFechaInactividad(new GregorianCalendar());
                entityManager.merge(placaActiva);

            }

            // Agregar la nueva placa
            entityManager.persist(placas);
            entityManager.flush();
            entityManager.refresh(placas);
            entityManager.getTransaction().commit();
            return placas;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error al agregar placa", e);
        } finally {
            entityManager.close();
        }
    }

    /**
     *
     * Devuelve una lista de todas las placas de automóviles registrados en el
     * sistema.
     *
     * @return Lista de placas de automóviles.
     */
    @Override
    public List<Placas> listaPlacas() {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Placas> query = entityManager.createQuery("SELECT p FROM Placas p", Placas.class);
        List<Placas> listaPlacas = query.getResultList();
        entityManager.getTransaction().commit();
        return listaPlacas;
    }

}
