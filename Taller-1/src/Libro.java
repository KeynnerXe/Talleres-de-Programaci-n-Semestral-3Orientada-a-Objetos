/**
 *
 * @author Keinner Ramos
 */
public class Libro{
    private String titulo;
    private String autor;
    private int numeroPaginas;
   
        public Libro() {
            this.titulo = "Sin titulo";
            this.autor = "Sin autor";
            this.numeroPaginas = 0;
    }
    public Libro(String titulo, String autor, int numeroPagina) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPagina;
  }
    
    // Metodo toString
    @Override
    public String toString() {
        return "Libro: [Título: " + titulo + ", Autor: " + autor + ", Páginas: " + numeroPaginas + "]";
    }
 

    /* public void MostrarLibro() {
        System.out.println("Titulo: " + titulo);
        System.out.println("autor: " + autor);
        System.out.println("Numero de pagina: " + numeroPagina);
    }
    
    public static void main(String[] args) {
        Libro Lib = new Libro("2025" ,"Metamorphosis", 327);
        Lib.MostrarLibro();
    } */
}
