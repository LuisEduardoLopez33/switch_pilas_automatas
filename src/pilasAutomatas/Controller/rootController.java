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
        String dats = entrada.getText();

        String[] sa = dats.split(" ");

        //guardando al array
        for (int i = sa.length-1; i>=0; i--){
            //String m = sa[i].substring(0);
            //System.out.println(m+ " aqui mero");
            entrad.add(sa[i]);
        }

        //imprimiendo el array
//        for (int l = 0; l < entrad.size(); l++){
//            System.out.println(entrad.get(l));
//        }

        modelreten envia = new modelreten();

        envia.recibendoDato(entrad);
    }


    public void eliminarUltimoLista(){

    }


}
