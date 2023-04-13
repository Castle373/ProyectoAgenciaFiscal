/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entity.Persona;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IPersonaDAO {
    public List<Persona> listaPersonas();
    public List<Persona> listaPersonas(String filtro);
    public Persona agregarPersona(Persona persona);
    public Persona editarPersona(Persona persona);
}
