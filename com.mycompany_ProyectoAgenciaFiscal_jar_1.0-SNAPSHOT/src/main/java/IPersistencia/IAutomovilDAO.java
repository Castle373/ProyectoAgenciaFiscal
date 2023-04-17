/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entity.Automovil;
import Entity.Persona;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IAutomovilDAO {

    /**
     *
     * Obtiene una lista de todos los Automoviles registrados en el sistema.
     *
     * @return Lista de Automoviles registrados.
     */
    public List<Automovil> listaAutos();

    /**
     *
     * Obtiene una lista de Automoviles que pertenecen a una Persona
     * especificada por su ID.
     *
     * @param id ID de la Persona dueña de los Automoviles.
     * @return Lista de Automoviles que pertenecen a la Persona.
     */
    public List<Automovil> listaAutosPersona(int id);

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
    public List<Automovil> listaAutosPersona(int id, String filtro);

    /**
     *
     * Agrega un nuevo Automovil al sistema.
     *
     * @param Automovil Nuevo Automovil a agregar.
     * @return El Automovil agregado con su ID asignado.
     */
    public Automovil agregaAuto(Automovil Automovil);

    /**
     *
     * Cambia el dueño de un Automovil especificado por su ID.
     *
     * @param auto Automovil al que se le cambiará el dueño.
     * @param persona Nueva Persona dueña del Automovil.
     * @return El Automovil actualizado con su nuevo dueño asignado.
     */
    public Automovil cambiarDueño(Automovil auto, Persona persona);

    /**
     *
     * Elimina el dueño de un Automovil especificado por su ID.
     *
     * @param auto Automovil al que se le eliminará el dueño.
     * @return El Automovil actualizado sin dueño asignado.
     */
    public Automovil bajaDueño(Automovil auto);

    /**
     *
     * Obtiene una lista de Automoviles que no tienen una Persona dueña
     * asignada.
     *
     * @return Lista de Automoviles sin dueño asignado.
     */
    public List<Automovil> listaAutosSinPersona();
}
