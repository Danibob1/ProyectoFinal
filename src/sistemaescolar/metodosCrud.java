package sistemaescolar;

//Librerías que se utilizan en la clase metodosCrud
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase  metodosCrud, esta clase elabora las operaciones del menú
 * @author Daniel y Carlos
 * @version 3.0
 */
public class metodosCrud{
    
    
    ArrayList<Alumno> listaAlumno= new ArrayList<>();  //Haciendo un objeto llamado listaAlumno de la Clase ArrayList, que va a guardar el objeto alumno (útil para guardar información)
    Scanner entrada= new Scanner(System.in);// Haciendo un objeto llamado entrada de la clase Scanner, para guardar información que ingrese el usuario (útil para el método modificarAlumno )
    
    /**
     * Método void registroAlumnos sirve para registrar los alumnos,
     * consigue generar la información con los Getters de la clase Alumno
     * @param alumno recibe objeto tipo alumno
     */
    public void registroAlumnos(Alumno alumno){
        //for (int i = 0; i < 100; i++) {
        
        alumno= new Alumno(); //Instancia un nuevo objeto alumno.
        alumno.getNombreCompleto();//Genera Nombre Completo.
        alumno.getEdad();//Genera Edad.
        alumno.getDireccion();//Genera Dirección.
        alumno.getNumCuenta();// Genera Número de Cuenta(De aquí tambien obtiene las calificaciones).
        alumno.getNumInscripcion();// Genera Número de inscripción.
        alumno.getMateria();// Genera las materias 
        listaAlumno.add(alumno);// Agrega toda la información a la lista.
        //}
        //Imprime el registro generado del Alumno y el tamaño de la lista.
        System.out.println("\nAlumno Agregado Con Los Siguientes Datos\n"+alumno
                +"\n\nTamaño de la Lista Alumno "+listaAlumno.size()+"\n");   
    }
    
    /**
     * Método void conseguirInformacion sirve para imprimir todo el registro de 
     * la lista de los alumnos que se han generado.
     * @param alumno recibe objeto tipo alumno
     */
    
    public void conseguirInformacion(Alumno alumno){
       
        if (listaAlumno.isEmpty()){//Comprueba si la lista esta vacía.
            System.out.println("\n No hay ningún registro en la lista :c \n");
        }else{// Si no esta vacía hace el recorrido del tamaño de la lista.
            for (int i = 0; i < listaAlumno.size(); i++) {
                System.out.println("\nAlumno "+(i+1));  
                alumno=listaAlumno.get(i);//Consigue toda la información de los alumnos. 
                System.out.println(alumno);//Imprime la información de los alumnos.
            }
        }
    }

     /**
     * Método void modificarAlumno sirve para modificar los datos del Alumno 
     * se necesita el número de cuenta del estudiante para ingresar a las modificaciones
     * puede modificar nombre, edad, dirección.
     * @param alumno recibe objeto tipo alumno
     */
    
    public void modificarAlumno(Alumno alumno){
        
        if(listaAlumno.isEmpty()){//Comprueba si la lista esta vacía.
            System.out.println("No hay nada que modificar la lista esta vacía");    
        }else{// Si no esta vacía le pide al usuario ingresar un número de cuenta para modificar la información.
            
            entrada= new Scanner(System.in);//El objeto entrada va a leer lo que digite el usuario.
            String comp;// Variable auxiliar que va a guardar la cadena que digite el usuario.
            
            System.out.println("\nIngresa el numero de cuenta del alumno a modifcar\n");
            comp= entrada.nextLine(); //Se guarda la entrada en la variable comp
            
                for (int i = 0; i < listaAlumno.size(); i++) {//Hace el recorrido del tamaño de la lista.
                    alumno=listaAlumno.get(i);//Consigue toda la información.
                        if(comp.equals(alumno.getNumCuenta() )){// Si existe el número de cuenta buscado realiza las operaciones del menú.
                            
                            boolean salir=false;// Variable tipo boolean igualado a un false (Sirve para salir del menú de este método).
                            int aux;//Variable auxiliar int para que ingrese el número de la operación a realizar.
                            entrada= new Scanner(System.in);//Se intancia de nuevo el objeto entrada.
                            
                            //Imprime la información del alumno junto el menú de operaciones.
                            do{
                                System.out.println(alumno);
                                System.out.println("¿Qué dato quiere modificar? \n");
                                System.out.println("1.Nombre del alumno");
                                System.out.println("2.Edad del alumno");
                                System.out.println("3.Materias");
                                System.out.println("4.Dirección");
                                System.out.println("5.Salir sin hacer cambios");
                                aux=entrada.nextInt();
                            
                                switch (aux) {
                                
                                        case 1://Modifica nombre con ayuda del Setter
                                            entrada= new Scanner(System.in);
                                            System.out.println("\n Ingrese el nuevo nombre\n");
                                            String nombreNuevo = entrada.nextLine();
                                            alumno.setNombreCompleto(nombreNuevo);
                                        break;
                                
                                        case 2://Modifica edad con ayuda del Setter
                                            try{
                                                entrada= new Scanner(System.in);
                                                System.out.println("\nIngresa la nueva Edad\n ");
                                                int edadNueva= entrada.nextInt();
                                                alumno.setEdad(edadNueva);
                                            }catch(Exception e){
                                                System.out.println("\nError de caracter\n");
                                             }
                                        break;
   
                                        case 3://Modifica las materias con ayuda del Setter
                                            entrada= new Scanner(System.in);
                                            System.out.println("\nIngresa de nuevo las materias \n ");
                                            String materiasNueva= entrada.nextLine();
                                            alumno.setMateria(materiasNueva);
                                        break;
                                    
                                        case 4://Modifica la dirección con ayuda del Setter
                                            entrada= new Scanner(System.in);
                                            System.out.println("\nIngresa la nueva dirección \n ");
                                            String direccionNueva= entrada.nextLine();
                                            alumno.setDireccion(direccionNueva);
                                        break;
                                     
                                        case 5://Sale del menú 
                                            System.out.println("\nSaliendo de las modificaciones\n");
                                            salir=true;
                                        break;
                                
                                        default:// Por si pasa un error.
                                            System.out.println("\n Solo ingrese números entre 1 y 5 \n");
                                        break;
                                }//Cierra el switch
                            }while(!salir);
                        }       
                }  
        }   
    }
    
    
     /**
     * Método void eliminarAlumno sirve para eliminar registro del Alumno 
     * @param alumno recibe objeto tipo alumno
     */
    
    public void eliminarAlumno(Alumno alumno){
        
        if(listaAlumno.isEmpty()){//Comprueba si la lista esta vacía.
            System.out.println("\nNo hay nada que borrar el registro esta vacio\n");
        }else{// Si no esta vacía le pide al usuario ingresar un número de cuenta para eliminar la información.
            
            entrada = new Scanner(System.in);//El objeto entrada va a leer lo que digite el usuario.
            String comp;// Variable auxiliar que va a guardar la cadena que digite el usuario.
            System.out.println("Ingresa el número de cuenta para borrar el regisrtro");
            comp=entrada.nextLine();//Se guarda la entrada en la variable comp
            
            for (int i = 0; i < listaAlumno.size(); i++) {//Hace el recorrido del tamaño de la lista.
                alumno=listaAlumno.get(i);//Consigue toda la información.               
                  
                    if( comp.equals( alumno.getNumCuenta() ) ) {// Si existe el número de cuenta buscado elimina el registro.       
                        System.out.println("\n Alumno encontrado\n");
                        System.out.println(  listaAlumno.get(i) );
                        listaAlumno.remove(i);//Elimina el registro.
                        System.out.println("\nAlumno removido\n");  
                     } 
            }
        } 
    }
    
    /**
     * Método que descarga la lista Alumno y lo exporta en csv
     * Se necesita importar CsvWriter 
     * @param alumno recibe objeto tipo alumno
     * "https://www.csvreader.com/java_csv.php" - Página de descarga
     */
    public void descargarLista( Alumno alumno) {
        
        if(listaAlumno.isEmpty()){
            System.out.println("\nNo se puede realizar la operación porque no hay nada en lista\n");
        }else{
            
            System.out.println("\nDescargando Lista\n"); 
            
            String aux= "listaAlumnos.csv";
            
            boolean existe= new File(aux).exists();
        
            if (existe) {
                File listaAlumnos =  new File(aux);
                listaAlumnos.delete();
            }
                
            try{
            
            CsvWriter salidaCSV= new CsvWriter(new FileWriter (aux ,true),',');
       
                for (int i = 0; i < listaAlumno.size(); i++) {
                
                    String[] datos=new String[listaAlumno.size()];
                    alumno=listaAlumno.get(i);
                
                    datos[i]=alumno.toString();
                    
                    System.out.println("Alumnos guaradandose con los datos:\n");
                    System.out.println(datos[i]+"\n");
                    salidaCSV.writeRecord(datos);
                    salidaCSV.endRecord();
                    
                }
                        
            salidaCSV.close();
            
            }catch(IOException e){
                System.out.println("\nError inesperado\n");
            }
            System.out.println("Operación realizado con exito :D");
        }
    }
}
