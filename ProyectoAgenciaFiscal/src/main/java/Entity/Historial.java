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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "Historial")
public class Historial implements Serializable {
    
    public Historial(){
        
    }

    public Historial(Calendar FechaInactividad, Automovil automovil) {
        this.FechaInactividad = FechaInactividad;
        this.automovil = automovil;
    }
   
    @Id
    @Column(name = "idHistorial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(name="FechaInactividad",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar FechaInactividad;
    
    @OneToMany(mappedBy = "historial")
    private List<Placas> placas = new ArrayList<>();
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idAutomovil", nullable = false)
    private Automovil automovil;
    
    
    
    public Calendar getFechaInactividad() {
        return FechaInactividad;
    }

    public void setFechaInactividad(Calendar FechaInactividad) {
        this.FechaInactividad = FechaInactividad;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
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
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Historial{" + "id=" + id + ", FechaInactividad=" + FechaInactividad + ", automovil=" + automovil + '}';
    }

    
}
