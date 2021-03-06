
package kontu_korronteak;

import java.util.Scanner;
public class Banco 
{

    Cuenta cuentas[];
    int contador; 
    String IBAN;  
    

    public Banco() 
    {
        this.cuentas = new Cuenta[100];
        this.contador=0;
        this.IBAN="ES98-2038-5778-98-0000000000";
    }
    static String ponCerosIzquierda(String N_cuenta,int longitud){
        String ceros = "";
        if(N_cuenta.length()<longitud){
            for(int i=0;i<(longitud-N_cuenta.length());i++){
                ceros = ceros + '0';
            }
            N_cuenta = ceros + N_cuenta;
        }
       
        return N_cuenta;
    }
    public void agregarCuenta  (Cuenta cuenta)
    {
        this.cuentas[this.contador] = cuenta;
        this.IBAN="ES98-2038-5778-98-"+ponCerosIzquierda(Integer.toString(contador), 10);
        contador++;
    }
    
    public void eliminariCuenta(int i)
    {
        for(int j=i;j<contador-1;j++)
        {
            this.cuentas[j]=cuentas[j+1];
        }
        cuentas[contador] = null;
        contador--;
    }
    public void IngresarDinero(double i,int j)
    {
        this.cuentas[j].saldo = this.cuentas[j].saldo + i;
    }
    public void RetirarDinero(double i,int j) 
    {
        this.cuentas[j].saldo = this.cuentas[j].saldo - i;
    }
    public double MostrarSaldo(int i) 
    {
        return this.cuentas[i].saldo;
    }
    public void  Transferencia(double i,int j, int x) 
    {
        if (i > this.cuentas[j].saldo) 
        {
        }
        this.cuentas[j].saldo = this.cuentas[j].saldo - i;
        this.cuentas[x].saldo = this.cuentas[x].saldo + i;
    }
    public static double CalcularIntereses(int i, double x, double j,int z)
    {
        x*=(j/100);
        double intereses = x/z;
        return intereses;
    }
    public double CalcularComision(int x) 
    {
        this.cuentas[x].saldo*=this.cuentas[x].porcentaje_comision;
        return this.cuentas[x].saldo;
    }
    public void CobrarComision(int x,double y)
    {
        this.cuentas[x].saldo -= y;
    }
    public void CambiarNAN(int i, String j) 
    {
        this.cuentas[i].setNAN(j);
    }
    public void CambiarNombre(int i, String j) 
    {
        this.cuentas[i].setNombre(j);
    }
    public void CambiarApellido(int i, String j) 
    {
        this.cuentas[i].setApellidos(j);
    }
    public void CambiarDireccion(int i, String j) 
    {
        this.cuentas[i].setDireccion(j);
    }
    public void CambiarTelefono(int i, String j) 
    {
        this.cuentas[i].setTelefono(j);
    }
    public void CambiarComision(int i, double j) 
    {
        this.cuentas[i].setPorcentaje_comisión(j);
    }
    public void CambiarDescubierto(int i,double j)
    {
        this.cuentas[i].setDescubierto(j);
    }
    
    

    public static void main(String[] args) 
    {   
        
        Scanner sc = new Scanner(System.in);
        
        Banco banco = new Banco(); 
        int option = 0;  
        while (option!=3) 
        {
        System.out.println("Bienvenido al Banco Santander, escoja tipo de cuenta a gestionar: \n"
                + "1) Cuenta Corriente\n"
                + "2) Cuenta de Ahorros\n"
                + "3) Finalizar");
        
         option = sc.nextInt();       
        
        
        
        switch(option){
            case 1:
                System.out.println("Opciones: \n"
                        + "1) Crear Cuenta corriente\n"
                        + "2) Cerrar Cuenta corriente\n"
                        + "3) Cambiar Datos de Cuenta corriente\n"
                        + "4) Mostrar Datos\n"
                        + "5) Ingresar Dinero\n"
                        + "6) Retirar Dinero\n"
                        + "7) Mostrar Saldo\n"
                        + "8) Transferencia\n"                        
                        + "8) Salir");
                         int option1 = sc.nextInt();
                        switch(option1) 
                        {
                            case 1:
                            Cuenta cuenta1= new Cuenta_Corriente("", "", "", "", "");                
                            banco.agregarCuenta(cuenta1);
                            System.out.println("Hau da zure kontu zenbakia "+banco.IBAN);
                            break;
                            case 2:
                            System.out.println("Que cuenta quieres eliminar");
                             int numero = sc.nextInt();
                             if (banco.cuentas[numero] == null) 
                             {
                                 System.out.println("El numero de cuenta que has introducido no existe");
                                 break;
                             }
                             banco.eliminariCuenta(numero);
                             System.out.println("Cuenta "+numero+" eliminada exitosamente");
                             break;
                            case 3:
                            System.out.println("A que cuenta quieres editarle los atributos");
                            numero = sc.nextInt();
                            if (banco.cuentas[numero] == null) 
                            {
                                System.out.println("El numero de cuenta que has introducido no existe");
                                break;
                            }
                            System.out.println("Opciones\n"
                                    + "1.- Cambiar NAN\n" 
                                    + "2.- Cambiar nombre\n"
                                    + "3.- Cambiar apellido\n"
                                    + "4.- Cambiar dirección\n"
                                    + "5.- Cambiar telefono\n"
                                    + "6.- Cambiar comisión\n"
                                    + "7.-  Finalizar\n");
                                    int option2 = sc.nextInt();
                                    double comision = banco.CalcularComision(numero);
                                    System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                    int option3 = sc.nextInt();
                                 if (option3!=1)
                                    {
                                        break;
                                    }
                                    
                                    banco.CobrarComision(numero, comision);
                                    System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                    switch(option2) 
                                    {
                                        case 1:
                                        System.out.println("Escribe el nuevo NAN");
                                        String NAN = sc.next();
                                        banco.CambiarNAN(numero, NAN);
                                        System.out.println("NAN cambiado correctamente "+ NAN);
                                        break;
                                        case 2:
                                        System.out.println("Escribe un nuevo nombre");
                                        String Nombre = sc.next();
                                        banco.CambiarNombre(numero, Nombre);
                                        System.out.println("Nombre cambiado correctamente a "+Nombre);
                                        break;
                                        case 3:
                                        System.out.println("Escribe nuevos apellidos");
                                        String Apellidos = sc.next();
                                        banco.CambiarApellido(numero, Apellidos);
                                        System.out.println("Apellidos cambiados correctamente a "+Apellidos);
                                        break;
                                        case 4:
                                        System.out.println("Escribe una nueva dirección");
                                        String Direccion = sc.next();
                                        banco.CambiarDireccion(numero, Direccion);
                                        System.out.println("Direccion cambiada correctamente a "+Direccion);
                                        break;
                                        case 5:
                                        System.out.println("Escribe un nuevo telefono");
                                        String Telefono = sc.next();
                                        banco.CambiarTelefono(numero, Telefono);
                                        System.out.println("Telefono cambiado correctamente a "+Telefono);
                                        break;
                                        case 6:
                                        System.out.println("Escriba una nueva comision");
                                        Double Comision = sc.nextDouble();
                                        banco.CambiarComision(numero, Comision);
                                        System.out.println("Comision cambiada correctamente a "+Comision);
                                        break;
                                        case 7:
                                        break;
                                    }
                                    break;
                                    case 4:
                                    System.out.println("Introduzca numero de cuenta de la que ver los datos");
                                    numero = sc.nextInt();
                                    if (banco.cuentas[numero] == null) 
                                    {
                                 System.out.println("El numero de cuenta que has introducido no existe");
                                 break;
                                    }
                                    comision = banco.CalcularComision(numero);
                                    System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                    option2 = sc.nextInt();
                                 if (option2!=1)
                                    {
                                        break;
                                    }
                                    
                                    banco.CobrarComision(numero, comision);
                                    System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                    System.out.println(banco.cuentas[numero].mostrarDatos());
                                    break;
                                    case 5:
                                    
                                    System.out.println("Introduzca numero de cuenta a la que ingresar");
                                    numero = sc.nextInt();
                                    if (banco.cuentas[numero] == null) 
                                    {
                                 System.out.println("El numero de cuenta que has introducido no existe");
                                 break;
                                    }
                                    comision = banco.CalcularComision(numero);
                                    System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                    option2 = sc.nextInt();
                                 if (option2!=1)
                                    {
                                        break;
                                    }
                                    
                                    banco.CobrarComision(numero, comision);
                                    System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                    System.out.println("Introduzca cantidad a ingresar");
                                    double cantidad = sc.nextDouble();
                                    banco.IngresarDinero(cantidad, numero);
                                    System.out.println("Dinero ingresado correctamente \nCantidad actual: "+banco.cuentas[numero].saldo);
                                    break;
                                    case 6:
                                    System.out.println("Introduzca numero de cuenta de la que quiere retirar");
                                    numero = sc.nextInt();
                                    if (banco.cuentas[numero] == null) 
                                    {
                                        System.out.println("El numero de cuenta que has introducido no existe");
                                        break;
                                           }
                                           comision = banco.CalcularComision(numero);
                                           System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                           option2 = sc.nextInt();
                                        if (option2!=1)
                                           {
                                               break;
                                           }
                                           
                                           banco.CobrarComision(numero, comision);
                                           System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                    System.out.println("Introduzca cantidad a retirar");
                                    cantidad = sc.nextDouble();
                                    if (banco.cuentas[numero].saldo < 0) 
                                    {
                                        System.out.println("No tienes saldo suficiente");
                                        break;
                                    }
                                    banco.RetirarDinero(cantidad, numero);
                                    cantidad = banco.MostrarSaldo(numero);
                                    System.out.println("Dinero retirado correctamente\nCantidad actual: "+cantidad);
                                    break;
                                    case 7: 
                                    System.out.println("Introduzca un numero de cuenta");
                                    numero = sc.nextInt();
                                    if (banco.cuentas[numero] == null) 
                                    {
                                        System.out.println("El numero de cuenta que has introducido no existe");
                                        break;
                                           }
                                           comision = banco.CalcularComision(numero);
                                           System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                           option2 = sc.nextInt();
                                        if (option2!=1)
                                           {
                                               break;
                                           }
                                           
                                           banco.CobrarComision(numero, comision);
                                           System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                    cantidad = banco.MostrarSaldo(numero);
                                    System.out.println("Saldo actual: "+cantidad);
                                    break;
                                    case 8:
                                    System.out.println("Introduzca cuenta de origen");
                                    numero = sc.nextInt();
                                    if (banco.cuentas[numero] == null) 
                                    {
                                        System.out.println("El numero de cuenta que has introducido no existe");
                                        break;
                                           }
                                           comision = banco.CalcularComision(numero);
                                           System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                           option2 = sc.nextInt();
                                        if (option2!=1)
                                           {
                                               break;
                                           }
                                           
                                           banco.CobrarComision(numero, comision);
                                           System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                    System.out.println("Introduzca cuenta a la que quiere ingresar");
                                    int numero1 = sc.nextInt();
                                    if (banco.cuentas[numero1] == null) 
                                    {
                                        System.out.println("El numero de cuenta que has introducido no existe");
                                        break;
                                           }
                                    System.out.println("Introduzca la cantidad a transferir");
                                    cantidad = sc.nextDouble();
                                    banco.Transferencia(cantidad, numero, numero1);
                                    System.out.println("Cantidad Transferida correctamente\nSaldo cuenta 1: "+banco.cuentas[numero].saldo+"\n"+"cuenta 2: "+banco.cuentas[numero1].saldo);
                                           break;
                                           case 9:
                                           break;
                        }
                        break;
            case 2:
            System.out.println("Opciones: \n"
                    + "1) Crear Cuenta de Ahorros\n"
                    + "2) Cerrar Cuenta de Ahorros\n"
                    + "3) Cambiar Datos de Cuenta de Ahorros\n"
                    + "4) Ingresar Dinero\n"
                    + "5) Retirar Dinero\n"
                    + "6) Mostrar Saldo\n"
                    + "7) Calcular Intereses\n"                        
                    + "8) Salir");
                    option1 = sc.nextInt();
                    switch(option1) 
                    {
                        case 1:
                            Cuenta cuenta1= new Cuenta_Ahorros("", "", "", "", "");                
                            banco.agregarCuenta(cuenta1);
                            System.out.println("Hau da zure kontu zenbakia "+banco.IBAN);
                            break;
                        case 2:
                        System.out.println("Que cuenta quieres eliminar");
                         int numero = sc.nextInt();
                         banco.eliminariCuenta(numero);
                         System.out.println("Cuenta "+numero+" eliminada exitosamente");
                         break;
                        case 3:
                        System.out.println("A que cuenta quieres editarle los atributos");
                        numero = sc.nextInt();
                        if (banco.cuentas[numero] == null) 
                        {
                            System.out.println("El numero de cuenta que has introducido no existe");
                            break;
                               }
                        System.out.println("Opciones\n"
                                + "1.- Cambiar NAN\n" 
                                + "2.- Cambiar nombre\n"
                                + "3.- Cambiar apellido\n"
                                + "4.- Cambiar dirección\n"
                                + "5.- Cambiar telefono\n"
                                + "6.- Cambiar comisión\n"
                                + "7.- Cambiar descubierto\n"
                                + "8.-  Finalizar\n");
                                int option2 = sc.nextInt();
                                double comision = banco.CalcularComision(numero);
                                System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                int option3 = sc.nextInt();
                             if (option3!=1)
                                {
                                    break;
                                }
                                
                                banco.CobrarComision(numero, comision);
                                System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                switch(option2) 
                                {
                                    case 1:
                                    System.out.println("Escribe el nuevo NAN");
                                    String NAN = sc.next();
                                    banco.CambiarNAN(numero, NAN);
                                    System.out.println("NAN cambiado correctamente "+ NAN);
                                    break;
                                    case 2:
                                    System.out.println("Escribe un nuevo nombre");
                                    String Nombre = sc.next();
                                    banco.CambiarNombre(numero, Nombre);
                                    System.out.println("Nombre cambiado correctamente "+ Nombre);
                                    break;
                                    case 3:
                                    System.out.println("Escribe nuevos apellidos");
                                    String Apellidos = sc.next();
                                    banco.CambiarApellido(numero, Apellidos);
                                    System.out.println("Apellidos cambiados correctamente "+ Apellidos);
                                    break;
                                    case 4:
                                    System.out.println("Escribe una nueva dirección");
                                    String Direccion = sc.next();
                                    banco.CambiarDireccion(numero, Direccion);
                                    System.out.println("Direccion cambiada correctamente "+ Direccion);
                                    break;
                                    case 5:
                                    System.out.println("Escribe un nuevo telefono");
                                    String Telefono = sc.next();
                                    banco.CambiarTelefono(numero, Telefono);
                                    System.out.println("Telefono cambiado correctamente "+ Telefono);
                                    break;
                                    case 6:
                                    System.out.println("Escribe una nueva comision por transaccion");
                                    double Comision = sc.nextDouble();
                                    banco.CambiarComision(numero, Comision);
                                    System.out.println("Comision cambiada correctamente "+ Comision);
                                    break;
                                    case 7:
                                    System.out.println("Escribe un nuevo descubierto para la cuenta");
                                    double Descubierto = sc.nextDouble();
                                    banco.CambiarDescubierto(numero, Descubierto);
                                    System.out.println("Descubierto cambiado correctamente "+ Descubierto);

                                }
                                break;
                                case 4:
                                System.out.println("Introduzca numero de cuenta a la que ingresar");
                                numero = sc.nextInt();
                                if (banco.cuentas[numero] == null) 
                                {
                                    System.out.println("El numero de cuenta que has introducido no existe");
                                    break;
                                       }
                                       comision = banco.CalcularComision(numero);
                                       System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                       option2 = sc.nextInt();
                                    if (option2!=1)
                                       {
                                           break;
                                       }
                                       
                                       banco.CobrarComision(numero, comision);
                                       System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                System.out.println("Introduzca cantidad a ingresar");
                                double cantidad = sc.nextDouble();
                                banco.IngresarDinero(cantidad, numero);
                                cantidad = banco.MostrarSaldo(numero);
                                System.out.println("Dinero ingresado correctamente \nCantidad actual: "+cantidad);
                                break;
                                case 5:
                                System.out.println("Introduzca numero de cuenta de la que quiere retirar");
                                numero = sc.nextInt();
                                if (banco.cuentas[numero] == null) 
                                {
                                    System.out.println("El numero de cuenta que has introducido no existe");
                                    break;
                                       }
                                       comision = banco.CalcularComision(numero);
                                       System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                       option2 = sc.nextInt();
                                    if (option2!=1)
                                       {
                                           break;
                                       }
                                       
                                       banco.CobrarComision(numero, comision);
                                       System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                System.out.println("Introduzca cantidad a retirar");
                                cantidad = sc.nextDouble();
                                if (banco.cuentas[numero].saldo < 0) 
                                {
                                    System.out.println("No tienes saldo suficiente");
                                    break;
                                }
                                banco.RetirarDinero(cantidad, numero);
                                cantidad = banco.MostrarSaldo(numero);
                                System.out.println("Dinero retirado correctamente \nCantidad actual: "+cantidad);
                                break;
                                case 6: 
                                System.out.println("Introduzca un numero de cuenta");
                                numero = sc.nextInt();
                                if (banco.cuentas[numero] == null) 
                                {
                                    System.out.println("El numero de cuenta que has introducido no existe");
                                    break;
                                       }
                                       comision = banco.CalcularComision(numero);
                                       System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                       option2 = sc.nextInt();
                                    if (option2!=1)
                                       {
                                           break;
                                       }
                                       
                                       banco.CobrarComision(numero, comision);
                                       System.out.println("Saldo:"+banco.MostrarSaldo(numero));
                                cantidad = banco.MostrarSaldo(numero);
                                System.out.println("Saldo actual: "+cantidad);
                                break;
                                case 7:
                                System.out.println("Introduzca numero de cuenta de la que quiere calcular los intereses");
                                numero = sc.nextInt();
                                if (banco.cuentas[numero] == null) 
                                {
                                    System.out.println("El numero de cuenta que has introducido no existe");
                                    break;
                                       }
                                       comision = banco.CalcularComision(numero);
                                       System.out.println("Para hacer la operacion se le cobrara una comision de "+comision+" euros\nQuiere seguir adelante?\n1) Si\n2) No");
                                       option2 = sc.nextInt();
                                    if (option2!=1)
                                       {
                                           break;
                                       }
                                       banco.CobrarComision(numero, comision);
                                       System.out.println("Introduzca cantidad para el prestamo");
                                       cantidad = sc.nextDouble();
                                       System.out.println("Introduzca interes");
                                       int interes = sc.nextInt();
                                       System.out.println("Introduzca el numero de meses en los cuales quiere pagar el prestamo");
                                       int N_meses = sc.nextInt();
                                       System.out.println("Esto es lo que tendra que pagar mensualmente: "+CalcularIntereses(numero, cantidad, interes, N_meses));
                                break;
                                case 8:
                                break;
                                default:
                                break;
                            }
        break;

            case 3:
            break;

            default:
                break;
        }
        
        
        
       
    }  
    }
}

class Cuenta {

    protected String NAN, Nombre, Apellidos, Direccion, Telefono, Tipo;
    protected double saldo, porcentaje_comision;
    
    public Cuenta(){
        this.NAN = "";
        this.Nombre = "";
        this.Apellidos = "";
        this.Direccion = "";
        this.Telefono = "";
        this.saldo = 0;
    }

    public Cuenta(String NAN, String Nombre, String Apellidos,
            String Direccion, String Telefono) {
        this.NAN = NAN;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.saldo = 0;
    }

    public String getNAN() {
        return NAN;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getPorcentaje_comision() {
        return porcentaje_comision;
    }

    public void setNAN(String NAN) {
        this.NAN = NAN;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPorcentaje_comisión(double porcentaje_comisión) {
        this.porcentaje_comision = porcentaje_comisión;
    }
    public void setDescubierto(double x)
    {
        Cuenta_Ahorros cuenta = new Cuenta_Ahorros(NAN, Nombre, Apellidos, Direccion, Telefono);
        x = cuenta.Descubierto;
    }
    public double getDescubierto() {
        Cuenta_Ahorros cuenta = new Cuenta_Ahorros(NAN, Nombre, Apellidos, Direccion, Telefono);
        return cuenta.Descubierto;
    }

    public String mostrarDatos() {
        return "NAN: " + this.NAN + "\n"
                + "Nombre: " + this.Nombre + "\n"
                + "Apellidos: " + this.Apellidos + "\n"
                + "Dirección: " + this.Direccion + "\n"
                + "Teléfono: " + this.Telefono + "\n"
                + "Saldo: " + this.saldo;
    }

}

class Cuenta_Ahorros extends Cuenta {
    
    protected double Descubierto;

    public Cuenta_Ahorros(String NAN, String Nombre, String Apellidos,
            String Direccion, String Telefono) {
        super(NAN, Nombre, Apellidos, Direccion, Telefono);
        this.Tipo = "Cuenta de Ahorros";
        this.porcentaje_comision = 0.15;
        this.Descubierto = 0;
    }
    @Override
    public String mostrarDatos() {
        return "Tipo: " + this.Tipo + "\n"
                + super.mostrarDatos() + "\n"
                + "Porcentaje de Comisión: " + this.porcentaje_comision
                + "Descubierto" + this.Descubierto;
    }

}

class Cuenta_Corriente extends Cuenta {

    public Cuenta_Corriente(String NAN, String Nombre, String Apellidos,
            String Direccion, String Telefono) {
        super(NAN, Nombre, Apellidos, Direccion, Telefono);
        this.Tipo = "Cuenta Corriente";
        this.porcentaje_comision = 0.10;
    }

    @Override
    public String mostrarDatos() {
        return "Tipo: " + this.Tipo + "\n"
                + super.mostrarDatos() + "\n"
                + "Porcentaje de Comisión: " + this.porcentaje_comision;
    }
}