/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INegocio;

import Entity.Automovil;
import Entity.Placas;
import Excepciones.PlacaException;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IPlacasNegocio {

    /**
     *
     * Obtiene la lista de placas asociadas a un automóvil.
     *
     * @param id Identificador del automóvil.
     * @return Lista de objetos Placas.
     */
    public List<Placas> BuscarPorAuto(int id);

    /**
     *
     * Registra una nueva placa en el sistema.
     *
     * @param placas Objeto Placas a registrar.
     * @return Objeto Placas registrado.
     * @throws PlacaException Si se produce un error durante el registro de la
     * placa.
     */
    public Placas registrarPlaca(Placas placas) throws PlacaException;
}
