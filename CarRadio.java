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
      
    /**
     * Indica si el radio está actualmente en modo AM.
     * true si el radio está en modo AM, false si está en modo FM.
     */

    @Override
    public boolean isAm() {
         return isAm;
    }

    /**
      * Indica si el radio está encendido o apagado.
      * true si el radio está encendido, false si está apagado.
      */
 
    @Override
    public boolean isOn() {
         return isOn;
    }

    /**
      * Selecciona y devuelve la estación guardada en uno de los botones preestablecidos.
      * El identificador del botón cuya estación se quiere seleccionar (debe estar entre 1 y 12).
      * La frecuencia de la estación guardada en el botón especificado, o 0.0 si el número de botón es inválido.
      */
 
    @Override
    public double selectStation(int buttonId) {
        if (buttonId < 1 || buttonId > 12) {
            System.out.println("Número de botón inválido.");
            return 0.0;
        }
        int index = buttonId - 1; 
        return isAm ? amPresets[index] : fmPresets[index];
    }
  
    /**
       * Alterna el estado de encendido del radio.
       * Enciende el radio si está apagado, y viceversa.
       */
  
    @Override
    public void switchOnOff() {
        isOn = !isOn;
        if (isOn) {
            System.out.println("Radio encendido.");
        } else {
            System.out.println("Radio apagado.");
        }
    }
  
    /**
    * Cambia entre los modos AM y FM del radio.
    * Si el radio está apagado, muestra un mensaje y no realiza el cambio.
    */
    @Override
    public void switchAMFM() {
        if (!isOn) {
            System.out.println("El radio está apagado. Por favor, enciéndalo primero.");
            return;
        }
  
        isAm = !isAm; // Cambia entre AM y FM
  
        // Restablece la estación al valor predeterminado para AM o FM
        if (isAm) {
            System.out.println("Cambiado a AM.");
            currentStation = 530; // Establece la estación a la frecuencia inicial de AM
        } else {
            System.out.println("Cambiado a FM.");
            currentStation = 87.9; // Establece la estación a la frecuencia inicial de FM
        }
    }
  
    /**
    * Avanza a la siguiente estación y actualiza la estación actual del radio.
    * Si el radio está en AM, avanza en incrementos de 10. En FM, avanza en incrementos de 0.2.
    * Si se alcanza el final del rango, reinicia al inicio del rango correspondiente.
    * La nueva estación actual después de avanzar.
    */
      
    @Override
    public double nextStation() {
        if (!isOn) {
            System.out.println("El radio está apagado. Por favor, enciéndalo primero.");
            return 0.0;
        }
  
        if (isAm) {
            currentStation += 10;
            if (currentStation > 1610) {
                currentStation = 530; // Reinicia al inicio del rango AM
            }
        } else {
            currentStation += 0.2;
            if (currentStation > 107.9) {
                currentStation = 87.9; // Reinicia al inicio del rango FM
            }
        }
  
        return currentStation;
    }
 
}