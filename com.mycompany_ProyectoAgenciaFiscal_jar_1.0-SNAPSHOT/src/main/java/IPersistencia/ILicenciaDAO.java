/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entity.Licencia;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ILicenciaDAO {

    /**
     *
     * Obtiene una lista de todas las licencias de una persona específica.
     *
     * @param id el ID de la persona.
     * @return una lista de Licencias.
     */
    public List<Licencia> listaLicenciaPersona(int id);

    /**
     *
     * Obtiene una lista de todas las licencias vigentes de una persona
     * específica.
     *
     * @param id el ID de la persona.
     * @return una lista de Licencias.
     */
    public List<Licencia> listaLicenciaPersonaVigentes(int id);

    /**
     *
     * Agrega una nueva licencia a la base de datos.
     *
     * @param licencia la Licencia a agregar.
     * @return la Licencia agregada.
     */
    public Licencia agregaLicencia(Licencia licencia);

}
