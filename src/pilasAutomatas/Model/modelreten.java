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
        return array;
    }

    public void imprimirPila(){
        System.out.println("elementos en pila");
        System.out.println(Arrays.asList(pila));
    }

    public void popDatos(){
        System.out.println("comparando y eliminando");
        System.out.println("****");
        pila.pop();
        array.remove(array.size()-1);
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
        if (pila.peek().equals(array.get(array.size()-1))){
            popDatos();
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
            popDatos();
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
            pila.pop();
            popDatos();
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
           popDatos();
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
            popDatos();
            c();
        }
    }

    public void c(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push(";");
        pila.push("BRK");
        pila.push(";");
        pila.push("PRINT");
        pila.push(":");
        pila.push("VALOR");
        pila.push("CS");
        System.out.println("modificando pila:");
        imprimirPila();
        CS();
    }

    public void CS(){
        System.out.println("modificando pila:");
        pila.pop();
        pila.push("case");
        imprimirPila();
        if(pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            valor();
        }
    }

    public void valor(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        boolean result = expr.validarNumeros(array.get(array.size()-1));
        if(result){
            pila.pop();
            pila.push("RESTON");
            pila.push("N");
            System.out.println("modifcando pila:");
            imprimirPila();
            popDatos();
            // ir al metodo : (dos puntos)
        }else{
            pila.pop();
            pila.push("COMC");
            pila.push("V");
            pila.push("COM");
            System.out.println("modifcando pila:");
            imprimirPila();
            com();
        }

    }

    public void com(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push('"');
        System.out.println("modificando pila:");
        imprimirPila();
        if(pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            // ir al metodo V - trata de usar una bandera para identificar de que proceso viene, puedes enviarlo como parametro
        }
    }

    public void lc(){
        pila.pop();
        pila.push("}");
    }

}
