package IPersistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


public interface IConexionBD {
    public EntityManager crearConexion() throws PersistenceException;
}
