/**
 * Representa una fecha con día, mes, año y el nombre del mes asociado.
 */
public class Fecha {

    int dia = 1;
    int mes = 1;
    String mesNombre = "Enero";
    int anio = 2026;
    int eneroDias = 31;
    int febreroDias = 28;
    int marzoDias = 31;
    int abrilDias = 30;
    int mayoDias = 31;
    int junioDias = 30;
    int julioDias = 31;
    int agostoDias = 31;
    int septiembreDias = 30;
    int octubreDias = 31;
    int noviembreDias = 30;
    int diciembreDias = 31;

    /**
     * Crea una fecha con los valores por defecto.
     */
    public Fecha(){
        anioBisiesto();
    }

    /**
     * Crea una fecha con un día, mes y año específicos.
     *
     * @param d el día de la fecha
     * @param m el mes de la fecha
     * @param a el año de la fecha
     */
    public Fecha(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.anio = a;
        anioBisiesto();
        asignarNombreMes();
    }

    /**
     * Crea una fecha con un día, nombre del mes y año específicos.
     *
     * @param d el día de la fecha
     * @param m el nombre del mes
     * @param a el año de la fecha
     */
    public Fecha(int d, String m, int a){
        this.dia = d;
        this.mesNombre = m;
        this.anio = a;
        anioBisiesto();
        asignarNumMes();
    }
    /**
     * Comprueba si la fecha actual es válida según el rango de meses, años y días del mes.
     *
     * @return {@code true} si la fecha es válida; {@code false} en caso contrario
     */
    public boolean fechaValida() {
        if (!mesValido(mes)) {
            return false;
        }
        if  (!anioValido(anio)) {
            return false;
        }

        return dia >= 1 && dia <= getDiasMesNombre();
    }

    /**
     * Obtiene el día actual de la fecha.
     *
     * @return el día
     */
    public int getDia() {
        return dia;
    }

    /**
     * Obtiene el mes numérico de la fecha.
     *
     * @return el mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Obtiene el año de la fecha.
     *
     * @return el año
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el día de la fecha.
     *
     * @param dia el nuevo día
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Establece el mes de la fecha y actualiza el nombre del mes asociado.
     *
     * @param mes el nuevo mes numérico
     */
    public void setMes(int mes) {
        this.mes = mes;
        asignarNombreMes();
    }

    /**
     * Establece el año de la fecha y recalcula si el año es bisiesto.
     *
     * @param año el nuevo año
     */
    public void setAnio(int año) {
        this.anio = año;
        anioBisiesto();
    }

    /**
     * Verifica si un número de anio es válido.
     *
     * @param anio el mes a validar
     * @return true si el mes está entre 1900 y 2100, false en caso contrario
     */

    public boolean anioValido(int anio){
        return anio >= 1900 && anio <= 2100;
    }
    /**
     * Verifica si un número de mes es válido.
     *
     * @param mes el mes a validar
     * @return true si el mes está entre 1 y 12, false en caso contrario
     */

    public boolean mesValido(int mes){
        return mes >= 1 && mes <= 12;
    }

    /**
     * Ajusta la cantidad de días del mes de febrero si el año es bisiesto.
     */
    private void anioBisiesto() {
        febreroDias = 28;

        if (anio % 400 == 0) {
            febreroDias = 29;
        } else if (anio % 4 == 0 && anio % 100 != 0) {
            febreroDias = 29;
        }
    }
    /**
     * Comprueba si el año proporcionado es bisiesto.
     *
     * @param aniotemp año que se desea evaluar
     * @return true si el año es bisiesto; false en caso contrario
     */
    private boolean anioBisiesto(int aniotemp){
       if (anio % 4 == 0) {
           return true;
       }
       return false;
    }

    /**
     * Convierte el nombre del mes en su equivalente numérico.
     */
    private void asignarNumMes(){
        if  (mesValido(mes)){
            if (mesNombre.equals("Enero")) {
                mes = 1;
            }else if (mesNombre.equals("Febrero")) {
                mes = 2;
            }else if (mesNombre.equals("Marzo")) {
                mes = 3;
            }else if (mesNombre.equals("Abril")) {
                mes = 4;
            }else if (mesNombre.equals("Mayo")) {
                mes = 5;
            }else if (mesNombre.equals("Junio")) {
                mes = 6;
            }else if (mesNombre.equals("Julio")) {
                mes = 7;
            }else if (mesNombre.equals("Agosto")) {
                mes = 8;
            }else if (mesNombre.equals("Septiembre")) {
                mes = 9;
            }else if (mesNombre.equals("Octubre")) {
                mes = 10;
            }else if (mesNombre.equals("Noviembre")) {
                mes = 11;
            }else if (mesNombre.equals("Diciembre")) {
                mes = 12;
            }
        }
    }

    /**
     * Asigna el nombre del mes según el valor numérico del mes actual.
     */
    private void asignarNombreMes(){
        if  (mesValido(mes)){
            if (mes == 1) {
                mesNombre = "Enero";
            }else if (mes == 2) {
                mesNombre = "Febrero";
            }else if (mes == 3) {
                mesNombre = "Marzo";
            }else if (mes == 4) {
                mesNombre = "Abril";
            }else if (mes == 5) {
                mesNombre = "Mayo";
            }else if (mes == 6) {
                mesNombre = "Junio";
            }else if (mes == 7) {
                mesNombre = "Julio";
            }else if (mes == 8) {
                mesNombre = "Agosto";
            }else if (mes == 9) {
                mesNombre = "Septiembre";
            }else if (mes == 10) {
                mesNombre = "Octubre";
            }else if (mes == 11) {
                mesNombre = "Noviembre";
            }else if (mes == 12) {
                mesNombre = "Diciembre";
            }
        }
    }
    /**
     * Devuelve la cantidad de días que tiene el mes actual.
     *
     * @return número de días del mes actual
     */
    private int getDiasMesNombre(){
        if (mes == 1){
            return eneroDias;
        }else if (mes == 2){
            return febreroDias;

        }else if (mes == 3){
            return marzoDias;

        }else if (mes == 4){
            return abrilDias;
        }else if (mes == 5){
            return mayoDias;
        }else if (mes == 6){
            return junioDias;
        }else if (mes == 7){
            return julioDias;
        }else if (mes == 8){
            return agostoDias;
        }else if (mes == 9){
            return septiembreDias;
        }else if (mes == 10){
            return octubreDias;
        }else if (mes == 11){
            return noviembreDias;
        }
        return diciembreDias;
    }

    /**
     * Comprueba si esta fecha es posterior a otra fecha.
     *
     * @param otraFecha fecha con la que se compara
     * @return true si esta fecha es mayor que {@code otraFecha}; false en caso contrario
     */
    private boolean FechaMayor(Fecha otraFecha) {
        if (otraFecha.getAnio() > anio) {
            return true;
        } else if (otraFecha.getAnio() < anio) {
            return false;
        } else {
            if (otraFecha.getMes() > mes) {
                return true;
            } else if (otraFecha.getMes() < mes) {
                return false;
            } else {
                if (otraFecha.getDia() > dia) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Calcula la diferencia en días entre esta fecha y otra fecha.
     *
     * @param otraFecha fecha de referencia para calcular la diferencia
     * @return número de días de diferencia entre ambas fechas
     */
    public int DiferenciaDias(Fecha otraFecha) {

        Fecha inicio = new Fecha(dia, mes, anio);

        Fecha fin = new Fecha(
                otraFecha.getDia(),
                otraFecha.getMes(),
                otraFecha.getAnio()
        );

        // Asegurarnos de comenzar con la fecha menor
        if (fin.FechaMayor(inicio)) {
            Fecha temporal = inicio;
            inicio = fin;
            fin = temporal;
        }

        int contador = 0;

        while (inicio.FechaMayor(fin)) {

            if (inicio.getDia() < inicio.getDiasMesNombre()) {
                inicio.setDia(inicio.getDia() + 1);
            } else {
                inicio.setDia(1);

                if (inicio.getMes() < 12) {
                    inicio.setMes(inicio.getMes() + 1);
                } else {
                    inicio.setMes(1);
                    inicio.setAnio(inicio.getAnio() + 1);
                }
            }

            contador++;
        }

        return contador;
    }
    /**
     * Devuelve una representación textual de la fecha en formato dia/mes/año.
     *
     * @return cadena con la fecha formateada
     */
    public String toString(){
        return dia+"/"+mes+"/"+anio;
    }

}
