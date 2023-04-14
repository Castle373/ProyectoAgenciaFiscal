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
    public List<Tramite> listaTramite(boolean placas,boolean licencia,LocalDate fechaInicio,LocalDate fechaFin );
    public List<Tramite> listaTramitePersona(Persona persona);
}
