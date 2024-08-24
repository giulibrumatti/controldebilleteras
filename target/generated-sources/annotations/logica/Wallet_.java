package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Transaccion;
import logica.WalletType;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-08-24T10:47:47")
@StaticMetamodel(Wallet.class)
public class Wallet_ { 

    public static volatile ListAttribute<Wallet, Transaccion> listaTransaciones;
    public static volatile SingularAttribute<Wallet, Double> balance;
    public static volatile SingularAttribute<Wallet, WalletType> walletType;
    public static volatile SingularAttribute<Wallet, Integer> id;

}