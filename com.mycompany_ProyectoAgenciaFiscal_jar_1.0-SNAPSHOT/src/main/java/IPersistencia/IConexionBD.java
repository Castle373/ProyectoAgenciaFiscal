package IPersistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public interface IConexionBD {

    /**
     *
     * Crea una conexión a la base de datos a través del EntityManager.
     *
     * @return una instancia del EntityManager que representa la conexión a la
     * base de datos
     * @throws PersistenceException si ocurre un error al crear la conexión
     */
    public EntityManager crearConexion() throws PersistenceException;
}
