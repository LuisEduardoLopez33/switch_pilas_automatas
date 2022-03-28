package pilasAutomatas.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Stack;

public class modelreten {

    ObservableList<String> array = FXCollections.observableArrayList();
    String[] s = {"I","PA","V","PC","LA","C","LC"};
    boolean status = true;
    int aux = 0;

    Stack pila = new Stack();

    public ObservableList recibendoDato( ObservableList datos){

        if (pila.size() == 0){
            pila.push("S");
        }
        array = datos;

        do {
            String ultimoPila = (String) pila.get(pila.size()-1);
            //int i = array.size()-1;
            //System.out.println("este es "+i);
            if (ultimoPila.equals(array.get(array.size()-1))){
                pila.pop();
                array.remove(array.size()-1);
                System.out.println("ultimo " + ultimoPila);
            }else {
                aux++;
                if (pila.size() == 0){
                    status = false;
                }
                pushPila();
            }

            if (aux > 1){
                status = false;
            }
            //pushPila();

        }while(status == true);
        //pushPila();

        return array;
    }


    public void pushPila(){
        String tam = (String) pila.get(pila.size()-1);

        switch (tam){
            case "S":
                pila.pop();
                for (int i = s.length-1; i >= 0; i--){
                    pila.push(s[i]);
                }
                break;
            case "I":
                aux = 0;
                pila.pop();
                pila.push("switch");
                break;
            case "PA":
                aux = 0;
                pila.pop();
                pila.push("(");
                break;
            case "V":
                break;
            case "PC":
                aux = 0;
                pila.pop();
                pila.push(")");
                break;
            case "LA":
                pila.pop();
                pila.push("{");
                break;
            case "C":
                break;
            case "LC":
                break;
        }


        for (int l = pila.size()-1; l>=0; l--){
            System.out.println(pila.get(l));
        }

        // imprimiendo array
//        for (int i = 0; i< array.size(); i++){
//            System.out.println(array.get(i));
//        }
    }

    public void popPila(){

    }

}
