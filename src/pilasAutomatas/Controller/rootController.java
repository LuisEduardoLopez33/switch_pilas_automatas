package pilasAutomatas.Controller;

import pilasAutomatas.Model.modelreten;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class rootController {

    ObservableList<String> entrad = FXCollections.observableArrayList();

    @FXML
    TextArea entrada;

// boton de inicio
    public void datoEntrada(){
        entrad.clear();
        String dats = entrada.getText();

        String[] sa = dats.split(" ");

        //guardando al array
        for (int i = sa.length-1; i>=0; i--){
            entrad.add(sa[i]);
        }

        modelreten envia = new modelreten();

        if (entrada.getLength() != 0){
            boolean dt = envia.recibendoDato(entrad);
            if (dt){
                System.out.println("Cadena Aceptada");
            }else {
                System.out.println("Cadena No Aceptada");
            }
        }else {
            System.out.println("El campo no puede estar vacio");
        }


    }

}
