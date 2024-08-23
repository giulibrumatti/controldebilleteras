package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private WalletType walletType;
    private double balance;
    @OneToMany(mappedBy = "wallet")
    private List<Transaccion> listaTransaciones;

    public Wallet(int id, WalletType walletType, double balance) {
        this.walletType = walletType;
        this.balance = balance;
        this.id = id;
    }

    public Wallet() {

    }

    public List<Transaccion> getListaTransaciones() {
        return listaTransaciones;
    }

    public void setListaTransaciones(List<Transaccion> listaTransaciones) {
        this.listaTransaciones = listaTransaciones;
    }
    
    public void agregarTransaccion(Transaccion trans){
        this.listaTransaciones.add(trans);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WalletType getType() {
        return walletType;
    }

    public void setType(WalletType type) {
        this.walletType = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositar(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva.");
        }
        this.balance += amount;
    }

    public void retirar(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva.");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Saldo insuficiente para esta operación.");
        }
        this.balance -= amount;
    }
}
