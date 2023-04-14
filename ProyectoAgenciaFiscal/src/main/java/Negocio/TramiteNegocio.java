/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Persona;
import Entity.Tramite;
import INegocio.ITramiteNegocio;
import IPersistencia.ITramiteDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author diego
 */
public class TramiteNegocio implements ITramiteNegocio{

    private ITramiteDAO tramiteDAO;

    public TramiteNegocio(ITramiteDAO tramiteDAO) {
        this.tramiteDAO = tramiteDAO;
    }
    
    @Override
    public List<Tramite> listaTramite(boolean placas, boolean licencia, LocalDate fechaInicio, LocalDate fechaFin) {
       return tramiteDAO.listaTramite(placas, licencia, fechaInicio, fechaFin);
    }

    @Override
    public List<Tramite> listaTramitePersona(Persona persona) {
        return tramiteDAO.listaTramitePersona(persona);
    }
    
}
