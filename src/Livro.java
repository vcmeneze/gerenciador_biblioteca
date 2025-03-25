public class Livro {
    private String nome;
    private String autor;
    private String genero;
    private int ano;
    private String isbn;
    private final long id;
    private static long proximoId = 1;  // Controla o próximo ID a ser atribuído

    public Livro(String nome, String autor, String genero, int ano, String isbn) {
        this.id = proximoId++;  // Atribui o próximo ID e incrementa para o próximo livro
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
    }

    public Livro() {
        this("", "", "", 0, "");  // Chama o construtor principal com valores padrão
    }

    // Getters
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getAutor() {
        return autor;
    }
    public int getAno() {
        return ano;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenero() { return genero; }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setGenero(String genero) { this.genero = genero; }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + nome + ", Autor: " + autor +
                ", Ano: " + ano + ", ISBN: " + isbn;
    }
}