/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INegocio;

import Entity.Persona;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IPersonaNegocio {

    /**
     *
     * Busca todas las personas.
     *
     * @return Lista de todas las personas.
     */
    public List<Persona> BuscarPersonas();

    /**
     *
     * Busca las personas que cumplen con un criterio de búsqueda.
     *
     * @param filtro El criterio de búsqueda.
     * @return Lista de personas que cumplen con el criterio de búsqueda.
     */
    public List<Persona> BuscarPersonas(String filtro);

    /**
     *
     * Agrega una nueva persona.
     *
     * @param persona La persona a agregar.
     * @return La persona agregada.
     */
    public Persona agregarPersona(Persona persona);

    /**
     *
     * Edita los datos de una persona.
     *
     * @param persona La persona con los nuevos datos.
     * @return La persona con los datos actualizados.
     */
    public Persona editarPersona(Persona persona);

    /**
     *
     * Calcula la edad de una persona.
     *
     * @param persona La persona de la que se quiere conocer la edad.
     * @return La edad de la persona.
     */
    public int Edad(Persona persona);

    /**
     * Devuelve una lista de personas filtradas por RFC, CURP, año de nacimiento
     * y filtro adicional.
     *
     * @param rfc El RFC de la persona a buscar.
     * @param curp El CURP de la persona a buscar.
     * @param nacimientoY El año de nacimiento de la persona a buscar.
     * @param filtro Un filtro adicional para la búsqueda de personas.
     * @return Una lista de objetos Persona que cumplen con los criterios de
     * búsqueda especificados.
     */
    public List<Persona> listaPersonas(String rfc, String curp, String nacimientoY, String Filtro);
}
