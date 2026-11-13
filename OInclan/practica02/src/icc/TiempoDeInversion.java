import java.util.Scanner;

/**
 * Programa que simula una inversión a partir de un monto inicial,
 * una fecha de inicio y una fecha de finalización.
 */
public class TiempoDeInversion {
    /**
     * Ejecuta la simulación principal del programa de inversión.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        Scanner intput = new Scanner(System.in);
        String NombreInversionista;
        float MontoInversion;
        double rendimiento;
        double montoFinal;
        boolean repetir = true;
        String respuesta;
        System.out.print("Bienvenido\n\tIngrese el nombre del Inversionista: ");
        NombreInversionista = intput.nextLine();
        do{
            System.out.println("hola " + NombreInversionista);
            MontoInversion = pedirMonto(intput);
            System.out.println("ingresa la fecha en la que vas a empezar a invertir con el formato dd/mm/aaaa:");
            Fecha fechaInicio = pedirFecha(intput);
            System.out.println("ingresa la fecha de fin de tu inversion dd/mm/aaaa");
            Fecha Fechafinal = pedirFecha(intput);
            int diasInversion = fechaInicio.DiferenciaDias(Fechafinal);
            System.out.println("invertiras tu dinero durante "+ diasInversion);
            //pues use rendimiento anual simple, por que las instrucciones no especificaban como tal si era compuesto o mensual o anual

            rendimiento = MontoInversion * 0.12 * diasInversion / 365.0;
            montoFinal = MontoInversion + rendimiento;
            System.out.println("tu ganancia es de " + rendimiento);
            System.out.println("el monto final es " + montoFinal);
            System.out.println("---------------------------");
            System.out.println("Deseas realizar otra simulacion de inversion?");
            System.out.println("S/N");
            respuesta = intput.next().toLowerCase();
            if (respuesta.equals("n")) {
                repetir = false;
            }
        }while(repetir);
    }
    /**
     * Solicita al usuario una fecha válida desde la entrada estándar.
     *
     * @param input flujo de entrada desde el cual se leen día, mes y año
     * @return una instancia de {@link Fecha} válida
     */
    public static Fecha pedirFecha(Scanner input) {
        int dia;
        int mes;
        int anio;
        Fecha fecha;
        do{
            System.out.print("Ingrese el dia: ");
            dia = input.nextInt();
            System.out.print("Ingrese el mes: ");
            mes = input.nextInt();
            System.out.print("Ingrese el anio: ");
            anio = input.nextInt();
            fecha = new Fecha(dia, mes, anio);
            if(fecha.fechaValida() == false){
                System.out.println("fecha invalida");
            }
        }while(fecha.fechaValida() == false);
        System.out.println("fecha validada");
        return fecha;


    }
    /**
     * Valida que un monto de inversión sea positivo.
     *
     * @param monto monto a evaluar
     * @return {@code true} si el monto es mayor que cero; {@code false} en caso contrario
     */
    public static boolean validarMonto(float monto) {
        return monto > 0;

    }
    /**
     * Solicita un monto de inversión válido al usuario.
     *
     * @param input flujo de entrada desde el cual se lee el monto
     * @return monto de inversión positivo ingresado por el usuario
     */
    public static float pedirMonto(Scanner input) {
        float MontoInversion;
        do{
            System.out.print("Ingrese el monto que deseas invertir: ");
            MontoInversion = input.nextFloat();
            if(validarMonto(MontoInversion) == false){
                System.out.println("Monto invalido");
            }
        }while(validarMonto(MontoInversion) == false);

        return MontoInversion;
    }
}