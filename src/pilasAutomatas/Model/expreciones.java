package pilasAutomatas.Model;
import java.util.regex.*;

public class expreciones {

    public boolean validarPalabra(String dato) {

        Pattern pat = Pattern.compile("[A-Za-z]+");
        Matcher mat = pat.matcher(dato);

        return mat.matches();
    }

    public boolean validarNumeros(String dato) {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(dato);

        return mat.matches();
    }
}
