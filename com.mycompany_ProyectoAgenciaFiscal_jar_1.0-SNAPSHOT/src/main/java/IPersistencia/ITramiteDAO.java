/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entity.Persona;
import Entity.Tramite;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ITramiteDAO {

    /**
     *
     * Devuelve una lista de trámites que corresponden a los filtros indicados.
     *
     * @param placas indica si se deben incluir trámites de placas
     * @param licencia indica si se deben incluir trámites de licencia
     * @param fechaInicio fecha de inicio del periodo en el que se buscan
     * trámites
     * @param fechaFin fecha de fin del periodo en el que se buscan trámites
     * @return lista de trámites que cumplen con los filtros
     */
    public List<Tramite> listaTramite(boolean placas, boolean licencia, LocalDate fechaInicio, LocalDate fechaFin);

    /**
     *
     * Devuelve una lista de trámites realizados por una persona específica.
     *
     * @param persona objeto de tipo Persona para el cual se buscan los trámites
     * @return lista de trámites realizados por la persona especificada
     */
    public List<Tramite> listaTramitePersona(Persona persona);
}
