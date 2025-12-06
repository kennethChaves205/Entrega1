package bl;

public class PagoTarjeta implements Pago {
    private String numeroTarjeta;

    public PagoTarjeta(String numero) {
        numeroTarjeta = numero;
    }

    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con Tarjeta: " + numeroTarjeta + " | Monto: $" + monto);
        return true;
    }
}

//Abstracción: Define un contrato general para todos los métodos de pago, sin especificar cómo se procesa cada tipo de pago.
//Dependencia: Pedido puede usar cualquier implementación de bl.Pago (tarjeta o PayPal), demostrando cómo un mismo método puede comportarse de forma distinta según la implementación.
//Encapsulamiento: Cada implementación mantiene sus atributos privados, accediéndose únicamente mediante sus métodos públicos.