import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BibliotecaBasica {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

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
          System.out.println("--- AGREGAR NUEVO LIBRO ---");

          System.out.print("Titulo del libro: ");
          String titulo = teclado.nextLine();

          System.out.print("Autor: ");
          String autor = teclado.nextLine();

          System.out.print("Anio de publicacion: ");
          int anio = teclado.nextInt();
          teclado.nextLine();

          String sql = "INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('" +
                  titulo + "', '" + autor + "', " + anio + ")";

          instruccion.executeUpdate(sql);

          System.out.println("Libro guardado con exito");


        } else if (opcion == 2) {
          System.out.println("");
          System.out.println("=== LISTA DE LIBROS ===");

          // 1. Creamos el comando SQL para seleccionar TODO
          String sql = "SELECT * FROM libros";

          // 2. Ejecutamos la consulta y guardamos los resultados
          ResultSet resultado = instruccion.executeQuery(sql);

          // 3. Recorremos cada fila encontrada
          while (resultado.next()) {
            // Obtenemos cada columna de la fila actual
            int id = resultado.getInt("id");
            String tit = resultado.getString("titulo");
            String aut = resultado.getString("autor");
            int an = resultado.getInt("anio_publicacion");

            // Mostramos la información del libro
            System.out.println("ID: " + id + " | Titulo: " + tit +
                    " | Autor: " + aut + " | Anio: " + an);
          }

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