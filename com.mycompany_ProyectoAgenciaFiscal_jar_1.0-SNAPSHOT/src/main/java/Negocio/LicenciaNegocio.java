/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Licencia;
import INegocio.ILicenciaNegocio;
import IPersistencia.ILicenciaDAO;
import java.util.List;

/**
 *
 * @author diego
 */
public class LicenciaNegocio implements ILicenciaNegocio {

    private ILicenciaDAO licenciaDAO;

    /**
     *
     * Constructor de la clase LicenciaNegocio.
     *
     * @param licenciaDAO El objeto DAO que se encarga de interactuar con la
     * capa de persistencia de datos.
     */
    public LicenciaNegocio(ILicenciaDAO licenciaDAO) {
        this.licenciaDAO = licenciaDAO;
    }

    /**
     *
     * Obtiene una lista de las licencias de una persona.
     *
     * @param id El identificador de la persona.
     * @return Una lista de licencias asociadas a la persona.
     */
    public List<Licencia> listaLicenciaPersona(int id) {
        return licenciaDAO.listaLicenciaPersona(id);
    }

    /**
     *
     * Obtiene una lista de las licencias vigentes de una persona.
     *
     * @param id El identificador de la persona.
     * @return Una lista de licencias vigentes asociadas a la persona.
     */
    public List<Licencia> listaLicenciaPersonaVigentes(int id) {
        return licenciaDAO.listaLicenciaPersonaVigentes(id);
    }

    /**
     *
     * Agrega una nueva licencia a la base de datos.
     *
     * @param licencia La nueva licencia a agregar.
     * @return La licencia agregada con su identificador actualizado.
     */
    public Licencia agregaLicencia(Licencia licencia) {
        return licenciaDAO.agregaLicencia(licencia);
    }

}
