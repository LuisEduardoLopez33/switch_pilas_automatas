package pilasAutomatas.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Stack;

public class modelreten {

    expreciones expr = new expreciones();
    ObservableList<String> array = FXCollections.observableArrayList();
    String[] s = {"I","PA","V","PC","LA","C","LC"};
    String[] c = {"CS","VALOR",":","PRINT",";","BRK",";"};
    boolean aux = true;
    boolean status = true;
    boolean resultado = false;

    Stack pila = new Stack();

    public boolean recibendoDato( ObservableList datos){
        System.out.println("INICIANDO CON LA LECTURA");
        array = datos;
        pila.push("S");
        if (pila.size() == 1){
            s();
        }
        return resultado;
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
            if (aux) {
                pc();
            }
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
            if (pila.size() == 1){
                lc();
            }
        }
    }

    public void c(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        //agregando dependencias de C
        for (int i = c.length-1; i >= 0; i--){
            pila.push(c[i]);
        }
        System.out.println("modificando pila:");
        imprimirPila();
        pila.pop();
        CS();
        valor();
        dosPuntos();
    }

    public void CS(){
        System.out.println("modificando pila:");
        //pila.pop();
        pila.push("case");
        imprimirPila();
        if(pila.peek().equals(array.get(array.size()-1))){
            popDatos();
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
            pila.pop();
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
        pila.push("“");
        System.out.println("modificando pila:");
        imprimirPila();


        if(pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            // ir al metodo V - trata de usar una bandera para identificar de que proceso viene, puedes enviarlo como parametro
            aux = false;
            v();
            comC();
        }
    }

    public void comC(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push("”");
        System.out.println("modificando pila:");
        imprimirPila();

        if(pila.peek().equals(array.get(array.size()-1))){
            popDatos();
        }
    }

    public void dosPuntos(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        //pila.pop();
        //pila.push(":");
        System.out.println("modificando pila: ");
        imprimirPila();

        if (pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            print();
        }
    }

    public void print(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push("System.out.println(“Hola”)");
        System.out.println("modificando pila: ");
        imprimirPila();

        if (pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            puntoyComa();
        }
    }

    public void puntoyComa(){
        String sub = array.get(array.size()-1);
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();

        if (pila.peek().equals(sub.substring(0,1))){
            popDatos();
            if (status) {
                brk();
            }
        }
    }

    public void brk(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        imprimirPila();
        pila.pop();
        pila.push("break");
        System.out.println("modificando pila: ");
        imprimirPila();

        System.out.println("Pila "+pila.peek() + " array "+array.get(array.size()-1));
        if (pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            status = false;
            puntoyComa();
            imprimirPila();
            if (array.get(array.size()-1).equals("case")){
                pila.push("C");
                c();
                brk();
            }
        }
    }

    public void lc(){
        System.out.println("evaluar: "+ array.get(array.size()-1));
        pila.pop();
        pila.push("}");
        System.out.println("modificando pila: ");
        imprimirPila();

        if (pila.peek().equals(array.get(array.size()-1))){
            popDatos();
            imprimirPila();
            System.out.println("Array "+ array.size());
            resultado = true;
        }
    }

}
