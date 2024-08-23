package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Transaccion;
import logica.Usuario;
import logica.Wallet;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    TransaccionJpaController transJPA = new TransaccionJpaController();
    UsuarioJpaController usJPA = new UsuarioJpaController();
    WalletJpaController walletJPA = new WalletJpaController();

    public void crearUsuario(Usuario us) {
        usJPA.create(us);
    }

    public void crearTransaccion(Transaccion trans) {
        transJPA.create(trans);
        
    }

    public void crearWallet(Wallet wallet) {
        walletJPA.create(wallet);
    }

    public List<Usuario> getUsuarios() {
        return usJPA.findUsuarioEntities();
    }
    
    public List<Transaccion> getTransacciones() {
        return transJPA.findTransaccionEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarTransaccion(int id) {
        try {
            transJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario traerUsuario(int id) {
        return usJPA.findUsuario(id);
    }
    
    public Wallet traerWallet(int id) {
        return walletJPA.findWallet(id);
    }
    
    public Transaccion traerTransaccion(int id) {
        return transJPA.findTransaccion(id);
    }
    
    public void editarUsuario(Usuario us) {
        try {
            usJPA.edit(us);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarTransaccion(Transaccion trans) {
        try {
            transJPA.edit(trans);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarWallet(Wallet wa) {
        try {
            walletJPA.edit(wa);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
