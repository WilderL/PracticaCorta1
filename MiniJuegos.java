
package minijuegos;
import java.util.Scanner;
import java.util.Random;

public class MiniJuegos {
    
    static int salir = 1, menu;
    static String continuar = "S", continuar1;
    static Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) {
       do{
            System.out.println("///////////////////////Menu//////////////////////");
            System.out.println("1. Ahorcado");
            System.out.println("2. Basketball");
            System.out.println("3. Juego de cartas");
            System.out.println("4. Hanoi");
            System.out.println("5. Quieres salir del menu");
            System.out.println("Ingrese el numero de la opción que desee ingresar:");
            menu = Integer.valueOf(lector.nextLine());
            limpiarPantalla();
            switch (menu){
                case 1:
                    ahorcado();
                    break;
                case 2:
                    basketball();
                    break;
                case 3:
                    juegoDeCartas();
                    break;
                case 4:
                    hanoi();
                    break;
                case 5:
                    salir = 0;
                    break;
            
            }
       }while(salir != 0);
    }
    
    public static void limpiarPantalla() {
        //Sirve como el clear de la consola
	System.out.print("\033[H\033[2J");
	System.out.flush();
    }
    
    public static void ahorcado(){
        String palabraClave; 
	String palabraBuscar;
        int numLetras[];
	int contDeFallas ,nuFallos, contDeBuenas;
	do {
            System.out.println("El presente juego el usurario tendra que adivinar una palabra que otro usuario introducio previamente y cada vez que se equivoque empezara aparecer partes de un hombre ahorcado.");
            System.out.print("Ingrese la palabra para que el jugador tendra que adivinar: ");
            palabraClave = lector.nextLine();
            limpiarPantalla();
            contDeBuenas = 0;
            numLetras = new int[palabraClave.length()];
            nuFallos = 0;
            //Este ciclo hace que las letras de la palabra no se valla a mostrar al principio
            for (int i = 0; i < palabraClave.length(); i++) {
                numLetras[i] = 1000;
            }
            //Aqui empieza el ciclo para adivinar la palabra o la letra de la palabra
            do {
                System.out.println("La palabra que tenes que adivinar tiene " + palabraClave.length());
                System.out.println("Ingrese una palabra o una letra para adivinar palabra misteriosa");
                palabraBuscar = lector.nextLine();
                //para poner las parte del hombre ahorcado
                switch (nuFallos) {
                    case 1:
                        primeraOportunidad();
                        break;
                    case 2:
                        primeraOportunidad();
                        segundaOportunidad();
                        break;
                    case 3:
                        primeraOportunidad();
                        segundaOportunidad();
                        terceraOportunidad();
                        break;
                    case 4:
                        primeraOportunidad();
                        segundaOportunidad();
                        terceraOportunidad();
                        ultimaOportunidad();
                        break;
                    case 5:
                        primeraOportunidad();
                        segundaOportunidad();
                        terceraOportunidad();
                        ultimaOportunidad();
                        ceroOportunidades();
                        System.out.println("Has perdido  la palabra es: " + palabraClave);
                        break;
                }
                //Aqui empieza las comparaciones de letras
                if(palabraBuscar.length() == 1){
                    contDeFallas = 0;
                    for(int i = 0  ; i < palabraClave.length() ; i++){
                        if (palabraBuscar.charAt(0) == palabraClave.charAt(i)){
                                 contDeBuenas++;
                                 numLetras[i] = i;
                        }
                        else{
                            contDeFallas++;
                            if (contDeFallas == palabraClave.length()) {
                                nuFallos++;
                            }
                        }			
                    }
                }
                //Aqui empieza las comparaciones de palabras
                else{
                    if(palabraBuscar.equalsIgnoreCase(palabraClave) == true){
                        System.out.println("Has ganado!!!!!!, has salvado al hombre de ahorcarse :'V");
                        nuFallos = 6;
                    }
                    else{
                        nuFallos++;
                    }
                }
                if (contDeBuenas == palabraClave.length()) {
                    nuFallos = 6;
                    System.out.println("Has ganado!!!!!!, has salvado al hombre de ahorcarse :'V");
                }
                //Ciclo para mostrar las letras que hallan adivinado
                for (int i = 0; i < palabraClave.length(); i++) {
                    if (numLetras[i] == i) {
                        System.out.print(palabraClave.charAt(i));
                    }
                }
                System.out.println(" \n ");
                
            } while (nuFallos != 6);
            System.out.println("Quieres comensar de nuevo el juego?? S,n");
            continuar = lector.nextLine();
            limpiarPantalla();
        } while (continuar.charAt(0) == 'S');
    }
    public static void primeraOportunidad(){
        System.out.println("...........");
	System.out.println("         ..");
    }
    public static void segundaOportunidad(){
        System.out.println("      ........");
	System.out.println("      . x  x .");
	System.out.println("      .  __  .");
	System.out.println("      ........");
    }
    public static void terceraOportunidad(){
	System.out.println("         ..");
	System.out.println("    ............");
    }
    public static void ultimaOportunidad(){
	System.out.println("         ..");
	System.out.println("         ..");
	System.out.println("         ..");
    }
    public static void ceroOportunidades(){
	System.out.println("        .  .");
	System.out.println("       .    .");
    }
    
    public static void basketball(){
        String nombre1, nombre2;
        int orden, opcion1, opcion2;
        int punteo1, punteo2;
        do {
            System.out.println("El juego de basketball es un simulador de un partido uno a uno por turnos entre dos jugadores. Cada jugador puede hacer tiros y también hacer un movimientos de defensa. Durante 5 rondas");
            System.out.print("Ingrese nombre del jugador: ");
            nombre1 = lector.nextLine();
            System.out.print("Ingrese nombre del jugador: ");
            nombre2 = lector.nextLine();
            orden = numeroRandom(2);
            punteo1 = 0;
            punteo2 = 0;
            for (int rondas = 1; rondas <= 5; rondas++) {
                System.out.println("\n\nRonda numero " + rondas);
                //Aqui es la primera midad de n rondas
                if (orden == 1) {
                    System.out.println("Primer jugador: " + nombre1 + "  --------   Segundo jugador: " + nombre2);
                    System.out.println("    Punteo 1: " + punteo1 + "                     Punteo 2: " + punteo2 + "\n\n");
                }
                else{
                    System.out.println("Primer jugador: " + nombre2 + "  --------   Segundo jugador: " + nombre1);
                    System.out.println("    Punteo 1: " + punteo1 + "                     Punteo 2: " + punteo2 + "\n\n");
                }
                System.out.println("Opciones del juegador que ataka");
                System.out.println("1. Salto largo desde 5 metros, vale 3 puntos y la probabilidad de anotar es de 65%");
                System.out.println("2. Salto corto desde 3 metros, vale 2 puntos y la probabilidad de anotar es de 80%");
                opcion1 = Integer.valueOf(lector.nextLine());
        
                System.out.println("Opciones del juegador que defiende");
                System.out.println("1. Defensa cuerpo a cuerpo, reduce la probabilidad de anotar en un 15% y probabilidad de hacer falta del 35%");
                System.out.println("2. Defensa fuerte, reduce la probabilidad de anotar en un 30% y probabilidad de hacer falta del 65%");
                System.out.println("El Tiro libre del jugador que ataka, cuando el jugador que defiende hace una falta, vale 2 puntos y la probabilidad de anotar es de 90%");
                opcion2 = Integer.valueOf(lector.nextLine());
        
                if (opcion1 == 1) {
                    if (opcion2 == 1) {
                        if (numeroRandom(100) > 50) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 3 puntos el jugador que atako");
                            punteo1 = punteo1 + 3;
                        }
                        if (numeroRandom(100) <= 35) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo1 = punteo1 +2;
                            }
                        }
                    }
                    else if (opcion2 == 2){
                        if (numeroRandom(100) > 35) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 3 puntos el jugador que atako");
                            punteo1 = punteo1 + 3;
                        }
                        if (numeroRandom(100) <= 65) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo1 = punteo1 +2;
                            }
                        }
                    }
                }
                else if (opcion1 == 2){
                    if (opcion2 == 1) {
                        if (numeroRandom(100) > 65) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 2 puntos el jugador que atako");
                            punteo1 = punteo1 + 2;
                        }
                        if (numeroRandom(100) > 35) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo1 = punteo1 +2;
                            }
                        }
                    }
                    else if (opcion2 == 2){
                        if (numeroRandom(100) > 50) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 2 puntos el jugador que atako");
                            punteo1 = punteo1 + 2;
                        }
                        if (numeroRandom(100) > 65) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo1 = punteo1 +2;
                            }
                        }
                    }
                }
                //Aqui es la segunda medad de n rondas
                if (orden == 1) {
                    System.out.println("Primer jugador: " + nombre2 + "  --------   Segundo jugador: " + nombre1);
                    System.out.println("    Punteo 1: " + punteo2 + "                     Punteo 2: " + punteo1 + "\n\n");
                }
                else{
                    System.out.println("Primer jugador: " + nombre1 + "  --------   Segundo jugador: " + nombre2);
                    System.out.println("    Punteo 1: " + punteo2 + "                     Punteo 2: " + punteo1 + "\n\n");
                }
                System.out.println("Opciones del juegador que ataka");
                System.out.println("1. Salto largo desde 5 metros, vale 3 puntos y la probabilidad de anotar es de 65%");
                System.out.println("2. Salto corto desde 3 metros, vale 2 puntos y la probabilidad de anotar es de 80%");
                opcion1 = Integer.valueOf(lector.nextLine());
        
                System.out.println("Opciones del juegador que defiende");
                System.out.println("1. Defensa cuerpo a cuerpo, reduce la probabilidad de anotar en un 15% y probabilidad de hacer falta del 35%");
                System.out.println("2. Defensa fuerte, reduce la probabilidad de anotar en un 30% y probabilidad de hacer falta del 65%");
                System.out.println("El Tiro libre del jugador que ataka, cuando el jugador que defiende hace una falta, vale 2 puntos y la probabilidad de anotar es de 90%");
                opcion2 = Integer.valueOf(lector.nextLine());
        
                if (opcion1 == 1) {
                    if (opcion2 == 1) {
                        if (numeroRandom(100) > 50) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 3 puntos el jugador que atako");
                            punteo2 = punteo2 + 3;
                        }
                        if (numeroRandom(100) <= 35) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo2 = punteo2 +2;
                            }
                        }
                    }
                    else if (opcion2 == 2){
                        if (numeroRandom(100) > 35) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 3 puntos el jugador que atako");
                            punteo2 = punteo2 + 3;
                        }
                        if (numeroRandom(100) <= 65) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo2 = punteo2 +2;
                            }
                        }
                    }
                }
                else if (opcion1 == 2){
                    if (opcion2 == 1) {
                        if (numeroRandom(100) > 65) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 2 puntos el jugador que atako");
                            punteo2 = punteo2 + 2;
                        }
                        if (numeroRandom(100) > 35) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo2 = punteo2 +2;
                            }
                        }
                    }
                    else if (opcion2 == 2){
                        if (numeroRandom(100) > 50) {
                            System.out.println("A fallado el tiro");
                        }
                        else{
                            System.out.println("A anotado, recibe 2 puntos el jugador que atako");
                            punteo2 = punteo2 + 2;
                        }
                        if (numeroRandom(100) > 65) {
                            System.out.println("El jugador de la defensa saco una falta , un tiro libre para el otro jugador");
                            if (numeroRandom(100) > 90) {
                                System.out.println("A fallado el tiro libre");
                            }
                            else{
                                System.out.println("A anotado el tiro libre, recibe 2 puntos el jugador que atako");
                                punteo2 = punteo2 +2;
                            }
                        }
                    }
                }
            }
            //Para mostrar los punteos y el gandor al finalizar el simulador
            System.out.println("Fin del juego. Punteo final.");
            if (orden == 1) {
                System.out.println("Jugador " + nombre1 + ": " + punteo1 + "  --------   Jugador " + nombre2 + ": " + punteo2);
                System.out.print("El ganador es: ");
                if (punteo1 > punteo2) {
                    System.out.println(nombre1);
                }
                else if (punteo2 > punteo1){
                    System.out.println(nombre2);
                }
                else if (punteo1 == punteo2){
                    System.out.println("Han empatado");
                }
            }
            else if (orden == 2){
                System.out.println("Jugador " + nombre2 + ": " + punteo1 + "  --------   Jugador " + nombre1 + ": " + punteo2);
                System.out.print("El ganador es: ");
                if (punteo1 > punteo2) {
                    System.out.println(nombre2);
                }
                else if (punteo2 > punteo1){
                    System.out.println(nombre1);
                }
                else if (punteo1 == punteo2){
                    System.out.println("Han empatado");
                }
            }
            System.out.println("Quieres comensar de nuevo el juego?? S,n");
            continuar = lector.nextLine();
            limpiarPantalla();
        } while (continuar.charAt(0) == 'S');
    }
    
    public static int numeroRandom(int rango){
        Random ale = new Random();
        return ale.nextInt(rango)+1;    
    }
    
    public static void juegoDeCartas(){
        int dinero, apuesta;
        int primeraCarta, segundaCarta, terceraCarta;
        do {
            System.out.println("Bienvenido al juego de cartas consiste en que vas a ingresar una cantidad de dinero al principio del juego ya una ingresado el dinero te van a presentar dos cartas diferentes en lo cual tendras que apostar para ver si tercera carta este entre el rango de las primero dos cartas y si es haci ganar lo que apostarstes si no perdes lo que apostarstes.");
            System.out.print("Ingrese una cantidad inicial de dinero para poder apostar y iniciar el juego: $");
            dinero = Integer.valueOf(lector.nextLine());
            do {
                primeraCarta = numeroRandom(12);
                System.out.println("La primera carta tiene un valor de: " + primeraCarta);
                do {
                   segundaCarta = numeroRandom(12);
                } while (segundaCarta == primeraCarta);
                System.out.println("La segunda carta tiene un valor de: " + segundaCarta);
                System.out.print("Cuanto quiere apostar segun los valores de la primera y la segunda carta?? Dinero actual: " + dinero + "\n $");
                apuesta = Integer.valueOf(lector.nextLine());
                while (apuesta > dinero) {
                    System.out.println("NO TENES SUFICIENTE DINERO...........VUELVA A INTERTAR $_$. Dinero actual: " + dinero);
                    System.out.print("Cuanto quiere apostar segun los valores de la primera y la segunda carta?? \n $");
                    apuesta = Integer.valueOf(lector.nextLine());
                }
                do {
                    terceraCarta = numeroRandom(12);
                } while (terceraCarta == primeraCarta || terceraCarta == segundaCarta);
                System.out.println("La tercera carta tiene un valor de: " + terceraCarta);
                if (((primeraCarta < terceraCarta) && (terceraCarta < segundaCarta)) || ((primeraCarta > terceraCarta) && (terceraCarta > segundaCarta))){
                    dinero = dinero + apuesta;
                }
                else{
                    dinero = dinero - apuesta;
                }
                if (dinero>0) {
                    System.out.println("Dinero actual: $" + dinero + "\nQuieres continuar jugando?? S,n");
                    continuar = lector.nextLine();
                }
                else{
                    System.out.println("Dinero actual: $" + dinero);
                }
            } while (continuar.charAt(0) == 'S' && dinero > 0);
            System.out.println("Quieres comensar de nuevo el juego?? S,n");
            continuar1 = lector.nextLine();
            limpiarPantalla();
        } while (continuar1.charAt(0) == 'S');
    }
    
    public static void hanoi(){
        int dificultad;
        System.out.println("En este juego consistes en formar una torre en un palo vertical de 3 que hay, del disco mas grande al mas pequeño, ya que las reglas serian solo se puede mover un disco a la vez y no puede haber un disco grande ensima de uno pequeño, el juego cuenta con 9 niveles distintos de 2 discos hasta 10 discos.");
        System.out.println("Que grado de dificuldad lo quiere");
        System.out.println("2 discos");
        System.out.println("3 discos");
        System.out.println("4 discos");
        System.out.println("5 discos");
        System.out.println("6 discos");
        System.out.println("7 discos");
        System.out.println("8 discos");
        System.out.println("9 discos");
        System.out.println("10 discos");
        dificultad = Integer.valueOf(lector.nextLine());
        switch (dificultad) {
            case 2:
                nivel2();
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
        }
        
    }
    public static void nivel2(){
        String discos[];
        String palosVerticales[][];
        palosVerticales = new String[2][3];
        discos = new String[2];
        discos[0] = "   xx   ";
        discos[1] = "  xxxx  ";
        System.out.println("  1        2        3 ");
        
        
    }
    
}
