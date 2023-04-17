/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import static Entity.Automovil_.persona;
import Entity.Persona;
import INegocio.IPersonaNegocio;
import IPersistencia.IPersonaDAO;
import Persistencia.Encriptacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class PersonaNegocio implements IPersonaNegocio {

    private IPersonaDAO personaDAO;

    /**
     *
     * Constructor de la clase PersonaNegocio que recibe como parámetro una
     * instancia de la interfaz IPersonaDAO.
     *
     * @param personaDAO una instancia de la interfaz IPersonaDAO para acceder a
     * la capa de datos.
     * @return void.
     */
    public PersonaNegocio(IPersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    /**
     *
     * Método que devuelve una lista de todas las personas almacenadas en la
     * base de datos.
     *
     * @return una lista de objetos Persona.
     */
    @Override
    public List<Persona> BuscarPersonas() {
        return personaDAO.listaPersonas();
    }

    /**
     *
     * Método que devuelve una lista de personas filtradas por nombre, CURP o
     * RFC.
     *
     * @param filtro una cadena de texto que indica el filtro a aplicar.
     * @return una lista de objetos Persona que cumplen con el filtro
     * especificado.
     */
    @Override
    public List<Persona> BuscarPersonas(String Filtro) {
        List<Persona> listaPersonaFiltrada = personaDAO.listaPersonas();
        Encriptacion AES = new Encriptacion();
        listaPersonaFiltrada = AES.desencriptarLista(listaPersonaFiltrada);
        
        List<Persona> listaPorNombre = new ArrayList<Persona>();
        
        for (Persona persona : listaPersonaFiltrada) {
            String nombreCompleto = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
            if (nombreCompleto.toLowerCase().contains(Filtro.toLowerCase())) {
                listaPorNombre.add(persona);
            } else if (persona.getCurp().toLowerCase().contains(Filtro.toLowerCase())) {
                listaPorNombre.add(persona);
            } else if (persona.getRfc().toLowerCase().contains(Filtro.toLowerCase())) {
                listaPorNombre.add(persona);
            }
        }
        return listaPorNombre;
    }

    /**
     *
     * Método que agrega una persona a la base de datos.
     *
     * @param persona un objeto Persona que contiene la información de la
     * persona a agregar.
     * @return un objeto Persona que representa la persona agregada.
     */
    @Override
    public Persona agregarPersona(Persona persona) {
        return personaDAO.agregarPersona(persona);
    }

    /**
     *
     * Método que edita la información de una persona en la base de datos.
     *
     * @param persona un objeto Persona que contiene la información actualizada
     * de la persona.
     * @return un objeto Persona que representa la persona actualizada.
     */
    @Override
    public Persona editarPersona(Persona persona) {
        return personaDAO.editarPersona(persona);
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @param persona la persona de la que se desea conocer la edad.
     * @return la edad de la persona.
     */
    @Override
    public int Edad(Persona persona) {
        return personaDAO.Edad(persona);
    }

    /**
     * Obtiene una lista de personas filtradas por RFC, CURP, año de nacimiento
     * y/o nombre completo.
     *
     * @param rfc el RFC a buscar.
     * @param curp la CURP a buscar.
     * @param nacimientoY el año de nacimiento a buscar.
     * @param filtroNombre el filtro de nombre completo a aplicar.
     * @return una lista de personas que cumplen con los criterios de búsqueda
     * especificados.
     */
    @Override
    public List<Persona> listaPersonas(String rfc, String curp, String nacimientoY, String filtroNombre) {
        Integer nacimiento = null;
        if (!nacimientoY.equals("")) {
            nacimiento = Integer.parseInt(nacimientoY);
            System.out.println(nacimiento);
        }
        List<Persona> listaFiltrada = personaDAO.listaPersonas(rfc, curp, nacimiento);
        Encriptacion AES = new Encriptacion();
        try {
            listaFiltrada = AES.desencriptarLista(listaFiltrada);
            
        } catch (Exception e) {
            listaFiltrada = AES.desencriptarLista(listaFiltrada);
        }
        
        List<Persona> listaPorNombre = new ArrayList<Persona>();
        if (!filtroNombre.equals("")) {
            for (Persona persona : listaFiltrada) {
                String nombreCompleto = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
                if (nombreCompleto.toLowerCase().contains(filtroNombre.toLowerCase())) {
                    listaPorNombre.add(persona);
                }
            }
            listaFiltrada = listaPorNombre;
        }
        return listaFiltrada;
    }

}
