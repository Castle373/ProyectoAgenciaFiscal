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
    public List<Automovil> BuscarAutomovilesPorPersona(int id);
    public List<Automovil> BuscarAutomovilesPorPersona(int id,String filtro);
    public Automovil registrarAutomovil(Automovil auto)throws AutomovilException;
}
