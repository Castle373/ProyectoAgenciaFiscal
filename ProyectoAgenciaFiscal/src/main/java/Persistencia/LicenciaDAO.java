/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Licencia;
import IPersistencia.IConexionBD;
import IPersistencia.ILicenciaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel
 */
public class LicenciaDAO implements ILicenciaDAO {

    private IConexionBD conexionBD;

    public LicenciaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    
    @Override
    public List<Licencia> listaLicenciaPersona(int id) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Licencia> query = entityManager.createQuery("SELECT l FROM Licencia l WHERE l.persona.id = :idPersona", Licencia.class);
        query.setParameter("idPersona", id);
        List<Licencia> listaLicencia = query.getResultList();
        entityManager.getTransaction().commit();
        return listaLicencia;
    }

    @Override
    public List<Licencia> listaLicenciaPersonaVigentes(int id) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        TypedQuery<Licencia> query = entityManager.createQuery("SELECT l FROM Licencia l "
             + "WHERE l.persona.id = :idPersona AND l.FechaVigencia > CURRENT_DATE",Licencia.class);
        query.setParameter("idPersona", id);
        List<Licencia> listaLicencia = query.getResultList();
        entityManager.getTransaction().commit();
        return listaLicencia;
    }

    @Override
    public Licencia agregaLicencia(Licencia licencia) {
       EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(licencia);
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return licencia; 
    }

}
