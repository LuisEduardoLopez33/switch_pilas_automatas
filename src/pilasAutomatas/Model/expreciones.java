package pilasAutomatas.Model;
import java.util.regex.*;

public class expreciones {

    public boolean validarEntrada(String dato) {

        Pattern pat = Pattern.compile("(^(S)=(I|PA|V|PC|LA|C|LC))");
        Matcher mat = pat.matcher(dato);

        return mat.matches();
    }
}
