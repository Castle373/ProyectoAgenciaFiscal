/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INegocio;

import Entity.Automovil;
import Entity.Placas;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IPlacasNegocio {
    public List<Placas> BuscarPorAuto(int id);
}
