import java.util.Arrays;
import java.util.Scanner;

public class Livro {
    private String nome;
    private String autor;
    private Generos genero;
    private int ano;
    private String isbn;
    private final long id;
    private static long proximoId = 1;  // Controla o próximo ID a ser atribuído

    public Livro(String nome, String autor, Generos genero, int ano, String isbn) {

        this.id = proximoId++;  // Atribui o próximo ID e incrementa para o próximo livro
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
    }

    public Livro() {
        this("", "", null, 0, "");  // Chama o construtor principal com valores padrão
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
    public Generos getGenero() { return genero; }

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
    public void setGenero(Generos genero) { this.genero = genero; }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + nome + ", Autor: " + autor +
                ", Ano: " + ano + ", ISBN: " + isbn;
    }


    public static Generos inputGenero(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o gênero do livro (" + Arrays.toString(Generos.values()) + "): "); //arrays.toSting converte o valor do enum Generos para uma string
        String genero = scanner.nextLine().toUpperCase(); // padronizando o input em caixa alta

        try {
            return Generos.valueOf(genero); // buscando no Enum Generos o valor do input genero
        } catch (IllegalArgumentException e) {
            System.out.println("Gênero não aceito pela biblioteca, definindo como OUTROS por padrão.");
            return Generos.OUTROS; // genero padrao
        }


    }

}