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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "Tramite")
@DiscriminatorColumn(name="Tipo",length = 30)
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {
    public Tramite(){
        
    }

    public Tramite(float Costo, Persona persona) {
        this.Costo = Costo;
        this.persona = persona;
        this.fechaTramite = Calendar.getInstance();
    }
    
    
    @Id
    @Column(name = "idTramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "Costo")
    private float Costo;
    
    @Column(name="Fecha_Tramite",nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaTramite;
    
    @ManyToOne()
    @JoinColumn(name="idPersona", nullable = false)
    private Persona persona;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Tramite[ id=" + id + " ]";
    }
    
}
