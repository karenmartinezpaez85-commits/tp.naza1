//1importar las herramientas (que necesita java)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class BibliotecaBasica {
  public static void main (string[]args) {
    //preparar el teclado (aca empieza el prgrama)
    scanner teclado = new scanner (system.in);
    //los datos que se necesita para conectarse con postgre
    string url = ¨jdbc:postgresql://localhost:5433/biblioteca_libros¨;
    string usuario = ¨postgres¨;
    string clave = ¨colegio2026¨;
    try {
      // Abrir la conexión con la base de datos
      Connection conexion = DriverManager.getConnection(url, usuario, clave);
      System.out.println("✅ ¡Conexión exitosa con PostgreSQL!");

      // lo que enviará las órdenes SQL
      Statement instruccion = conexion.createStatement();

      int opcion = 0;  // Variable para guardar lo que elige el usuario

      // while = "mientras". Se repite MIENTRAS la opción NO sea 3
      while (opcion != 3) {
        System.out.println("\n📚 === BIBLIOTECA ESCOLAR ===");
        System.out.println("1. Agregar un libro nuevo");
        System.out.println("2. Ver todos los libros");
        System.out.println("3. Salir del programa");
        System.out.print("👉 Elige una opción (1-3): ");

        opcion = teclado.nextInt();  // Lee el número que escribe el usuario
        teclado.nextLine();          // LIMPIA EL ENTER RESIDUAL

        if (opcion == 1) {
          System.out.println("📝 [Aquí irá el código para AGREGAR]");
        } else if (opcion == 2) {
          System.out.println(" [Aquí irá el código para VER LIBROS]");
        } else if (opcion == 3) {
          System.out.println(" ¡Hasta luego! Guardando cambios...");
        } else {
          System.out.println("⚠️ Opción no válida. Por favor elige 1, 2 o 3.");
        }
      }

    } catch (Exception e) {
      // por Si algo falla (ej: contraseña incorrecta) se muestra el error
      System.out.println("❌ Error de conexión: " + e.getMessage());

    }
  }
}
