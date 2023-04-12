/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {
    public Persona(){
        
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String curp, String telefono, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.curp = curp;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        tramites = new ArrayList<Tramite>();
        automoviles = new ArrayList<Automovil>();
    }

   
    

    
    @Id
    @Column(name = "idPersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido_Paterno")
    private String apellidoPaterno;
    @Column(name = "Apellido_Materno")
    private String apellidoMaterno; 
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "Curp")
    private String curp;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name="FechaNacimiento",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<Tramite> tramites;

    @OneToMany(mappedBy = "persona",cascade = CascadeType.PERSIST)
     private List<Automovil> automoviles;
    
    public void agregarAuto(Automovil automovil) {
        this.automoviles.add(automovil);
    }
    public void agregarTramite(Tramite tramite) {
        this.tramites.add(tramite);
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Persona[ id=" + id + " ]";
    }
    
}
