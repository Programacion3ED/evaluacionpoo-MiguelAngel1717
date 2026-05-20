package ec.edu.poo;

public class Main {

    public static void main(String[] args) {

        GestorActivos gestor = new GestorActivos();

        gestor.registrarActivo(new Servidor("SRV-001", "Servidor Web", 9, false, "Ubuntu 22.04"));
        gestor.registrarActivo(new Servidor("SRV-002", "Servidor BD", 7, true, "Windows Server 2022"));
        gestor.registrarActivo(new Firewall("FW-001", "Firewall Principal", 8, false, 150));
        gestor.registrarActivo(new Firewall("FW-002", "Firewall Secundario", 5, true, 80));
        gestor.registrarActivo(new ActivoDigital("ACT-001", "Switch Core", 3, false));

        System.out.println("Activos registrados: " + gestor.obtenerCantidadActivos());
        System.out.println("Duplicado: " + gestor.registrarActivo(new ActivoDigital("SRV-001", "Dup", 1, false)));
        System.out.println("Críticos: " + gestor.contarActivosCriticos());
        System.out.printf("Promedio riesgo: %.2f%n", gestor.calcularPromedioRiesgo());
        System.out.println("Parche SRV-001: " + gestor.aplicarParcheActivo("SRV-001"));
        System.out.println("Buscar FW-001: " + gestor.buscarPorCodigo("FW-001").getNombre());

        System.out.println();

        for (int i = 0; i < gestor.obtenerCantidadActivos(); i++) {
            ActivoDigital a = gestor.obtenerActivos()[i];
            System.out.println(a.getCodigo() + ", " + a.getNombre() + ", riesgo " + a.getNivelRiesgo() + ", parche " + a.isParcheAplicado());
        }

        gestor.reiniciar();
        System.out.println("\nTras reiniciar: " + gestor.obtenerCantidadActivos() + " activos");
    }
}