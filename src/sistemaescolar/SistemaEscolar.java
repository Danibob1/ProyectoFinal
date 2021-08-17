package sistemaescolar;

//Librerías que se utilizan en la clase SistemaEscolar
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Programa de gestión escolar guardando el 
 * registro de alumnos generados aleatoriamente
 * @author Daniel y Carlos
 * @version 3.0
 */

public class SistemaEscolar {
    
    public static void main(String[] args) {
        //Objetos de las Clases Scanner,metodosCrud,Alumno.
        Scanner leer= new Scanner(System.in);
        metodosCrud ayuda= new metodosCrud();
        Alumno alumno = new Alumno();
        //Variables primitivas que nos sirve para leer datos
        int dato=0;
        boolean salir=false;
        
        System.out.println("Bienvenido al Sistema de Registro Escolar\n"
                + "¿Qué desea realizar?\n");
        //Inicio del menú repetitivo
        do{     
                System.out.println("[==============================]");
                System.out.println("[1. Registrar al Alumno        ]");
                System.out.println("[2. Ver Lista de Alumnos       ]");
                System.out.println("[3. Modificar Datos del Alumno ]");
                System.out.println("[4. Eliminar                   ]");
                System.out.println("[5. Descargar Lista            ]");
                System.out.println("[6. Salir                      ]");
                System.out.println("[==============================]");
                System.out.println("Ingrese el número de la operación a realizar\n");
                try{
                dato=leer.nextInt();
                           
                    switch (dato) {
                        
                        case 1: 
                            ayuda.registroAlumnos(alumno);
                        break;
                        
                        case 2:
                            ayuda.conseguirInformacion(alumno);
                        break;
                        
                        case 3:
                            ayuda.modificarAlumno(alumno);
                        break;
                        
                        case 4:
                            ayuda.eliminarAlumno(alumno); 
                        break;
                        
                        case 5:
                            ayuda.descargarLista( alumno );
                        break;
                        
                        case 6:
                            System.out.println("\nCerrando sistema\n");
                            salir =true;
                        break;
                        
                        default:
                            System.out.println("Solo ingrese números entre 1 y 6");
                        break;
                    } 
                }catch(InputMismatchException e){ //Hace una excepción por si ingresa un cáracter en el menú
                    System.out.println("\nIngresa solo números del menú\n");
                    leer.next();
                }
        }while(!salir);
    }
}


