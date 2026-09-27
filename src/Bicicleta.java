/*
 * Java utiliza programación orientada a objetos, donde los atributos
 * y comportamientos se organizan dentro de clases y objetos.
 *
 * A diferencia de una programación basada principalmente en funciones,
 * la POO organiza los datos y comportamientos dentro de objetos.
 *
 * Java utiliza tipado estático, por lo que las variables deben declararse
 * indicando su tipo, como int, double o String.
 *
 * Además, Java comprueba los tipos durante la compilación, lo que permite
 * detectar errores antes de ejecutar el programa.
 */

public abstract class Bicicleta {

    private String codigo;
    private int añoFabricacion;
    private double peso;

    public Bicicleta(String codigo, int añoFabricacion, double peso) {
        setCodigo(codigo);
        setAñoFabricacion(añoFabricacion);
        setPeso(peso);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo ni vacío.");
        }
        this.codigo = codigo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        if (añoFabricacion < 2000 || añoFabricacion > 2026) {
            throw new IllegalArgumentException("El año debe estar entre 2000 y 2026.");
        }
        this.añoFabricacion = añoFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.peso = peso;
    }

    public abstract double calcularCostoMantencion();

    @Override
    public String toString() {
        return "Código: " + codigo +
                " | Año: " + añoFabricacion;
    }
}