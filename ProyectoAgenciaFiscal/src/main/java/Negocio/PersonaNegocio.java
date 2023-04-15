/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Persona;
import INegocio.IPersonaNegocio;
import IPersistencia.IPersonaDAO;
import Persistencia.Encriptacion;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class PersonaNegocio implements IPersonaNegocio{
    
    private IPersonaDAO personaDAO;
    
    public PersonaNegocio(IPersonaDAO personaDAO){
       this.personaDAO=personaDAO;
    }
    @Override
    public List<Persona> BuscarPersonas() {
       return personaDAO.listaPersonas();
    }

    @Override
    public List<Persona> BuscarPersonas(String Filtro) {
        return personaDAO.listaPersonas(Filtro);
    }

    @Override
    public Persona agregarPersona(Persona persona) {

        return personaDAO.agregarPersona(persona);
    }

    @Override
    public Persona editarPersona(Persona persona) {
      return personaDAO.editarPersona(persona);
    }

    @Override
    public int Edad(Persona persona) {
  return personaDAO.Edad(persona);
    }
    
}
