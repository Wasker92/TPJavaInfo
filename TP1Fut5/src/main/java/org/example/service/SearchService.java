package org.example.service;

import org.example.model.Equipo;
import org.example.model.Jugador;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SearchService {

    // BUSCADOR DE JUGADORES DONDE SE MUESTRA SU INFORMACION
    public static void buscarJugadorNombre(List<Equipo> equipos) {
        Scanner tecla = new Scanner(System.in);
        System.out.println("** BUSCAR JUGADOR POR NOMBRE **");

        System.out.print("Nombre del jugador: ");
        String nombreJugador = tecla.nextLine();

        boolean encontrado = false;

        for (Equipo equipo : equipos) {
            List<Jugador> jugadores = equipo.getPlayers();

            for (Jugador jugador : jugadores) {
                if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                    encontrado = true;
                    System.out.println("Nombre del jugador: " + jugador.getNombre() + " " + jugador.getApellido());
                    System.out.println("Equipo: " + equipo.getNombre());
                    System.out.println("Altura: " + jugador.getAltura());
                    System.out.println("Posicion: " + jugador.getPosicion());
                    System.out.println("Capitan: " + jugador.isEsCapi());
                    System.out.println("Numero de camiseta: " + jugador.getNumCami());
                    System.out.println("Cantidad de partidos jugados: " + jugador.getCantPart());
                    System.out.println("Cantidad de goles: " + jugador.getCantGoles());
                    System.out.println("ID: " + jugador.getId());
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro jugador!");
        }
    }

    // BUSCADOR DE EQUIPO DONDE SE MUESTRAN LOS JUGADORES ORDENADOS ALFABETICAMENTE
    public static void buscarEquipoNombre(List<Equipo> equipos) {
        Scanner tecla = new Scanner(System.in);
        System.out.println(" ** BUSCAR EQUIPO POR NOMBRE **");
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = tecla.nextLine();
        boolean encontrado = false;

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                encontrado = true;
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Fecha de creacion: " + equipo.getFechaCreacion());
                System.out.println("Nombre del entrenador: " + equipo.getEntrenador().getNombre() + " " +
                        equipo.getEntrenador().getApellido() + " Edad: " + equipo.getEntrenador().getEdad());
                System.out.println("Capitán del equipo: " + obtenerNombreCapitan(equipo));
                System.out.println("Lista de jugadores ordenados por nombre: ");

                List<Jugador> jugadores = equipo.getPlayers();
                jugadores.sort(Comparator.comparing(Jugador::getNombre));

                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.getNombre() + " " + jugador.getApellido());
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro equipo con ese nombre!");
        }
    }
    // OBTIENE EL NOMBRE DEL JUGADOR QUE ES CAPITAN DEL EQUIPO
    // SI EL EQUIPO NO TIENE CAPITAN ASIGNADO, DEVUELVE "NO HAY CAPITAN ASIGNADO"
    private static String obtenerNombreCapitan(Equipo equipo) {
        for (Jugador jugador : equipo.getPlayers()) {
            if (jugador.isEsCapi()) {
                return jugador.getNombre() + " " + jugador.getApellido();
            }
        }
        return "No hay capitan asignado!";
    }

    // BUSCADOR DE EQUIPOS DONDE SE ORDENA A LOS JUGADORES POR EL NUMERO DE CAMISETA
    public static void buscarEquipoCamiseta(List<Equipo> equipos) {
        Scanner tecla = new Scanner(System.in);
        System.out.println(" ** BUSCAR EQUIPO ORDENADO POR Nº CAMISETA **");
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = tecla.nextLine();
        boolean encontrado = false;

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                encontrado = true;
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Fecha de creacion: " + equipo.getFechaCreacion());
                System.out.println("Nombre del entrenador: " + equipo.getEntrenador().getNombre() + " " +
                        equipo.getEntrenador().getApellido() + " Edad: " + equipo.getEntrenador().getEdad());
                System.out.println("Lista de jugadores ordenados por su numero de camiseta: ");

                List<Jugador> jugadores = equipo.getPlayers();
                jugadores.sort(Comparator.comparingInt(Jugador::getNumCami));

                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.getNombre() + " " + jugador.getApellido() + " " +
                            jugador.getNumCami());
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun equipo con ese nombre!");
        }
    }

    // BUSCADOR QUE MUESTRA EL EQUIPO, NUMERO DE CAMISETA Y LA POSICION DE LOS JUGADORES
    public static void buscarEquipoPosicion(List<Equipo> equipos) {
        Scanner tecla = new Scanner(System.in);
        System.out.println(" ** BUSCAR EQUIPO ORDENADO POR Nº CAMISETA Y POSICION **");
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = tecla.nextLine();
        boolean encontrado = false;

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                encontrado = true;
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Fecha de creacion: " + equipo.getFechaCreacion());
                System.out.println("Nombre del entrenador: " + equipo.getEntrenador().getNombre() + " " +
                        equipo.getEntrenador().getApellido() + " Edad: " + equipo.getEntrenador().getEdad());
                System.out.println("Lista de jugadores ordenados por su numero de camiseta y por posicion: ");

                List<Jugador> jugadores = equipo.getPlayers();
                jugadores.sort(Comparator.comparing(Jugador::getPosicion).thenComparingInt(Jugador::getNumCami));

                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.getNombre() + " " + jugador.getApellido() + " -Camiseta: " +
                            jugador.getNumCami() + " -Posicion: " + jugador.getPosicion());
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun equipo con ese nombre!");
        }
    }
}