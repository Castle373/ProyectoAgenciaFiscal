/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "Placas")
@DiscriminatorValue(value="Placas")
@PrimaryKeyJoinColumn(name="idPlacas")
public class Placas extends Tramite implements Serializable {
    public Placas(){
        
    }

    public Placas(String numeroPlacas, String estado, Calendar fechaInactividad, Automovil automovil, float Costo, Calendar fechaNacimiento, Persona persona) {
        super(Costo, fechaNacimiento, persona);
        this.numeroPlacas = numeroPlacas;
        this.estado = estado;
        this.fechaInactividad = fechaInactividad;
        this.automovil = automovil;
    }

    public Placas(String numeroPlacas, String estado, Automovil automovil, float Costo, Calendar fechaNacimiento, Persona persona) {
        super(Costo, fechaNacimiento, persona);
        this.numeroPlacas = numeroPlacas;
        this.estado = estado;
        this.automovil = automovil;
    }
    
    @Column(name="Numero_Placas",nullable =  false)
    private String numeroPlacas;
    
    @Column(name="Estado",nullable =  false)
    private String estado;
    
    @Column(name="Fecha_Inactividad")
    @Temporal(TemporalType.DATE)
    private Calendar fechaInactividad;
   
    @ManyToOne
    @JoinColumn(name = "idAutomovil")
    private Automovil automovil;
    
    
    public String getNumeroPlacas() {
        return numeroPlacas;
    }

    public void setNumeroPlacas(String numeroPlacas) {
        this.numeroPlacas = numeroPlacas;
    }

    public Calendar getFechaRecepcion() {
        return fechaInactividad;
    }

    public void setFechaRecepcion(Calendar FechaRecepcion) {
        this.fechaInactividad = FechaRecepcion;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil Automovil) {
        this.automovil = Automovil;
    }

    
    
    
}
