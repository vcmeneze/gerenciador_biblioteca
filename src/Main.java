import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void menuPrincipal(){
        System.out.println("Seja bem vindo ao gerenciador de biblioteca! O que deseja fazer hoje?");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Listar livros");
        System.out.println("3. Buscar livros");
        System.out.println("4. Remover livro");
        System.out.println("5. Encerrar");
    }
    public static void main(String[] args) {
        ArrayList <Livro> biblioteca = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        // executar a aplicação enquanto a opção de encerrar nao for selecionada
        do {
            menuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("Preencha as informações do livro que deseja adicionar:");
                    System.out.println("Título:");
                    String nome = scanner.nextLine();

                    System.out.println("Autor:");
                    String autor = scanner.nextLine();

                    Generos genero = Livro.inputGenero();

                    System.out.println("Ano de publicação:");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("ISBN do livro:");
                    String isbn = scanner.nextLine();

                    System.out.println("Informações inseridas pelo usuario:");
                    System.out.println("Título: " + nome);
                    System.out.println("Autor: " + autor);
                    System.out.println("Genero: " + genero);
                    System.out.println("Ano de publicação: " + ano);
                    System.out.println("ISBN: " + isbn);

                    biblioteca.add(new Livro(nome, autor, genero, ano, isbn));
                    System.out.println("Livro adicionado à biblioteca");
                    break;

                }
                case 2: {
                    if (biblioteca.isEmpty()) { // verifica se a biblioteca está vazia
                        System.out.println("Não há nada para mostrar aqui.");
                    } else {
                        for (Livro livro : biblioteca) {
                            System.out.println(livro);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Qual o filtro que deseja utilizar para buscar seu livro?");
                    System.out.println("1. Autor");
                    System.out.println("2. Ano de publicação");
                    System.out.println("3. Gênero");
                    System.out.println("4. ISBN");
                    System.out.println("5. Título");

                    int filtro = scanner.nextInt();
                    scanner.nextLine();

                    switch(filtro) {
                        case 1: {

                        }

                        case 2: {

                        }

                        case 3: {

                        }

                        case 4: {
                            System.out.println("Indique o número de ID do livro que deseja remover da lista: ");
                            int toRemove = scanner.nextInt();
                            scanner.nextLine();

                            // o bool removido será true se existir um livro com a ID enviada pelo usuário
                            boolean removido = biblioteca.removeIf(livro -> livro.getId() == toRemove);
                            if (removido) {
                                System.out.println("Livro removido!");
                            } else {
                                System.out.println("Não foi possível localilzar o livro com o id informado.");
                            }
                        }
                    }

                }
            }
        } while (opcao !=5); //encerra a aplicação
        scanner.close();
    }
}