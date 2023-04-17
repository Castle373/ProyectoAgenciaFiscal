/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Persona;
import Entity.Tramite;
import INegocio.ITramiteNegocio;
import IPersistencia.ITramiteDAO;
import Persistencia.Encriptacion;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class TramiteNegocio implements ITramiteNegocio {

    private ITramiteDAO tramiteDAO;

    public TramiteNegocio(ITramiteDAO tramiteDAO) {
        this.tramiteDAO = tramiteDAO;
    }

    /**
     * Devuelve una lista de trámites filtrada por tipo de trámite (placas o
     * licencia), fecha de inicio, fecha de fin y/o nombre completo de la
     * persona que realizó el trámite.
     *
     * @param placas indica si se deben incluir trámites de placas en la lista
     * resultante
     * @param licencia indica si se deben incluir trámites de licencia en la
     * lista resultante
     * @param fechaInicio fecha de inicio del rango de fechas a considerar para
     * la búsqueda
     * @param fechaFin fecha de fin del rango de fechas a considerar para la
     * búsqueda
     * @param filtroNombre cadena que representa el nombre completo de la
     * persona que realizó el trámite, y que se usará como criterio de búsqueda.
     * Se ignorarán mayúsculas y minúsculas.
     *
     * @return una lista de trámites filtrada según los criterios de búsqueda
     * especificados
     */
    @Override
    public List<Tramite> listaTramite(boolean placas, boolean licencia, LocalDate fechaInicio, LocalDate fechaFin, String filtroNombre) {
        List<Tramite> listaTramiteFiltrada = tramiteDAO.listaTramite(placas, licencia, fechaInicio, fechaFin);
        Encriptacion AES = new Encriptacion();
        AES.desencriptarListaTramite(listaTramiteFiltrada);
        if (!filtroNombre.isEmpty()) {
            List<Tramite> listaPorNombre = new ArrayList<Tramite>();

            for (Tramite tramite : listaTramiteFiltrada) {
                String NombreCompleto = tramite.getPersona().getNombre() + " " + tramite.getPersona().getApellidoPaterno() + " " + tramite.getPersona().getApellidoMaterno();
                if (NombreCompleto.toLowerCase().contains(filtroNombre.toLowerCase())) {
                    listaPorNombre.add(tramite);
                }
            }
            listaTramiteFiltrada = listaPorNombre;
        }
        return listaTramiteFiltrada;
    }

    /**
     *
     * Obtiene una lista de todos los trámites realizados por una persona
     * específica.
     *
     * @param persona la persona de la que se desean obtener los trámites
     * realizados.
     * @return una lista de objetos Tramite que corresponden a los trámites
     * realizados por la persona especificada.
     */
    @Override
    public List<Tramite> listaTramitePersona(Persona persona) {
        return tramiteDAO.listaTramitePersona(persona);
    }

}
