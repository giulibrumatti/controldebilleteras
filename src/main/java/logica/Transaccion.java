package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private TransaccionType type;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Transaccion(int transactionId, double amount, Date date, TransaccionType type, Wallet wallet) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.wallet = wallet;
    }

    public Transaccion() {

    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransaccionType getType() {
        return type;
    }

    public void setType(TransaccionType type) {
        this.type = type;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public boolean esIngreso() {
        return TransaccionType.DEPOSITAR.equals(type);
    }

    public boolean esGasto() {
        return TransaccionType.RETIRAR.equals(type);
    }

    public void operar() {
        try {
            if (esIngreso()) {
                wallet.depositar(amount);
            } else {
                wallet.retirar(amount);
            }
        } catch (IllegalArgumentException e) {
            throw e; 
        }
    }

}
