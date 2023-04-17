/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author diego
 */
public class PlacaException extends Exception {

    public PlacaException(String message) {
        super(message);
    }

    public PlacaException(String message, Throwable cause) {
        super(message, cause);
    }
}