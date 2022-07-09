package proyectoFinalG1.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Grupo 1
 */
public class Validacion {

    public boolean ValidarNumerosEnteros(int x) {
        if (x == (int) x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidarEdad(int x) {
        if ((x == (int) x) && x > 0 && x < 100) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidarDni(int x) {
        if ((x == (int) x) && x > 0 && x < 999999999) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EstaVacio(String x) {
        if (x == "") {
            return true;
        } else {
            return false;
        }
    }

    public boolean EsPalabra(String x) {
        if (x == (String) x && x != "") {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidarEmail(String email) {
        String regx = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
