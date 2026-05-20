package ec.edu.poo;

public class GestorActivos {

    public final int MAX_ACTIVOS = 10;

    private ActivoDigital[] activos;
    private int contador;

    public GestorActivos() {
        activos = new ActivoDigital[MAX_ACTIVOS];
        contador = 0;
    }

    public void reiniciar() {
        activos = new ActivoDigital[MAX_ACTIVOS];
        contador = 0;
    }

    public boolean registrarActivo(ActivoDigital activo) {
        if (contador >= MAX_ACTIVOS) return false;
        if (buscarPorCodigo(activo.getCodigo()) != null) return false;

        activos[contador] = activo;
        contador++;
        return true;
    }

    public ActivoDigital buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (activos[i].getCodigo().equals(codigo)) {
                return activos[i];
            }
        }
        return null;
    }

    public int contarActivosCriticos() {
        int criticos = 0;
        for (int i = 0; i < contador; i++) {
            if (activos[i].getNivelRiesgo() >= 8) {
                criticos++;
            }
        }
        return criticos;
    }

    public double calcularPromedioRiesgo() {
        if (contador == 0) return 0;

        int suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += activos[i].getNivelRiesgo();
        }
        return (double) suma / contador;
    }

    public boolean aplicarParcheActivo(String codigo) {
        ActivoDigital activo = buscarPorCodigo(codigo);
        if (activo == null) return false;

        activo.setParcheAplicado(true);
        return true;
    }

    public int obtenerCantidadActivos() {
        return contador;
    }

    public ActivoDigital[] obtenerActivos() {
        return activos;
    }
}