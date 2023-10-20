/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author estefania
 */
public class EmpleadosDTO {
    
    int ID;
    int superUsuarioID;
    String direccion;
    String cargo;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSuperUsuarioID() {
        return superUsuarioID;
    }

    public void setSuperUsuarioID(int superUsuarioID) {
        this.superUsuarioID = superUsuarioID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
