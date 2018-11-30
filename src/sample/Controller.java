package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public RadioButton redovanPolje;
    public RadioButton samofinancirajuciPolje;
    public CheckBox borackaPolje;
    public Button prijavaBtn;
    public boolean[] greska={false,false,false,false,false,false,false,false};

    @FXML
    public void initialize(){

        imePolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if( ispravnostImena(n)) {
                    greska[0]=false;
                    imePolje.getStyleClass().removeAll("poljeNijeIspravno");
                    imePolje.getStyleClass().add("poljeIspravno");
                }
                else if( !(ispravnostImena(n))) {
                    greska[0]=true;
                    imePolje.getStyleClass().removeAll("poljeIspravno");
                    imePolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        prezimePolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if( ispravnostPrezimena(n)) {
                    greska[1]=false;
                    prezimePolje.getStyleClass().removeAll("poljeNijeIspravno");
                    prezimePolje.getStyleClass().add("poljeIspravno");
                }
                else if( !(ispravnostPrezimena(n))) {
                    greska[1]=true;
                    prezimePolje.getStyleClass().removeAll("poljeIspravno");
                    prezimePolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        indexPolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if( ispravnostIndexa(n)) {
                    greska[2]=false;
                    indexPolje.getStyleClass().removeAll("poljeNijeIspravno");
                    indexPolje.getStyleClass().add("poljeIspravno");
                }
                else if( !(ispravnostIndexa(n))) {
                    greska[2]=true;
                    indexPolje.getStyleClass().removeAll("poljeIspravno");
                    indexPolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        jmbgPolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if( ispravnostJMBG(n)) {
                    greska[3]=false;
                    jmbgPolje.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbgPolje.getStyleClass().add("poljeIspravno");
                }
                else if( !(ispravnostJMBG(n))) {
                    greska[3]=true;
                    jmbgPolje.getStyleClass().removeAll("poljeIspravno");
                    jmbgPolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        datumrodjPolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if( ispravnostDatuma(n)) {
                    greska[4]=false;
                    datumrodjPolje.getStyleClass().removeAll("poljeNijeIspravno");
                    datumrodjPolje.getStyleClass().add("poljeIspravno");
                }
                else if( !(ispravnostDatuma(n))) {
                    greska[4]=true;
                    datumrodjPolje.getStyleClass().removeAll("poljeIspravno");
                    datumrodjPolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        kontakttelefonPolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.length()==0) {
                    kontakttelefonPolje.getStyleClass().removeAll("poljeIspravno","poljeNijeIspravno");
                    kontakttelefonPolje.getStyleClass().add("poljeNeutralno");
                }
                if (ispravnostTelefona(n)) {
                    greska[5]=false;
                    kontakttelefonPolje.getStyleClass().removeAll("poljeNijeIspravno","poljeNeutralno");
                    kontakttelefonPolje.getStyleClass().add("poljeIspravno");
                }
                else if (!(ispravnostTelefona(n))) {
                    greska[5]=true;
                    kontakttelefonPolje.getStyleClass().removeAll("poljeIspravno","poljeNeutralno");
                    kontakttelefonPolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        kontaktadresaPolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.length()==0) {
                    kontaktadresaPolje.getStyleClass().removeAll("poljeIspravno","poljeNijeIspravno");
                    kontaktadresaPolje.getStyleClass().add("poljeNeutralno");
                }
                else {
                    kontaktadresaPolje.getStyleClass().removeAll("poljeNijeIspravno","poljeNeutralno");
                    kontaktadresaPolje.getStyleClass().add("poljeIspravno");
                }
            }
        });

        mjestorodjPolje.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (ispravnotstMjestaRodjenja(n)) {
                    greska[6]=false;
                    mjestorodjPolje.getStyleClass().removeAll("poljeNijeIspravno");
                    mjestorodjPolje.getStyleClass().add("poljeIspravno");
                }
                else if (!(ispravnotstMjestaRodjenja(n))) {
                    greska[6]=true;
                    mjestorodjPolje.getStyleClass().removeAll("poljeIspravno");
                    mjestorodjPolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        emailPolje.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if( ispravnostEmaila(n)) {
                    greska[7]=false;
                    emailPolje.getStyleClass().removeAll("poljeNijeIspravno");
                    emailPolje.getStyleClass().add("poljeIspravno");
                }
                else if( !(ispravnostEmaila(n))) {
                    greska[7]=true;
                    emailPolje.getStyleClass().removeAll("poljeIspravno");
                    emailPolje.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        ToggleGroup pritsnutJedanGrupa = new ToggleGroup();
        redovanPolje.setToggleGroup( pritsnutJedanGrupa );
        samofinancirajuciPolje.setToggleGroup( pritsnutJedanGrupa );
    }


    private boolean ispravnotstMjestaRodjenja(String s) {
        if( s.length() > 20 ) return false;
        if( s.length() < 2 ) return false;
        if( s.charAt(0) < 'A' || s.charAt(0) > 'Z' ) return false;
        for ( int i = 1; i < s.length(); i++ ){
            if( !( daLiJeSlovo( s.charAt(i) ) ) && s.charAt(i) != ' ' ) return false;
            if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' && s.charAt(i-1) != ' ' ) return false;
        }
        return true;
    }

    private boolean daLiJeSlovo( char c ) {
        if( c >= 'A' && c <= 'Z' ) return true;
        if( c >= 'a' && c <= 'z' ) return true;
        return false;
    }

    private boolean daLiJeBroj( char c ){
        return ( c >= '0' && c <= '9' );
    }

    private boolean ispravnostIndexa( String s ){
        if( s.length() != 5 ) return false;
        for( int i = 0; i < s.length(); i++ )
            if( !(daLiJeBroj( s.charAt(i) )) ) return false;
        return true;
    }

    private boolean ispravnostImena( String s ){
        if( s.length() > 20 ) return false;
        if( s.length() < 2 ) return false;
        if( s.charAt(0) < 'A' || s.charAt(0) > 'Z' ) return false;
        for ( int i = 1; i < s.length(); i++ ){
            if( !( daLiJeSlovo( s.charAt(i) ) ) ) return false;
            if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ) return false;
        }
        return true;
    }


    private boolean ispravnostPrezimena( String s ){
        return ispravnostImena( s );
    }

    private boolean ispravnostJMBG( String s ){
        if( s.length() != 13 ) return false;
        for( int i = 0; i < 13; i++ )
            if( !( daLiJeBroj( s.charAt(i) ) ) ) return false;
        return true;
    }

    private boolean ispravnostEmaila( String s ){
        if( s.length() != 0 && s.charAt(0) == '@') return false;
        if( s.length() < 5 ) return false;
        int i = 0;
        while( s.charAt(i) != '@' ){
            if( i == s.length() - 1 ) return false;
            if( !( daLiJeSlovo(s.charAt(i)) ) && !( daLiJeBroj(s.charAt(i)) ) && s.charAt(i) != '_' ) return false;
            i++;
        }
        i++;
        if( i == s.length() ) return false;
        if( s.charAt(i) == '.' ) return false;
        while( s.charAt(i) != '.' ){
            if( i == s.length() - 1 ) return false;
            if( !( daLiJeSlovo(s.charAt(i)) ) && !( daLiJeBroj(s.charAt(i)) ) ) return false;
            i++;
        }
        i++;
        if( i == s.length() ) return false;
        while( i != s.length() ){
            if(!( daLiJeSlovo(s.charAt(i)) ) ) return false;
            i++;
        }
        return true;
    }

    private boolean ispravnostTelefona( String s ){
        if( s.length() == 12 ){
            for( int i = 0; i < 12; i++ ) {
                if (i == 3 && s.charAt(i) != '-') return false;
                else if (i == 7 && s.charAt(i) != '-') return false;
                else if ( i != 3 && i != 7 && !(daLiJeBroj(s.charAt(i)))) return false;
            }
            return true;
        }
        if( s.length() == 11){
            for( int i = 0; i < 11; i++ ) {
                if (i == 3 && s.charAt(i) != '-') return false;
                else if (i == 7 && s.charAt(i) != '-') return false;
                else if ( i != 3 && i != 7 && !(daLiJeBroj(s.charAt(i)))) return false;
            }
            return true;
        }
        else return false;
    }
    private boolean ispravnostDatuma( String s ){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date danasnjiDatum = new Date();
        if( s.length() != 10 || s.charAt(2) != '/' || s.charAt(5) != '/' ) return false;
        for( int i = 0; i < 10; i++ ) {
            if( i == 2 || i == 5 ) continue;
            if( !( daLiJeBroj( s.charAt(i) ) ) ) return false;
        }
        int godina = Integer.parseInt( s.substring(7,10) );
        int mjesec = Integer.parseInt( s.substring(3,5) );
        int dan = Integer.parseInt( s.substring(0,2) );
        if( mjesec < 1 || mjesec > 12 ) return false;
        if( mjesec <= 7 ){
            if( mjesec % 2 == 1 && ( dan < 1 || dan > 31 ) ) return false;
            else if( mjesec % 2 == 0 && ( dan < 1 || dan > 30 ) ) return false;
        }
        else{
            if( mjesec % 2 == 0 && ( dan < 1 || dan > 31 ) ) return false;
            if( mjesec % 2 == 1 && ( dan < 1 || dan > 30 ) ) return false;
        }
        Date ovajDatum = new Date( Date.parse( s ) );
        if( ovajDatum.compareTo( danasnjiDatum ) > 0 ) return false;
        int danIzJMBG = Integer.parseInt( jmbgPolje.getText( 0, 2 ) );
        int mjesecIzJMBG = Integer.parseInt( jmbgPolje.getText( 2, 4 ) );
        int godinaIzJMBG = Integer.parseInt( jmbgPolje.getText( 4, 7 ) );
        if( danIzJMBG != dan || mjesecIzJMBG != mjesec || godinaIzJMBG != godina ) return false;
        return true;
    }

    public void prijavaClick(ActionEvent actionEvent) throws Exception {

        for (int i=0;i<8; i++)
        if (greska[i]==true) {
            Stage secondaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("greska.fxml"));
            secondaryStage.setTitle("Greska");
            secondaryStage.setResizable(false);
            secondaryStage.setScene(new Scene(root, 200, 100));
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.show();
            return;
        }

        System.out.println("Ime: " + imePolje.getText());
        System.out.println("Prezime: " + prezimePolje.getText());
        System.out.println("Broj indexa: " + indexPolje.getText());
        System.out.println("JMBG: " + jmbgPolje.getText());
        System.out.println("Datum rodjenja: " + datumrodjPolje.getText());
        System.out.println("Mjesto rodjenja: " + mjestorodjPolje.getValue());
        System.out.println("Kontakt adresa: " + kontaktadresaPolje.getText());
        System.out.println("Kontakt telefon: " + kontakttelefonPolje.getText());
        System.out.println("E-mail adresa: " + emailPolje.getText());
        System.out.println("Odsjek: " + odsjekPolje.getValue());
        System.out.println("Godina studija: " + godinastudijaPolje.getValue());
        System.out.println("Ciklus studija: " + ciklusPolje.getValue());
        if (redovanPolje.isSelected())
        System.out.println("Redovan: " + redovanPolje.getText());
        else if (samofinancirajuciPolje.isSelected())
            System.out.println("Samofinancirajuci: " + samofinancirajuciPolje.getText());
        if (borackaPolje.isSelected())
            System.out.println("Student pripada posebnoj borackoj kategoriji.");
        else System.out.println("Student ne pripada posebnoj borackoj kategoriji.");
    }



}
