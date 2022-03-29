package pilasAutomatas.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Stack;

public class modelreten {

    expreciones expr = new expreciones();
    ObservableList<String> array = FXCollections.observableArrayList();
    String[] s = {"I","PA","V","PC","LA","C","LC"};
    boolean status = true;
    int aux = 0;

    Stack pila = new Stack();

    public ObservableList recibendoDato( ObservableList datos){
        System.out.println("INICIANDO CON LA LECTURA");
        array = datos;
        pila.push("S");
        if (pila.size() == 1){
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

    public void imprimirPila(){
        System.out.println("elementos en pila");
        System.out.println(Arrays.asList(pila));
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
        imprimirPila();
        pila.pop();
        for (int i = s.length-1; i >= 0; i--){
            pila.push(s[i]);
        }
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        i();
    }

    public void i(){
        System.out.println("modificando pila:");
        pila.pop();
        pila.push("switch");
        imprimirPila();

//        // imprimiendo array
//        for (int i = 0; i< array.size(); i++){
//            System.out.println(array.get(i));
//        }
        if (pila.peek().equals(array.get(array.size()-1))){
            System.out.println("comparando y eliminando");
            System.out.println("****");
            pila.pop();
            array.remove(array.size()-1);
            pa();
        }

    }

    public void pa(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push("(");
        System.out.println("modificando pila");
        imprimirPila();
        if (pila.peek().equals(array.get(array.size()-1))){
            System.out.println("comparando y eliminando");
            System.out.println("****");
            pila.pop();
            array.remove(array.size()-1);
            v();
        }
    }

    public void v(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push("RESTO");
        pila.push("CARACTER");
        System.out.println("modificando pila: ");
        imprimirPila();

        boolean result = expr.validarPalabra(array.get(array.size()-1));
        if (result){
            System.out.println("comparando y eliminando");
            System.out.println("****");
            pila.pop();
            pila.pop();
            array.remove(array.size()-1);
            pc();
        }
    }

    public void pc(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push(")");
        System.out.println("modificando pila: ");
        imprimirPila();
        if (pila.peek().equals(array.get(array.size()-1))){
            System.out.println("comparando y eliminando");
            System.out.println("****");
            pila.pop();
            array.remove(array.size()-1);
            la();
        }
    }

    public void la(){
        String sub = array.get(array.size()-1);
        System.out.println("evaluar: "+ sub.substring(0,1));
        imprimirPila();
        pila.pop();
        pila.push("{");
        System.out.println("modificando pila: ");
        imprimirPila();

        //Quitando el Enter para poder validar
        if (pila.peek().equals(sub.substring(0,1))){
            System.out.println("comparando y eliminando");
            System.out.println("****");
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
