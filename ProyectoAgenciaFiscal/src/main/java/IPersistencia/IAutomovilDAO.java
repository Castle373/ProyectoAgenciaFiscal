/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entity.Automovil;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IAutomovilDAO {
    public List<Automovil> listaAutos();
    public List<Automovil> listaAutosPersona(int id);
    public List<Automovil> listaAutosPersona(int id,String filtro);
    public Automovil agregaAuto(Automovil Automovil);
}
