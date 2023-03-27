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

    public Placas(String numeroPlacas, Calendar FechaRecepcion, Automovil Automovil, float Costo, Calendar fechaNacimiento, Persona persona) {
        super(Costo, fechaNacimiento, persona);
        this.numeroPlacas = numeroPlacas;
        this.FechaRecepcion = FechaRecepcion;
        this.Automovil = Automovil;
    }

    public Placas(String numeroPlacas, Calendar FechaRecepcion, float Costo, Calendar fechaNacimiento, Persona persona) {
        super(Costo, fechaNacimiento, persona);
        this.numeroPlacas = numeroPlacas;
        this.FechaRecepcion = FechaRecepcion;
    }
    
    
    
    @Column(name="Numero_Placas",nullable =  false)
    private String numeroPlacas;
    
    @Column(name="Fecha_Recepcion",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar FechaRecepcion;
   
    @OneToOne(mappedBy = "placas")
    private Automovil Automovil;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHistorial")
    private Historial historial;
    
    public String getNumeroPlacas() {
        return numeroPlacas;
    }

    public void setNumeroPlacas(String numeroPlacas) {
        this.numeroPlacas = numeroPlacas;
    }

    public Calendar getFechaRecepcion() {
        return FechaRecepcion;
    }

    public void setFechaRecepcion(Calendar FechaRecepcion) {
        this.FechaRecepcion = FechaRecepcion;
    }

    public Automovil getAutomovil() {
        return Automovil;
    }

    public void setAutomovil(Automovil Automovil) {
        this.Automovil = Automovil;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
    
    
    
}
