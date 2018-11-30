package sample;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

public class Controller {
    public GridPane glavniProzor;
    public GridPane leftupperProzor;
    public GridPane rightupperProzor;
    public GridPane rightlowerProzor;
    public GridPane leftlowerProzor;

    public void prijavaClick(ActionEvent actionEvent) {
        System.out.println("Prijava uspjesna");
    }
}
