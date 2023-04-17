/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Placas;
import Excepciones.PlacaException;
import INegocio.IPlacasNegocio;
import IPersistencia.IPersonaDAO;
import IPersistencia.IPlacasDAO;
import Persistencia.Encriptacion;
import java.util.List;

/**
 *
 * @author diego
 */
public class PlacasNegocio implements IPlacasNegocio {

    private IPlacasDAO placasDAO;

    /**
     *
     * Constructor de la clase PlacasNegocio.
     *
     * @param placasDAO El objeto DAO que se encarga de interactuar con la capa
     * de persistencia de datos.
     */
    public PlacasNegocio(IPlacasDAO placasDAO) {
        this.placasDAO = placasDAO;
    }

    /**
     *
     * Obtiene una lista de las placas asociadas a un automóvil.
     *
     * @param id El identificador del automóvil.
     *
     * @return Una lista de placas asociadas al automóvil.
     */
    public List<Placas> BuscarPorAuto(int id) {
        List<Placas> listaPlacaAuto = placasDAO.listaPlacasAuto(id);
        Encriptacion aes = new Encriptacion();
        listaPlacaAuto = aes.desencriptarListaPlacas(listaPlacaAuto);

        return listaPlacaAuto;
    }

    /**
     *
     * Registra una nueva placa en la base de datos.
     *
     * @param placas La nueva placa a registrar.
     *
     * @return La placa registrada con su identificador actualizado.
     *
     * @throws PlacaException Si la placa ya existe o si no se pudo agregar la
     * placa.
     */
    public Placas registrarPlaca(Placas placas) throws PlacaException {
        List<Placas> lista = placasDAO.listaPlacas();
        for (int i = 0; i < lista.size(); i++) {
            if (placas.getNumeroPlacas() == null) {
                i = lista.size();
            } else if (placas.getNumeroPlacas().equals(lista.get(i).getNumeroPlacas())) {
                throw new PlacaException("La placa ya existe");
            }
        }

        Placas placaAgregada = placasDAO.agregarPlacas(placas);
        if (placaAgregada == null) {
            throw new PlacaException("No se pudo agregar la placa");
        }

// Si la placa se agregó correctamente, retornar la placa
        return placaAgregada;
    }

}
