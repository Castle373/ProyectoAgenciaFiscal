package Persistencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Entity.Persona;
import Entity.Placas;
import Entity.Tramite;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encriptacion {

    /**
     * Metodo Constructor Vacio de la Clase Encriptacion
     */
    public Encriptacion() {

    }
    /**
     * Declaracion de Variables de la Clase encriptacion
     */
    private static final String ALGORITMO = "AES";
    private static final String MODO = "ECB";
    private static final String PADDING = "PKCS5Padding";
    private static final String CLAVE_SECRETA = "AgenciaFiscal123";

    /**
     * Metodo que encripta un nombre
     *
     * @param texto texto
     * @return null o el nombre encriptado dependiendo del caso
     */
    public String encriptar(String texto) {
        try {
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), ALGORITMO);
            Cipher cipher = Cipher.getInstance(ALGORITMO + "/" + MODO + "/" + PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            byte[] textoEncriptado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo para desencriptar el nombre
     *
     * @param textoEncriptado textoEncript
     * @return null o el nombre desencriptada dependiendo del caso
     */
    public String desencriptar(String textoEncriptado) {
        try {
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), ALGORITMO);
            Cipher cipher = Cipher.getInstance(ALGORITMO + "/" + MODO + "/" + PADDING);
            cipher.init(Cipher.DECRYPT_MODE, clave);
            byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
            return new String(textoDesencriptado, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Método para desencriptar una lista de persona, desencripta el nombre completo. 
     * @param lista lista de persona.
     * @return la lista desencriptada.
     */
    public List<Persona> desencriptarLista(List<Persona> lista) {
        List<Persona> lista_desencriptada = new ArrayList();

        for (Persona persona : lista) {

            persona.setNombre(this.desencriptar(persona.getNombre()));
            persona.setApellidoPaterno(this.desencriptar(persona.getApellidoPaterno()));
            persona.setApellidoMaterno(this.desencriptar(persona.getApellidoMaterno()));
            lista_desencriptada.add(persona);

        }
        return lista;
    }

    /**
     * Método para desencriptar una lista de tramite, desencripta el nombre completo
     * de la persona en cuestión del tramite.. 
     * @param lista lista de tramite.
     * @return la lista desencriptada.
     */
    public List<Tramite> desencriptarListaTramite(List<Tramite> lista) {
        List<Persona> personasDesencriptadas = new ArrayList<>(); // crea una lista auxiliar de personas
        List<Tramite> lista_tramitePersona = new ArrayList<>(); // crea una lista de trámites

        for (Tramite tramite : lista) {
            Persona persona = tramite.getPersona(); // obtiene la persona del trámite

            if (!personasDesencriptadas.contains(persona)) { // si la persona no está en la lista auxiliar
                personasDesencriptadas.add(persona); // agrega la persona a la lista auxiliar
                persona.setNombre(this.desencriptar(persona.getNombre()));
                persona.setApellidoPaterno(this.desencriptar(persona.getApellidoPaterno()));
                persona.setApellidoMaterno(this.desencriptar(persona.getApellidoMaterno()));
            }
            lista_tramitePersona.add(tramite); // agrega el trámite a la lista
        }

        return lista_tramitePersona;
    }

    /**
     * Método para desencriptar una lista de placas, desencripta el nombre completo
     * de la persona en cuestión de la placa.. 
     * @param lista lista de placa.
     * @return la lista desencriptada.
     */
    public List<Placas> desencriptarListaPlacas(List<Placas> lista) {
        List<Persona> personasDesencriptadas = new ArrayList<>(); // crea una lista auxiliar de personas
        List<Placas> lista_placasPersona = new ArrayList<>(); // crea una lista de placas
        for (Placas placas : lista) {
            Persona persona = placas.getPersona(); // obtiene la persona de las placas

            if (!personasDesencriptadas.contains(persona)) { // si la persona no está en la lista auxiliar
                personasDesencriptadas.add(persona); // agrega la persona a la lista auxiliar
                persona.setNombre(this.desencriptar(persona.getNombre()));
                persona.setApellidoPaterno(this.desencriptar(persona.getApellidoPaterno()));
                persona.setApellidoMaterno(this.desencriptar(persona.getApellidoMaterno()));
            }
            lista_placasPersona.add(placas); // agrega las placas a la lista
        }

        return lista_placasPersona;
    }

//    }
}
