/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Automovil;
import Entity.Persona;
import Excepciones.AutomovilException;
import INegocio.IAutomovilNegocio;
import IPersistencia.IAutomovilDAO;
import IPersistencia.IPersonaDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class AutomovilNegocio implements IAutomovilNegocio {

    private IAutomovilDAO automovilDAO;

    /**
     *
     * Constructor que recibe una instancia de IAutomovilDAO.
     *
     * @param automovilDAO la instancia de IAutomovilDAO a utilizar
     */
    public AutomovilNegocio(IAutomovilDAO automovilDAO) {
        this.automovilDAO = automovilDAO;
    }

    /**
     *
     * Busca los automóviles asociados a una persona específica.
     *
     * @param id el ID de la persona a buscar
     * @return una lista de Automoviles asociados a la persona
     */
    @Override
    public List<Automovil> BuscarAutomovilesPorPersona(int id) {
        return automovilDAO.listaAutosPersona(id);
    }

    /**
     *
     * Busca los automóviles asociados a una persona específica, filtrando por
     * modelo o marca.
     *
     * @param id el ID de la persona a buscar
     * @param filtro el filtro para la búsqueda
     * @return una lista de Automoviles asociados a la persona y que coinciden
     * con el filtro
     */
    @Override
    public List<Automovil> BuscarAutomovilesPorPersona(int id, String filtro) {
        return automovilDAO.listaAutosPersona(id, filtro);
    }

    /**
     *
     * Registra un nuevo automóvil en el sistema.
     *
     * @param auto el Automovil a agregar
     *
     * @return el Automovil agregado
     *
     * @throws AutomovilException si el número de serie ya existe en el sistema
     */
    @Override
    public Automovil registrarAutomovil(Automovil auto) throws AutomovilException {
        List<Automovil> lista = automovilDAO.listaAutos();
        for (int i = 0; i < lista.size(); i++) {
            if (auto.getNumeroDeSerie().equals(lista.get(i).getNumeroDeSerie())) {
                throw new AutomovilException("El número de serie ya existe");
            }
        }

        Automovil autoAgregado = automovilDAO.agregaAuto(auto);
        if (autoAgregado == null) {
            throw new AutomovilException("No se pudo agregar el automóvil");
        }

        return autoAgregado;
    }

    /**
     *
     * Cambia el dueño de un Automovil.
     *
     * @param auto el Automovil a modificar
     * @param persona la nueva persona dueña del Automovil
     * @return el Automovil modificado
     */
    @Override
    public Automovil cambiarDueño(Automovil auto, Persona persona) {
        return automovilDAO.cambiarDueño(auto, persona);
    }

    /**
     *
     * Elimina el dueño de un automóvil.
     *
     * @param auto El automóvil al que se le desea eliminar el dueño.
     * @return El automóvil actualizado sin dueño.
     */
    /**
     *
     * Elimina el dueño de un automóvil.
     *
     * @param auto El automóvil al que se le desea eliminar el dueño.
     * @return El automóvil actualizado sin dueño.
     */
    public Automovil bajaDueño(Automovil auto) {
        return automovilDAO.bajaDueño(auto);
    }

    /**
     *
     * Obtiene una lista de automóviles que no tienen dueño.
     *
     * @return Una lista de automóviles sin dueño.
     */
    public List<Automovil> listaAutosSinDueño() {
        return automovilDAO.listaAutosSinPersona();
    }
}
