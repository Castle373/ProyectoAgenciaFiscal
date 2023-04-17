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

    /**
     *
     * Devuelve una lista de placas de un automóvil específico.
     *
     * @param id ID del automóvil.
     * @return Lista de placas del automóvil.
     */
    public List<Placas> listaPlacasAuto(int id);

    /**
     *
     * Devuelve una lista de todas las placas de automóviles registrados en el
     * sistema.
     *
     * @return Lista de placas de automóviles.
     */
    public List<Placas> listaPlacas();

    /**
     *
     * Agrega las placas de un automóvil al sistema.
     *
     * @param placas Placas del automóvil.
     * @return Objeto Placas agregado.
     */
    public Placas agregarPlacas(Placas placas);
}
