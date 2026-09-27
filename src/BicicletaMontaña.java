public class BicicletaMontaña extends Bicicleta {

    private int suspensiones;

    public BicicletaMontaña(String codigo, int añoFabricacion,
                            double peso, int suspensiones) {

        super(codigo, añoFabricacion, peso);
        setSuspensiones(suspensiones);
    }

    public int getSuspensiones() {
        return suspensiones;
    }

    public void setSuspensiones(int suspensiones) {
        this.suspensiones = suspensiones;
    }

    @Override
    public double calcularCostoMantencion() {

        double costo = 30000;

        if (suspensiones > 1) {
            costo = costo * 1.15;
        }

        return costo;
    }
}