/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPersistencia;

import Entity.Placas;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IPlacasDAO {
    public List<Placas> listaPlacasAuto(int id);
    public List<Placas> listaPlacas();
    public Placas agregarPlacas(Placas plascas);
}
