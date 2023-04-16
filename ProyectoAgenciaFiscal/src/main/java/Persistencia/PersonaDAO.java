/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entity.Persona;
import IPersistencia.IConexionBD;
import IPersistencia.IPersonaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabriel
 */
public class PersonaDAO implements IPersonaDAO {

    /**
     * Atributos de la clase.
     */
    private IConexionBD conexionBD;

    /**
     * Crea un nuevo objeto PersonaDAO con la conexión a la base de datos.
     *
     * @param conexionBD Conexión a la base de datos.
     */
    public PersonaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     *
     * Obtiene una lista de todas las personas en la base de datos.
     *
     * @return una lista de objetos Persona
     */
    @Override
    public List<Persona> listaPersonas() {

        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);
        List<Persona> listasPersonas = query.getResultList();
        entityManager.getTransaction().commit();

        return listasPersonas;
    }

    /**
     *
     * Obtiene una lista de personas en la base de datos que coinciden con
     * ciertos parámetros de búsqueda.
     *
     * @param rfc el RFC de la persona a buscar
     * @param curp el CURP de la persona a buscar
     * @param nacimientoY el año de nacimiento de la persona a buscar (opcional)
     * @return una lista de objetos Persona que coinciden con los parámetros de
     * búsqueda
     */
    @Override
    public List<Persona> listaPersonas(String rfc, String curp, Integer nacimientoY) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> persona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(persona);

        List<Predicate> predicados = new ArrayList<Predicate>();

        if (rfc != null && !rfc.isEmpty()) {
            predicados.add(criteriaBuilder.like(persona.get("rfc"), "%" + rfc + "%"));
        }

        if (curp != null && !curp.isEmpty()) {
            predicados.add(criteriaBuilder.like(persona.get("curp"), "%" + curp + "%"));
        }
        if (nacimientoY != null) {
            predicados.add(criteriaBuilder.equal(
                    criteriaBuilder.function("YEAR", Integer.class, persona.get("fechaNacimiento")),
                    nacimientoY));
        }
        if (!predicados.isEmpty()) {
            criteriaQuery.where(predicados.toArray(new Predicate[predicados.size()]));
        }

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);
        List<Persona> listasPersonas = query.getResultList();
        entityManager.getTransaction().commit();

        return listasPersonas;
    }

    /**
     *
     * Obtiene una lista de personas en la base de datos que coinciden con un
     * filtro de búsqueda.
     *
     * @param filtro el filtro de búsqueda a aplicar
     * @return una lista de objetos Persona que coinciden con el filtro
     */
    @Override
    public List<Persona> listaPersonas(String filtro) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> persona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(persona);

        if (filtro != null && !filtro.isEmpty()) {
            filtro = "%" + filtro.toLowerCase() + "%";
            Predicate predicadoNombre = criteriaBuilder.like(criteriaBuilder.lower(persona.get("nombre")), filtro);
            Predicate predicadoRFC = criteriaBuilder.like(criteriaBuilder.lower(persona.get("rfc")), filtro);
            Predicate predicadoCURP = criteriaBuilder.like(criteriaBuilder.lower(persona.get("curp")), filtro);
            criteriaQuery.where(criteriaBuilder.or(predicadoNombre, predicadoRFC, predicadoCURP));
        }

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);
        List<Persona> listasPersonas = query.getResultList();
        entityManager.getTransaction().commit();

        return listasPersonas;
    }

    /**
     *
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona la persona a agregar
     * @return la persona recién agregada
     */
    @Override
    public Persona agregarPersona(Persona persona) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(persona);
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return persona;
    }

    /**
     *
     * Actualiza la información de una persona en la base de datos.
     *
     * @param persona la persona con la información actualizada
     * @return la persona con la información actualizada
     */
    @Override
    public Persona editarPersona(Persona persona) {
        EntityManager entityManager = this.conexionBD.crearConexion();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(persona);
        } catch (Exception e) {
            return null;
        }
        entityManager.getTransaction().commit();
        return persona;
    }

    /**
     *
     * Calcula la edad de una persona a partir de su fecha de nacimiento.
     *
     * @param persona la persona de la cual se quiere calcular la edad
     * @return la edad de la persona en años
     */
    @Override
    public int Edad(Persona persona) {

        Calendar calendario = persona.getFechaNacimiento();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        Calendar fechaNacimiento = new GregorianCalendar(anio, mes, dia);
        Calendar ahora = Calendar.getInstance();

        long edadEnDias = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis())
                / 1000 / 60 / 60 / 24;

        int anos = Double.valueOf(edadEnDias / 365.25d).intValue();
        return anos;
    }
}
