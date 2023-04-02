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
import java.util.List;

/**
 *
 * @author diego
 */
public class PlacasNegocio implements IPlacasNegocio {

    private IPlacasDAO placasDAO;

    public PlacasNegocio(IPlacasDAO placasDAO) {
        this.placasDAO = placasDAO;
    }

    @Override
    public List<Placas> BuscarPorAuto(int id) {
        return placasDAO.listaPlacasAuto(id);
    }

//    @Override
//    public Placas registrarPlaca(Placas placas) {
//        List<Placas> lista = placasDAO.listaPlacas();
//        for (int i = 0; i < lista.size(); i++) {
//            if (placas.getNumeroPlacas().equals(lista.get(i).getNumeroPlacas())) {
//                return null;
//            }
//        }
//
//        return placasDAO.agregarPlacas(placas);
//    }

    @Override
    public Placas registrarPlaca(Placas placas)throws PlacaException {
        List<Placas> lista = placasDAO.listaPlacas();
        for (int i = 0; i < lista.size(); i++) {
            if (placas.getNumeroPlacas().equals(lista.get(i).getNumeroPlacas())) {
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
