package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.TransaccionType;
import logica.Wallet;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-08-24T10:47:47")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, Date> date;
    public static volatile SingularAttribute<Transaccion, Double> amount;
    public static volatile SingularAttribute<Transaccion, Wallet> wallet;
    public static volatile SingularAttribute<Transaccion, TransaccionType> type;
    public static volatile SingularAttribute<Transaccion, Integer> transactionId;

}