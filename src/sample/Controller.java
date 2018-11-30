package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {
    public GridPane glavniProzor;
    public GridPane leftupperProzor;
    public GridPane rightupperProzor;
    public GridPane rightlowerProzor;
    public GridPane leftlowerProzor;
    public TextField imePolje;
    public TextField prezimePolje;
    public TextField indexPolje;
    public TextField jmbgPolje;
    public TextField datumrodjPolje;
    public ComboBox mjestorodjPolje;
    public TextField kontaktadresaPolje;
    public TextField kontakttelefonPolje;
    public TextField emailPolje;
    public ChoiceBox odsjekPolje;
    public ChoiceBox godinastudijaPolje;
    public ChoiceBox ciklusPolje;

    public void prijavaClick(ActionEvent actionEvent) {
        System.out.println("Prijava uspjesna");
    }
}
