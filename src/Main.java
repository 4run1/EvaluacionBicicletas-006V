import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestorBicicletas gestor = new GestorBicicletas();

        // Crear bicicletas
        BicicletaElectrica e1 =
                new BicicletaElectrica(
                        "BIC-E01",
                        2023,
                        22.5,
                        60,
                        false
                );

        BicicletaElectrica e2 =
                new BicicletaElectrica(
                        "BIC-E02",
                        2022,
                        24.0,
                        45,
                        true
                );

        BicicletaMontaña m1 =
                new BicicletaMontaña(
                        "BIC-M01",
                        2021,
                        13.5,
                        2
                );

        BicicletaMontaña m2 =
                new BicicletaMontaña(
                        "BIC-M02",
                        2020,
                        12.0,
                        1
                );

        // Activar garantía extendida de BIC-E01
        e1.activarGarantiaExtendida();

        // Registrar bicicletas
        gestor.registrarBicicleta(e1);
        gestor.registrarBicicleta(e2);
        gestor.registrarBicicleta(m1);
        gestor.registrarBicicleta(m2);

        // Listar todas las bicicletas
        System.out.println("\n===== BICICLETAS REGISTRADAS =====");

        gestor.listarBicicletas();

        // Buscar bicicleta por código
        System.out.println("\n===== BUSCAR BICICLETA =====");

        boolean busquedaCorrecta = false;

        while (!busquedaCorrecta) {

            try {

                System.out.print("Ingrese el código de la bicicleta: ");
                String codigo = scanner.nextLine();

                if (codigo == null || codigo.trim().isEmpty()) {
                    throw new IllegalArgumentException(
                            "El código no puede estar vacío."
                    );
                }

                ArrayList<Bicicleta> resultados =
                        gestor.buscarPorCodigo(codigo);

                if (resultados.isEmpty()) {

                    System.out.println(
                            "No se encontró una bicicleta con ese código."
                    );

                    System.out.println(
                            "Intente nuevamente.\n"
                    );

                } else {

                    System.out.println("\nBicicleta encontrada:");

                    for (Bicicleta bicicleta : resultados) {
                        System.out.println(bicicleta);
                    }

                    busquedaCorrecta = true;
                }

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

                System.out.println(
                        "Intente nuevamente.\n"
                );
            }
        }

        // Ejemplo de utilización de la sobrecarga
        System.out.println("\n===== BUSCAR POR AÑO =====");

        boolean añoCorrecto = false;

        while (!añoCorrecto) {

            try {

                System.out.print("Ingrese año: ");
                int año = Integer.parseInt(scanner.nextLine());

                ArrayList<Bicicleta> resultados =
                        gestor.buscarPorCodigo(año);

                if (resultados.isEmpty()) {

                    System.out.println(
                            "No se encontró una bicicleta de ese año."
                    );

                    System.out.println(
                            "Intente nuevamente.\n"
                    );

                } else {

                    System.out.println("\nBicicleta(s) encontrada(s):");

                    for (Bicicleta bicicleta : resultados) {
                        System.out.println(bicicleta);
                    }

                    añoCorrecto = true;
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un año numérico."
                );

                System.out.println(
                        "Intente nuevamente.\n"
                );
            }
        }

        scanner.close();
    }
}