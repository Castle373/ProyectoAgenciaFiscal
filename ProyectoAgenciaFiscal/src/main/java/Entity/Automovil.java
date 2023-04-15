/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "Automovil")
public class Automovil implements Serializable {

    public Automovil(){
        
    }



    public Automovil(String modelo, String marca, String linea, String color, String NumeroDeSerie, Persona persona) {
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.NumeroDeSerie = NumeroDeSerie;
        this.persona = persona;
        placas = new ArrayList<Placas>();
    }

    
    @Id
    @Column(name = "idAutomovil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Linea")
    private String linea;
    @Column(name = "Color")
    private String color;
    @Column(name = "NumeroDeSerie")
    private String NumeroDeSerie;
    
     @OneToMany(mappedBy = "automovil")
     private List<Placas> placas;
     
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    public List<Placas> getPlacas() {
    return placas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
  
  public void setPlacas(List<Placas> placas) {
    this.placas = placas;
  }
  public void agregaPlaca(Placas placas) {
    this.placas.add(placas);
  }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumeroDeSerie() {
        return NumeroDeSerie;
    }

    public void setNumeroDeSerie(String NumeroDeSerie) {
        this.NumeroDeSerie = NumeroDeSerie;
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
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Automovil[ id=" + id + " ]";
    }
    
}
