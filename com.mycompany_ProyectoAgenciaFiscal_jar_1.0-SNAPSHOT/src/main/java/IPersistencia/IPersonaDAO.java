/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entity.Persona;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface IPersonaDAO {

    /**
     *
     * Obtiene una lista de todas las personas en la base de datos.
     *
     * @return una lista de objetos Persona
     */
    public List<Persona> listaPersonas();

    /**
     *
     * Obtiene una lista de personas en la base de datos que coinciden con un
     * filtro de búsqueda.
     *
     * @param filtro el filtro de búsqueda a aplicar
     * @return una lista de objetos Persona que coinciden con el filtro
     */
    public List<Persona> listaPersonas(String filtro);

    /**
     *
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona la persona a agregar
     * @return la persona recién agregada
     */
    public Persona agregarPersona(Persona persona);

    /**
     *
     * Actualiza la información de una persona en la base de datos.
     *
     * @param persona la persona con la información actualizada
     * @return la persona con la información actualizada
     */
    public Persona editarPersona(Persona persona);

    /**
     *
     * Calcula la edad de una persona a partir de su fecha de nacimiento.
     *
     * @param persona la persona de la cual se quiere calcular la edad
     * @return la edad de la persona en años
     */
    public int Edad(Persona persona);

    /**
     *
     * Obtiene una lista de personas en la base de datos que coinciden con
     * ciertos parámetros de búsqueda.
     *
     * @param rfc el RFC de la persona a buscar
     * @param curp el CURP de la persona a buscar
     * @param nacimientoY el año de nacimiento de la persona a buscar (opcional)
     * @return una lista de objetos Persona que coinciden con los parámetros de
     * búsqueda
     */
    public List<Persona> listaPersonas(String rfc, String curp, Integer nacimientoY);
}
