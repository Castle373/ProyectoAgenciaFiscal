/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import Entity.Licencia;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ILicenciaNegocio {

    /**
     *
     * Obtiene la lista de Licencias de una persona específica.
     *
     * @param id el identificador de la Persona.
     * @return la lista de Licencias de la persona.
     */
    public List<Licencia> listaLicenciaPersona(int id);

    /**
     *
     * Obtiene la lista de Licencias vigentes de una persona específica.
     *
     * @param id el identificador de la Persona.
     * @return la lista de Licencias vigentes de la persona.
     */
    public List<Licencia> listaLicenciaPersonaVigentes(int id);

    /**
     *
     * Agrega una nueva Licencia al sistema.
     *
     * @param licencia la Licencia a agregar.
     * @return la Licencia agregada.
     */
    public Licencia agregaLicencia(Licencia licencia);
}
