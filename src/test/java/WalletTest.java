
import java.util.ArrayList;
import org.junit.Test;
import logica.Transaccion;
import logica.Wallet;
import logica.WalletType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


public class WalletTest {
    
    private Wallet walletEfectivo;
    private Wallet walletBanco;
    private Wallet walletMP;
    private Transaccion transaccionEfectivo;

    public void setUp() {
        walletEfectivo = new Wallet(1, WalletType.EFECTIVO,0);
        walletBanco = new Wallet(2, WalletType.BANCO,0);
        walletMP = new Wallet(3, WalletType.MERCADOPAGO,0);
        walletEfectivo.setListaTransaciones(new ArrayList<>());
        transaccionEfectivo = new Transaccion();
    }

    @Test
    public void despositarEnTipoWalletEfectivoCincuentaDevuelveCincuenta() {
        setUp();
        walletEfectivo.depositar(50.0);
        double valorEsperado = 50.0;
        assertEquals(valorEsperado, walletEfectivo.getBalance(), 0.0001);
    }
    
    @Test
    public void despositarEnTipoWalletBancoOchocientosDevuelveOchocientos() {
        setUp();
        walletBanco.depositar(800.0);
        double valorEsperado = 800.0;
        assertEquals(valorEsperado, walletBanco.getBalance(), 0.0001);
    }
    
    @Test
    public void despositarEnTipoWalletMPSeisMilDevuelveSeisMil() {
        setUp();
        walletMP.depositar(6000.0);
        double valorEsperado = 6000.0;
        assertEquals(valorEsperado, walletMP.getBalance(), 0.0001);
    }
    
    @Test
    public void retirarEnTipoWalletEfectivoDiezQuedaEnTotalCuarenta(){
        setUp();
        walletEfectivo.depositar(50.0);
        walletEfectivo.retirar(10);
        double valorEsperado = 40.0;
        assertEquals(valorEsperado, walletEfectivo.getBalance(), 0.0001);
    }
    
    @Test
    public void retirarEnTipoWalletBancoDoscientosQuedaEnTotalSeiscientos(){
        setUp();
        walletBanco.depositar(800.0);
        walletBanco.retirar(200.0);
        double valorEsperado = 600.0;
        assertEquals(valorEsperado, walletBanco.getBalance(), 0.0001);
    }
    
    @Test
    public void retirarEnTipoWalletMPDosMilQuedaEnTotalCuatroMil(){
        setUp();
        walletMP.depositar(6000.0);
        walletMP.retirar(2000.0);
        double valorEsperado = 4000.0;
        assertEquals(valorEsperado, walletMP.getBalance(), 0.0001);
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void retirarCienExceptionSaldoInsuficienteDeWalletMPElSaldoEsCero() {
        setUp();
        try {
            walletMP.retirar(100.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente para esta operación.", e.getMessage());
            throw e; 
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void retirarSeIngresaUnMontoNegativoYLanzaException() {
        setUp();
        try {
            walletMP.retirar(-100.0);
        } catch (IllegalArgumentException e) {
            assertEquals("La cantidad a retirar debe ser positiva.", e.getMessage());
            throw e; 
        }
    }
    

}
