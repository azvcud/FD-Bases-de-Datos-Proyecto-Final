/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aplicacion;

import java.awt.event.ActionListener;

/**
 * Clase que notifica a la clase Mediador Aplicación de los eventos en la vista actual.
 * @author amirz
 */
public interface Aplicacion {
    public abstract void notificar(Object aplicacion, String mensaje);
}
