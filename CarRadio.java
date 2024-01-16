/**
 * Clase que representa un radio con funcionalidades para manejar estaciones AM y FM,
 * guardar estaciones preestablecidas, y navegar entre ellas.
 */

public class CarRadio implements IRadio {
    private boolean isOn;
    private boolean isAm;
    private double currentStation;
    private final double[] amPresets = new double[12];
    private final double[] fmPresets = new double[12];
    
    public double getCurrentStation() {
        return currentStation;
    }

    /**
     * Constructor que inicializa el radio. Por defecto, el radio empieza apagado,
     * en modo AM y sintonizado en la estación inicial para AM.
     */

    public CarRadio() {
        isOn = false;
        isAm = true; 
        currentStation = isAm ? 530 : 87.9; 
    }

    /**
     * Guarda la estación de radio actual en uno de los botones preestablecidos.
     *  El identificador del botón donde se guardará la estación (debe estar entre 1 y 12).
     *  La frecuencia de la estación de radio a guardar.
     */

    @Override
    public void saveStation(int buttonId, double station) {
        if (buttonId < 1 || buttonId > 12) {
            System.out.println("Número de botón inválido.");
            return;
        }
        int index = buttonId - 1; 
        if (isAm) {
            amPresets[index] = station;
        } else {
            fmPresets[index] = station;
        }
    }
}