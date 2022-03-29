package pilasAutomatas.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Stack;

public class modelreten {

    expreciones expr = new expreciones();
    ObservableList<String> array = FXCollections.observableArrayList();
    String[] s = {"I","PA","V","PC","LA","C","LC"};
    boolean status = true;
    int aux = 0;

    Stack pila = new Stack();

    public ObservableList recibendoDato( ObservableList datos){

        array = datos;
        if (pila.size() == 0){
            s();
        }

//        do {
//            String ultimoPila = (String) pila.get(pila.size()-1);
//            //int i = array.size()-1;
//            //System.out.println("este es "+i);
//            if (ultimoPila.equals(array.get(array.size()-1))){
//                pila.pop();
//                array.remove(array.size()-1);
//                System.out.println("ultimo " + ultimoPila);
//            }else {
//                aux++;
//                if (pila.size() == 0){
//                    status = false;
//                }
//                pushPila();
//            }
//
//            if (aux > 1){
//                status = false;
//            }
//            //pushPila();
//
//        }while(status == true);
//        //pushPila();

        return array;
    }


    public void pushPila(){
        String tam = (String) pila.get(pila.size()-1);


        for (int l = pila.size()-1; l>=0; l--){
            System.out.println(pila.get(l));
        }

        // imprimiendo array
//        for (int i = 0; i< array.size(); i++){
//            System.out.println(array.get(i));
//        }
    }

    public void s(){
        for (int i = s.length-1; i >= 0; i--){
            pila.push(s[i]);
        }
        i();
    }

    public void i(){
        System.out.println("entando al i pa :)");
        pila.pop();
        pila.push("switch");
        String ultimoPila = (String) pila.get(pila.size()-1);
        System.out.println("Ultimo en I "+ultimoPila);
//        // imprimiendo array
//        for (int i = 0; i< array.size(); i++){
//            System.out.println(array.get(i));
//        }
        if (ultimoPila.equals(array.get(array.size()-1))){
            pila.pop();
            array.remove(array.size()-1);
            pa();
        }

        System.out.println("saliendo de i");
    }

    public void pa(){
        pila.pop();
        pila.push("(");
        String ultimoPila = (String) pila.get(pila.size()-1);

        //Imprimiendo Ultimo en la Pila y Array
        System.out.println("Ultimo en PA "+ultimoPila+" \nUltimo en Array "+ array.get(array.size()-1));

        //Imprimiendo datos de la pila
//        for (int i = pila.size()-1; i >=0 ; i--){
//            System.out.println(pila.get(i));
//        }
        if (ultimoPila.equals(array.get(array.size()-1))){
            pila.pop();
            array.remove(array.size()-1);
            v();
        }
    }

    public void v(){
        System.out.println("Entando a V ");
        pila.pop();
        pila.push("CARACTER");

        //Imprimiendo Ultimo en la Pila y Array
        System.out.println("Ultimo en V "+(String) pila.get(pila.size()-1) +" \nUltimo en Array "+ array.get(array.size()-1));
        for (int i = pila.size()-1; i >=0 ; i--){
            System.out.println(pila.get(i));
        }

        boolean result = expr.validarPalabra(array.get(array.size()-1));
        if (result){
            pila.pop();
            array.remove(array.size()-1);
            pc();
        }
    }

    public void pc(){
        System.out.println("Entrando a PC");
        pila.pop();
        pila.push(")");
        String ultimoPila = (String) pila.get(pila.size()-1);
        System.out.println("Ultimo en PC "+(String) pila.get(pila.size()-1) +" \nUltimo en Array "+ array.get(array.size()-1));
        for (int i = pila.size()-1; i >=0 ; i--){
            System.out.println(pila.get(i));
        }

        if (ultimoPila.equals(array.get(array.size()-1))){
            pila.pop();
            array.remove(array.size()-1);
            la();
        }
    }

    public void la(){
        System.out.println("Entrando a LA");
        pila.pop();
        pila.push("{");
        System.out.println("Ultimo en LA 2 "+(String) pila.get(pila.size()-1) +" \nUltimo en Array "+ array.get(array.size()-1));
        for (int i = pila.size()-1; i >=0 ; i--){
            System.out.println(pila.get(i));
        }

        //Quitando el Enter para poder validar
        String sub = array.get(array.size()-1);
        if (pila.get(pila.size()-1).equals(sub.substring(0,1))){
            pila.pop();
            array.remove(array.size()-1);
            c();
        }
    }

    public void c(){
        System.out.println("Entrando a C");
        pila.pop();
        pila.push(";");
        pila.push("BRK");
        pila.push(";");
        pila.push("PRINT");
        pila.push(":");
        pila.push("VALOR");
        pila.push("CS");
        System.out.println("Ultimo en LA 2 "+(String) pila.get(pila.size()-1) +" \nUltimo en Array "+ array.get(array.size()-1));
        for (int i = pila.size()-1; i >=0 ; i--){
            System.out.println(pila.get(i));
        }
    }

    public void lc(){
        pila.pop();
        pila.push("}");
    }

}
