/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

public class BooleanWrapper {

    private boolean value;

    public BooleanWrapper(boolean value) {
        this.value = value;
    }

    // método que retorna o valor armazenado na variável 'value'
    public boolean get() {
        return value;
    }

    // método que define o valor armazenado na variável 'value'
    public void set(boolean value) {
        this.value = value;
    }
}
