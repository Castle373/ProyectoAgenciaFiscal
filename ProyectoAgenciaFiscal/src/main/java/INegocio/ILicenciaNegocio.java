/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import Entity.Licencia;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ILicenciaNegocio {
    public List<Licencia> listaLicenciaPersona(int id);
    public List<Licencia> listaLicenciaPersonaVigentes(int id);
}
