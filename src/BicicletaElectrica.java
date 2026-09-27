public class BicicletaElectrica extends Bicicleta
        implements ConGarantiaExtendida {

    private int autonomia;
    private boolean bateriaCertificada;
    private boolean garantiaExtendida;

    public BicicletaElectrica(String codigo, int añoFabricacion,
                              double peso, int autonomia,
                              boolean bateriaCertificada) {

        super(codigo, añoFabricacion, peso);
        setAutonomia(autonomia);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendida = false;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public double calcularCostoMantencion() {

        double costo = 45000;

        if (!bateriaCertificada) {
            costo = costo * 1.25;
        }

        return costo;
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendida;
    }

    @Override
    public void activarGarantiaExtendida() {
        garantiaExtendida = true;
    }
}