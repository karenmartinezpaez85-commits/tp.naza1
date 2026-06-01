import java.sql.*;
import java.util.Scanner;

public class BibliotecaBasica {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    // 1. Datos para conectar a PostgreSQL
    String url = "jdbc:postgresql://localhost:5433/biblioteca";
    String usuario = "postgres";
    String clave = "colegio2026";

    try {
      // 2. Abrir conexión con la base de datos
      Connection conexion = DriverManager.getConnection(url, usuario, clave);
      Statement instruccion = conexion.createStatement();

      int opcion = 0;

      // 3. Menú que se repite hasta que elijan 3
      while (opcion != 3) {
        System.out.println("\n=== BIBLIOTECA ===");
        System.out.println("1. Agregar libro");
        System.out.println("2. Ver libros");
        System.out.println("3. Salir");
        System.out.print("Elige una opcion: ");

        opcion = teclado.nextInt();
        teclado.nextLine(); // Limpia el salto de línea que queda después del número

        if (opcion == 1) {
          // Pedir datos al usuario
          System.out.print("Titulo: ");
          String titulo = teclado.nextLine();

          System.out.print("Autor: ");
          String autor = teclado.nextLine();

          System.out.print("Año: ");
          int anio = teclado.nextInt();
          teclado.nextLine(); // Limpia buffer nuevamente

          // Crear comando SQL para guardar
          String sql = "INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('" + titulo + "', '" + autor + "', " + anio + ")";

          // Ejecutar guardado
          instruccion.executeUpdate(sql);
          System.out.println("✅ Libro agregado correctamente.");

        } else if (opcion == 2) {
          // Crear comando SQL para leer
          String sql = "SELECT * FROM libros";

          // Ejecutar lectura y guardar resultados
          ResultSet resultado = instruccion.executeQuery(sql);

          System.out.println("\n Libros en la base de datos:");

          // Recorrer cada fila encontrada
          while (resultado.next()) {
            System.out.println("ID: " + resultado.getInt("id") +
                    " | Titulo: " + resultado.getString("titulo") +
                    " | Autor: " + resultado.getString("autor") +
                    " | Año: " + resultado.getInt("anio_publicacion"));
          }

        } else if (opcion != 3) {
          System.out.println("⚠️ Opcion no valida. Intenta de nuevo.");
        }
      }

      // 4. Cerrar conexión al terminar
      conexion.close();
      System.out.println(" Programa finalizado.");

    } catch (Exception e) {
      // Si algo falla, mostrar mensaje simple
      System.out.println("❌ Error: " + e.getMessage());
    }
  }
}