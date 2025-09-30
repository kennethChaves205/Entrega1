class Usuario {
    private double id;
    private String nombre;
    private String email;

    public Usuario(double idUsuario, String nombreUsuario, String emailUsuario) {
        id = idUsuario;
        nombre = nombreUsuario;
        email = emailUsuario;
    }

    // Getters y Setters
    public double obtenerId() { return id; }
    public String obtenerNombre() { return nombre; }
    public String obtenerEmail() { return email; }

    public void cambiarEmail(String nuevoEmail) { email = nuevoEmail; }
}

// Encapsulamiento: Los atributos (id, nombre, email) son privados y solo se acceden o modifican mediante métodos públicos, garantizando seguridad y control de los datos.
//Agregación: La clase Usuario se asocia con Pedido, pero puede existir de manera independiente al pedido