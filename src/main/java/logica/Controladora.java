package logica;

import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(int id, String nombreUs, String pass) {
        Usuario us = new Usuario(id, nombreUs, pass);
        controlPersis.crearUsuario(us);
    }
    
    public void crearTransaccion(int id, int monto, Date fecha, TransaccionType tipoTrans, Wallet wall) {
        Transaccion trans = new Transaccion(id, monto, fecha, tipoTrans, wall);
        controlPersis.editarWallet(wall);
        controlPersis.crearTransaccion(trans);
    }
   
    public List<Usuario> getUsuarios() {
        return controlPersis.getUsuarios();
    }
    
    public List<Transaccion> getTransacciones() {
        return controlPersis.getTransacciones();
    }
    
    public void borrarUsuario(int id){
        controlPersis.borrarUsuario(id);
    }
    public void borrarTransaccion(int id){
        controlPersis.borrarTransaccion(id);
    }
    
    public void editarUsuario(Usuario us) {
        controlPersis.editarUsuario(us);
    }
    
    public void editarTransaccion(Transaccion trans) {
        controlPersis.editarTransaccion(trans);
    }
    
    public void editarWallet(Wallet wa) {
        controlPersis.editarWallet(wa);
    }
    
    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }
    
    public Transaccion traerTransaccion(int id) {
        return controlPersis.traerTransaccion(id);
    }
    
    public Wallet traerWallet(int id) {
        return controlPersis.traerWallet(id);
    }
}
