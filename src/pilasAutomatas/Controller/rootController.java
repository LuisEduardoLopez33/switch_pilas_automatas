package pilasAutomatas.Controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import pilasAutomatas.Model.modelreten;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class rootController {

    ObservableList<String> entrad = FXCollections.observableArrayList();

    @FXML
    TextArea entrada;

    @FXML
    private Label status;

    @FXML
    private Pane paneTrue;

    @FXML
    private Pane paneFalse;

// boton de inicio
    public void datoEntrada(){
        entrad.clear();
        String dats = entrada.getText();
        paneTrue.setVisible(false);
        paneFalse.setVisible(false);
        status.setText(" ");
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
                status.setText("codigo correcto");
                paneTrue.setVisible(true);
            }else {
                System.out.println("Cadena No Aceptada");
                status.setText("codigo con errores");
                paneFalse.setVisible(true);
            }
        }else {
            System.out.println("El campo no puede estar vacio");
        }


    }

    @FXML
    void limpiarOn(MouseEvent event) {
        entrada.clear();
        status.setText(" ");
        paneTrue.setVisible(false);
        paneFalse.setVisible(false);
    }


}
