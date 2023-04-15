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
     public List<Persona> BuscarPersonas();
     public List<Persona> BuscarPersonas(String Filtro);
    public Persona agregarPersona(Persona persona);
    public Persona editarPersona(Persona persona);
    public int Edad(Persona persona);
    public List<Persona> listaPersonas( String rfc, String curp,Integer nacimientoY);
}
