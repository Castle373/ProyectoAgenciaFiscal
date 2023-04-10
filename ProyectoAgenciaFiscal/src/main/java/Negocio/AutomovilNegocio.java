/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entity.Automovil;
import Excepciones.AutomovilException;
import INegocio.IAutomovilNegocio;
import IPersistencia.IAutomovilDAO;
import IPersistencia.IPersonaDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class AutomovilNegocio implements IAutomovilNegocio {

    private IAutomovilDAO automovilDAO;

    public AutomovilNegocio(IAutomovilDAO automovilDAO) {
        this.automovilDAO = automovilDAO;
    }

    @Override
    public List<Automovil> BuscarAutomovilesPorPersona(int id) {
        return automovilDAO.listaAutosPersona(id);
    }

    @Override
    public List<Automovil> BuscarAutomovilesPorPersona(int id, String filtro) {
        return automovilDAO.listaAutosPersona(id, filtro);
    }

    @Override
    public Automovil registrarAutomovil(Automovil auto) throws AutomovilException {
        List<Automovil> lista = automovilDAO.listaAutos();
        for (int i = 0; i < lista.size(); i++) {
            if (auto.getNumeroDeSerie().equals(lista.get(i).getNumeroDeSerie())) {
                throw new AutomovilException("El número de serie ya existe");
            }
        }

        Automovil autoAgregado = automovilDAO.agregaAuto(auto);
        if (autoAgregado == null) {
            throw new AutomovilException("No se pudo agregar el automóvil");
        }

        return autoAgregado;
    }

}
