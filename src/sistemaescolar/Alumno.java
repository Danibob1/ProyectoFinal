package sistemaescolar;

//Librerias
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.security.SecureRandom;
import java.util.Arrays;


/**
 * Clase Alumno contiene los atributos y métodos que generan la información del alumno
 * @author Daniel y Carlos
 * @version 3.0
 */


public class Alumno {
    
    SecureRandom rnd= new SecureRandom();
    //Atributos de un alumno
    private String  nombreCompleto;
    private String direccion;
    private String numCuenta;
    private String materia;
    private int  edad;
    private int numInscripcion;
    private int []calificaciones;

    //Atributos contador 
    private int cont;
    private int cantidad;
    public static int arrayR=-1;

    /**
     * Método constructor por defecto sin ningún parametros.
     * intanciando los atributos a vacios.
     */
    public Alumno() {
        this.nombreCompleto="";
        this.direccion="";
        this.numCuenta="";  
        this.materia="";
        this.edad=0;
        this.numInscripcion=0;
        calificaciones=new int[5];
        cantidad=Alumno.arrayR++;  
    }
    
    /**
     * Método que genenera el Nombre Completo ocupando
     * Tres arreglos que cada uno guarda un Nombre, Apellido Paterno, Apellido Materno
     * @return nombreCompleto
     */
    public String getNombreCompleto() {
        String[] nombre={"Daniel", "Ricardo","Jennifer","Carlos","Maria","Carolina","Alejandro","Andrea","Efrain","Ricardo","Agustin",
                          "Armando", "Apolo", "Karla"," Mayte","Elsa","Hurtado","Abraham","Elmer","Rudy","Tomas"};
        String[] apellidoP={"Prado", "Martinez","Castillo","Lujan","Hernandez","Alarcón","Franco","Martinez","García","Vega","Flores"};
        String[] apellidoM={"Requena","Ordaz","Armenta", "Lezama","Tapia","Colin","Hernandez","Lopez","Narciso","de la Mora","Serrano"};
        rnd= new SecureRandom();
        nombreCompleto=  nombre   [ rnd.nextInt(  (nombre.length)     + 0) ] +" "
                        +apellidoP[ rnd.nextInt(  (apellidoP.length)  + 0) ] +" " 
                        +apellidoM[ rnd.nextInt(  (apellidoM.length)  + 0) ] ;   
        return this.nombreCompleto;
    }
    
    
    /**
     * Método que genenera la edad aleatoria de un alumno
     * entre el rango 
     * @return edad
     */
    public int getEdad(){
        rnd= new SecureRandom();
        edad=rnd.nextInt(27-18+1)+18;
        return this.edad;
    }
    
    /**
     * Método que genera el número de cuenta desde un archivo de texto plano
     * El archivo contiene 9 números generando 101 palabras en una sola linea
     * @return numCuenta
     */
    
    public String getNumCuenta(  ){   
        cont=0;
        int i=0;
        try { 
            File archivo = new File("numCuenta.txt");
            FileReader fr= new FileReader(archivo);
            BufferedReader br= new BufferedReader(fr);
 
            numCuenta=br.readLine( );
            
            StringTokenizer st=new StringTokenizer(numCuenta);
            cont=st.countTokens();
            
            String aux[]= new String[cont];
            
            while( st.hasMoreTokens() ){ 
                aux[i]=st.nextToken();
                i++; 
            }   
           
            numCuenta=aux[cantidad];    
            br.close();
        
        } catch (FileNotFoundException ex) {
            System.out.println("Error inesperado");
        } catch (IOException ex) {
            System.out.println("Error inesperado");
        }
        return this.numCuenta;
    }
    
    /**
     * Método que genera las materias aleatoriamente 
     * en un arreglo bidimensional están guardando las materias
     * @return materia
     */
        
    public String getMateria(){
        
        String[][] materias={{"PRIMERO","Álgebra","Cálculo_y_geometría_analítica","Fundamentos_de_programación","Química","Redacción_y_exposición_de_temas_de_ingeniería"},
                             {"SEGUNDO","Álgebra_lineal", "Cálculo_integral", "Cultura_y_comunicación","Estructura_de_datos_y_algoritmos_I","Mecánica"},
                             {"TERCERO","Cálculo_vectorial","Ecuaciones_diferenciales","Modelos_de_programación_orientada_a_objetos","Optativa_de_competencias_profesionales","Termodinámica"},
                             {"CUARTO","Análisis_de_sistemas_y_señales", "Análisis_numérico","Costos_y_evaluación_de_proyectos","Electricidad_y_magnetismo","Probabilidad"   },
                             {"QUINTO","Acústica_y_óptica", "Análisis_de_circuitos_eléctricos","Dinámica_de_sistemas_físicos","Energía_e_impacto_ambiental", "Física_de_semiconductores"},
                             {"SEXTO","Dispositivos_y_circuitos_electrónicos","Fundamentos_de_control","Introducción_a_la_economía","Máquinas_eléctricas_I","Teoría_electromagnética"},
                             {"SEPTIMO","Amplificadores_electrónicos", "Diseño_digital", "Medición_e_instrumentación","Sistemas_de_comunicaciones_electrónicas", "Sistemas_eléctricos_de_potencia_I"},
                             {"OCTAVO","Automatización", "Circuitos_integrados_analógicos", "Instalaciones_eléctricas","Microprocesadores_y_microcontroladores", "Procesamiento_digital_de_señales"},
                             {"NOVENO","Asignatura_del_campo_de_profundización_seleccionado","Asignatura_del_campo_de_profundización_seleccionado","Electrónica_de_potencia","Ética_profesional","Subestaciones_eléctricas"},
                             {"DECIMO","Asignatura_del_campo_de_profundización_seleccionado","Asignatura_del_campo_de_profundización_seleccionado","Asignatura_del_campo_de_profundización_seleccionado","Plantas_generadoras","Recursos_y_necesidades_de_México"}
        };   
        for (int i = 0; i < 1; i++) { 
            i=rnd.nextInt(  (materias.length-1) );
            for (String materia1 : materias[i]) {
                materia += materia1 +"\t ";      
            }
        }
     return this.materia;  
    }
    
    /**
    * Método que genera los números de inscripción
    * Se genera las calificaciones y escolaridad aleatoriamente
    * @return numInscripcion
    */
     
    public int getNumInscripcion() {
        cont=0;
        int cali[]= {5, 6, 7, 8, 9, 10};  
        float promedio,escolaridad,auxP=0,auxE=0;
        
            for (int i = 0; i <5 ; i++) {
                calificaciones[ i ] =cali[ rnd.nextInt( cali.length) ] ;
                    if (calificaciones[i]>5) {
                        cont += 1; 
                    }  
                auxP+=calificaciones[i]; 
                auxE=cont;    
            }
                                    
        /*int creditos[]={46,40,44,42,48,48,48,46,46,34};        
        int sCreditos[]={46,86,130,172,220,268,316,362,408,442};      
        float     auxNC=0,auxC= 0;          
        auxNC= creditos[ rnd.nextInt(creditos.length) ];     
        auxC=sCreditos[rnd.nextInt(creditos.length)];
        velocidad=(auxNC/auxC)*100;*/
        
        escolaridad=(auxE/5)*100;
        promedio=  (auxP/5);
         
        numInscripcion=(int) (promedio*escolaridad);
       
        return this.numInscripcion;
    }
    
    /**
     * Método que genera la dirección desde un archivo de texto plano
     * El archivo contiene 101 lineas
     * @return direccion
     */
    
    public String getDireccion(){
        cont=0;
        int i=0;
        String contS;
        try{
            
            File archivo = new File("direcciones.txt");
            FileReader fr= new FileReader(archivo);
            BufferedReader br= new BufferedReader(fr);
            
            contS=br.readLine( );
            
            while(contS!=null){
                contS=br.readLine();
                cont++;
            }
            
            String aux[]= new String[cont];
            
            archivo = new File("direcciones.txt");
            fr= new FileReader(archivo);
            br=new BufferedReader(fr);
            
            direccion=br.readLine( );
             
            while (direccion!=null) {
                direccion=br.readLine();
                aux[i]=direccion;
                i++;
            }
            
            direccion=aux[cantidad];
            
            br.close();            
        }catch (FileNotFoundException ex) { 
            System.out.println("\nError inesperado\n");
        }catch (IOException ex) {
            System.out.println("\nError inesperado\n");
        }      
        return this.direccion;
    }
    
    /**
     * Método que modifica el Nombre Completo con el Setter
     * @see metodosCrud modificarAlumno
     * @param nombreCompleto El parametro debe ser tipo String
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    /**
     * Método que modifica la Edad con el Setter
     * dentro de un rango de 17 al 30
     * @param edad El parametro debe ser entero
     */
    public void setEdad(int edad) {
        if(edad>=17 && edad<=30){
            this.edad = edad;
        }else{
            System.out.println("\nImposible tener esa edad\n");
        }
    }
    
    /**
     * Método para modificar las materias
     * @param materia El parametro debe ser tipo cadena
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    /**
     * Método que modifica la Dirección con el Setter
     * @param direccion El parametro debe ser tipo cadena
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Método sobreescribir
     * @return String
     */
    @Override
    public String toString() {
        return "\nAlumno{" 
                +"\n Nombre Completo=" + nombreCompleto+", "
                +"\n Edad= " + edad+", "
                +"\n Dirección "+direccion+", " 
                +"\n Número de Cuenta=" + numCuenta+", " 
                +"\n Carrera= Ingeniería Eléctrica-Electrónica, "
                +"\n Semestre "+materia+", "
                +"\n Calificaciones "+Arrays.toString(calificaciones)+", "
                +"\n Número de Inscripción "+numInscripcion
                + '}';
    }
}