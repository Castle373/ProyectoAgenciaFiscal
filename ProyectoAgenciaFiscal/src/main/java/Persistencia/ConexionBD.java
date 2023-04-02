package Persistencia;

import IPersistencia.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ConexionBD implements IConexionBD {

    @Override
    public EntityManager crearConexion() throws PersistenceException {
        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionD");

        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();

        return entityManager;
    }
}
