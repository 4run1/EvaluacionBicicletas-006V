import java.util.ArrayList;

public class GestorBicicletas {

    private ArrayList<Bicicleta> bicicletas;

    public GestorBicicletas() {
        bicicletas = new ArrayList<>();
    }

    // Registra una bicicleta en la colección
    public void registrarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
        System.out.println("Bicicleta incorporada correctamente.");
    }

    // Buscar bicicletas por año
    public ArrayList<Bicicleta> buscarPorCodigo(int año) {

        ArrayList<Bicicleta> resultados = new ArrayList<>();

        for (Bicicleta bicicleta : bicicletas) {

            if (bicicleta.getAñoFabricacion() == año) {
                resultados.add(bicicleta);
            }
        }

        return resultados;
    }

    // SOBRECARGA: buscar bicicletas por código
    public ArrayList<Bicicleta> buscarPorCodigo(String codigo) {

        ArrayList<Bicicleta> resultados = new ArrayList<>();

        for (Bicicleta bicicleta : bicicletas) {

            if (bicicleta.getCodigo().equalsIgnoreCase(codigo)) {
                resultados.add(bicicleta);
            }
        }

        return resultados;
    }

    // Lista todas las bicicletas registradas
    public void listarBicicletas() {

        for (Bicicleta bicicleta : bicicletas) {

            System.out.println(bicicleta);

            System.out.println(
                    "Costo mantención: $"
                            + bicicleta.calcularCostoMantencion()
            );
        }
    }
}