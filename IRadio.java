public interface IRadio {
    void saveStation(int buttonId, double station);
    boolean isAm();
    boolean isOn();
    double selectStation(int buttonId);
    void switchOnOff();
    void switchAMFM();
    double nextStation();
}
