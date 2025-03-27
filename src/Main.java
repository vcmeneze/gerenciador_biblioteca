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
                    System.out.println("MENU PRINCIPAL");
                    System.out.println("1. Autor");
                    System.out.println("2. Ano de publicação");
                    System.out.println("3. Gênero");
                    System.out.println("4. ISBN");
                    System.out.println("5. Título");

                    int filtro = scanner.nextInt();
                    scanner.nextLine();

                    switch(filtro) {
                        case 1: {
                            System.out.println("Digite o nome do autor: ");
                            String search = scanner.nextLine();
                            biblioteca.stream()
                                    .filter(livro -> livro.getAutor().equals(search))
                                    .forEach(System.out::println);
                            break;
                        }

                        case 2: {
                            System.out.println("DIgite o ano de publicação: ");
                            String search = scanner.nextLine();

                            try {
                                int anoBusca = Integer.parseInt(search);
                                biblioteca.stream()
                                        .filter(livro -> livro.getAno() == anoBusca)
                                        .forEach(System.out::println);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro: o número não é válido");
                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Digite o genero desejado: ");
                            String search = scanner.nextLine().toUpperCase();

                            try {
                                Generos findGenero = Generos.valueOf(search);
                                biblioteca.stream()
                                        .filter(livro -> livro.getGenero() == findGenero)
                                        .forEach(System.out::println);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Gênero inválido! Use um dos valores: " + Arrays.toString(Generos.values()));
                            }
                            break;
                        }

                        case 4: {
                            System.out.println("Digite o ISBN que deseja buscar:");
                            String search = scanner.nextLine();
                            boolean encontrado = biblioteca.stream()
                                    .filter(livro -> livro.getIsbn().equals(search))
                                    .peek(System.out::println)
                                    .count() > 0;

                            if (!encontrado) {
                                System.out.println("Deseja buscar pelo ISBN na internet? (y/n)");
                                String resposta = scanner.nextLine();
                                switch (resposta) {
                                    case "y": {
                                        //integrar api que busque na internet o ISBN do livro
                                    }
                                    default: {
                                        break;
                                    }
                                }
                            }
                        }

                        case 5: {
                            System.out.println("Digite o nome do livro: ");
                            String search = scanner.nextLine();
                            boolean encontrado = biblioteca.stream()
                                    .filter(livro -> livro.getNome().equals(search))
                                    .peek(System.out::println)
                                    .count() > 0;

                            if (!encontrado) {
                                System.out.println("Deseja buscar pelo livro na internet? (y/n)");
                                String resposta = scanner.nextLine();
                                switch (resposta) {
                                    case "y": {
                                        //integrar api
                                    }
                                    default: {
                                        break;
                                    }
                                }
                            }
                        }
                    }

                }

                case 4: {
                    //remover livros
                }
            }
        } while (opcao !=5); //encerra a aplicação
        scanner.close();
    }
}