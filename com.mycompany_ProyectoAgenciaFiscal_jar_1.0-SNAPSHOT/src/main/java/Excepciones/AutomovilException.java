/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author diego
 */
public class AutomovilException extends Exception {
    
    public AutomovilException(String message) {
        super(message);
    }
    public AutomovilException(String message, Throwable cause) {
        super(message, cause);
    }
}
