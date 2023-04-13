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
public class LicenciaNegocio implements ILicenciaNegocio{

    private ILicenciaDAO licenciaDAO;

    public LicenciaNegocio(ILicenciaDAO licenciaDAO) {
        this.licenciaDAO = licenciaDAO;
    }
    @Override
    public List<Licencia> listaLicenciaPersona(int id) {
       return licenciaDAO.listaLicenciaPersona(id);
    }

    @Override
    public List<Licencia> listaLicenciaPersonaVigentes(int id) {
       return licenciaDAO.listaLicenciaPersonaVigentes(id);
    }

    @Override
    public Licencia agregaLicencia(Licencia licencia) {
       return licenciaDAO.agregaLicencia(licencia);
    }
    
}
