//LAS HERRAMIENTAS QUE NECESITA JAVA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BibliotecaBasica {
  public static void main(String[] args) {
    //PREPARA EL TECLADO PARA LEER
    Scanner teclado = new Scanner(System.in);

    //SON LOS DATOS QUE NECESITA PARA CONECTARSE CON POSTGRE
    String url = "jdbc:postgresql://localhost:5433/biblioteca";
    String usuario = "postgres";
    String clave = "colegio2026";

    try {
      Connection conexion = DriverManager.getConnection(url, usuario, clave);
      System.out.println("Conexion exitosa con PostgreSQL");

      Statement instruccion = conexion.createStatement();

      int opcion = 0;

      while (opcion != 3) {
        System.out.println("");
        System.out.println("=== BIBLIOTECA ESCOLAR ===");
        System.out.println("1. Agregar un libro nuevo");
        System.out.println("2. Ver todos los libros");
        System.out.println("3. Salir del programa");
        System.out.print("Elige una opcion (1-3): ");

        opcion = teclado.nextInt();
        teclado.nextLine();

        if (opcion == 1) {
          System.out.println("[Aqui ira el codigo para AGREGAR]");
        } else if (opcion == 2) {
          System.out.println("[Aqui ira el codigo para VER LIBROS]");
        } else if (opcion == 3) {
          System.out.println("Hasta luego! Guardando cambios...");
        } else {
          System.out.println("Opcion no valida. Por favor elige 1, 2 o 3.");
        }
      }

      conexion.close();

    } catch (Exception e) {
      System.out.println("Error de conexion: " + e.getMessage());
    }
  }
}