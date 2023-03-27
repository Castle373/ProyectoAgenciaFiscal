/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
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
    public Persona(String nombreCompleto, String rfc, String telefono, Calendar fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    
    @Id
    @Column(name = "idPersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre_Completo")
    private String nombreCompleto;
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name="FechaNacimiento",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
    private List<Tramite> tramite;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
