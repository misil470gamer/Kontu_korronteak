
package kontu_korronteak;

import java.util.Scanner;

public class Banco {

    Cuenta cuentas[];
    int contador;    
    

    public Banco() {
        this.cuentas = new Cuenta[100];
        this.contador=0;
    }
    
    public void agregarCuenta  (Cuenta cuenta){
        this.cuentas[this.contador] = cuenta;
        contador++;
    }
    
    public void eliminariCuenta(int i){
        for(int j=i;j<contador-1;j++){
            cuentas[j]=cuentas[j+1];
        }
        cuentas[contador] = null;
        contador--;
    }
    public void IngresarDinero(double i,int j){
        this.cuentas[j].saldo = this.cuentas[j].saldo + i;
    }
    public void RetirarDinero(double i,int j) {
        this.cuentas[j].saldo = this.cuentas[j].saldo - i;
    }
    public double MostrarSaldo(int i) {
        return this.cuentas[i].saldo;
    }
    public void  Transferencia(double i,int j, int x) {
        if (i > this.cuentas[j].saldo) {
        }
        this.cuentas[j].saldo = this.cuentas[j].saldo - i;
        this.cuentas[x].saldo = this.cuentas[x].saldo + i;
    }
    public void CambiarNAN(int i, String j) {
        this.cuentas[i].setNAN(j);
    }
    public void CambiarNombre(int i, String j) {
        this.cuentas[i].setNombre(j);
    }
    public void CambiarApellido(int i, String j) {
        this.cuentas[i].setApellidos(j);
    }
    public void CambiarDireccion(int i, String j) {
        this.cuentas[i].setDireccion(j);
    }
    public void CambiarTelefono(int i, String j) {
        this.cuentas[i].setTelefono(j);;
    }
    public void CambiarComision(int i, double j) {
        this.cuentas[i].setPorcentaje_comisión(j);
    }
    
    

    public static void main(String[] args) {   
        
        Scanner sc = new Scanner(System.in);
        
        Banco banco = new Banco();    
        
        System.out.println("Ingrese tipo: \n"
                + "1) Cuentas Corriente\n"
                + "2) Cuenta de Ahorros\n"
                + "3) Finalizar");
        
        int option = sc.nextInt();       
        
        
        
        switch(option){
            case 1:
                System.out.println("Opciones: \n"
                        + "1) Crear Cuenta corriente\n"
                        + "2) Cerrar Cuenta corriente\n"
                        + "3) Cambiar Datos de Cuenta corriente\n"
                        + "4) Ingresar Dinero\n"
                        + "5) Retirar Dinero\n"
                        + "6) Mostrar Saldo\n"
                        + "7) Transferencia\n"                        
                        + "8) Salir");
                        int option1 = sc.nextInt();
                        switch(option1) {
                            case 1:
                            Cuenta cuenta1= new Cuenta_Corriente("", "", "", "", "");                    
                            banco.agregarCuenta(cuenta1);
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
                                    switch(option2) {
                                        case 1:
                                        System.out.println("Escribe el nuevo NAN");
                                        String NAN = sc.next();
                                        banco.CambiarNAN(numero, NAN);
                                        break;
                                        case 2:
                                        System.out.println("Escribe un nuevo nombre");
                                        String Nombre = sc.next();
                                        banco.CambiarNombre(numero, Nombre);
                                        break;
                                        case 3:
                                        System.out.println("Escribe nuevos apellidos");
                                        String Apellidos = sc.next();
                                        banco.CambiarApellido(numero, Apellidos);
                                        break;
                                        case 4:
                                        System.out.println("Escribe una nueva dirección");
                                        String Direccion = sc.next();
                                        banco.CambiarDireccion(numero, Direccion);
                                        break;
                                        case 5:
                                        System.out.println("Escribe un nuevo telefono");
                                        String Telefono = sc.next();
                                        banco.CambiarNombre(numero, Telefono);
                                        break;
                                        case 6:
                                        System.out.println("Escribe una nueva comision por transaccion");
                                        double Comision = sc.nextDouble();
                                        banco.CambiarComision(numero, Comision);
                                    }

                        }
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
                         switch(option1) {
                             case 1:
                             break;
            }
            case 3:

            default:
                break;
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
    
    private double Descubierto;

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