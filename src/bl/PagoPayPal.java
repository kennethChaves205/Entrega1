package bl;

// bl.Pago con PayPal
public class PagoPayPal implements Pago {
    private String email;

    public PagoPayPal(String correo) {
        email = correo;
    }

    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal: " + email + " | Monto: $" + monto);
        return true;
    }
}
