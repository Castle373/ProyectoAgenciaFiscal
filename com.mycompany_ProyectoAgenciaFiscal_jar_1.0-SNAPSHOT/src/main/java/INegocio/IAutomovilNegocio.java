/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INegocio;

import Entity.Automovil;
import Entity.Persona;
import Excepciones.AutomovilException;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IAutomovilNegocio {

    /**
     *
     * Busca los automóviles pertenecientes a una persona en particular.
     *
     * @param id El ID de la persona propietaria de los automóviles.
     * @return Una lista de los automóviles que pertenecen a la persona.
     */
    public List<Automovil> BuscarAutomovilesPorPersona(int id);

    /**
     *
     * Busca los automóviles pertenecientes a una persona en particular, según
     * un filtro de búsqueda.
     *
     * @param id El ID de la persona propietaria de los automóviles.
     * @param filtro El filtro a aplicar en la búsqueda.
     * @return Una lista de los automóviles que pertenecen a la persona y
     * cumplen con el filtro.
     */
    public List<Automovil> BuscarAutomovilesPorPersona(int id, String filtro);

    /**
     *
     * Registra un nuevo automóvil en el sistema.
     *
     * @param auto El automóvil a registrar.
     * @return El automóvil registrado.
     * @throws AutomovilException Si ocurre un error durante el registro del
     * automóvil.
     */
    public Automovil registrarAutomovil(Automovil auto) throws AutomovilException;

    /**
     *
     * Cambia el dueño de un automóvil.
     *
     * @param auto El automóvil cuyo dueño se desea cambiar.
     * @param persona La nueva persona dueña del automóvil.
     * @return El automóvil con su nuevo dueño.
     */
    public Automovil cambiarDueño(Automovil auto, Persona persona);

    /**
     *
     * Elimina el dueño de un automóvil.
     *
     * @param auto El automóvil cuyo dueño se desea eliminar.
     * @return El automóvil sin dueño.
     */
    public Automovil bajaDueño(Automovil auto);

    /**
     *
     * Obtiene una lista de todos los automóviles que no tienen dueño.
     *
     * @return Una lista de los automóviles sin dueño.
     */
    public List<Automovil> listaAutosSinDueño();
}
