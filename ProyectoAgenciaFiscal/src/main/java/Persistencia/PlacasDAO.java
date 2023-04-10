/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Placas;
import IPersistencia.IConexionBD;
import IPersistencia.IPlacasDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author diego
 */
public class PlacasDAO implements IPlacasDAO {

    private IConexionBD conexionBD;

    public PlacasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

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
                entityManager.merge(placaActiva);
                Query query2 = entityManager.createQuery("SELECT p FROM Placas p WHERE p.id = :id");
                query2.setParameter("id", placaActiva.getId());
                Placas placasActualizadas = (Placas) query2.getSingleResult();
            }

            // Agregar la nueva placa
            entityManager.persist(placas);

            entityManager.getTransaction().commit();
            return placas;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error al agregar placa", e);
        } finally {
            entityManager.close();
        }
    }

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
