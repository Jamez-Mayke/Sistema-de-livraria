import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner leituraDados = new Scanner(System.in);

        Autor autor1 = new Autor("Aditya Y. Bhargava", new Date());
        Autor autor2 = new Autor("Robert C. Martin", new Date());

        biblioteca.adicionaAutor(autor1);
        biblioteca.adicionaAutor(autor2);
        
        Livro livro01 = new Livro(
            "Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos", 
            autor1
        );
        Livro livro02 = new Livro(
            "Código Limpo: Habilidades Práticas do Agile Software", 
            autor2
        );

        biblioteca.setLivro(livro01);
        biblioteca.setLivro(livro02);
 
        boolean continuar = true;
        while(continuar) {
            System.out.println("Bem vindo!");
            System.out.println("1 - Listar todos o Livros Disponíveis");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Listar todos os clientes");
            System.out.println("4 - Pegar emprestado um livro");
            System.out.println("5 - Histórico de emprestimos do livro");
            System.out.println("6 - Devolver livro");
            System.out.println("7 - Histórico dos empréstimos completo");
            System.out.println("8 - Cadastrar um novo livro");
            System.out.println("0 - Finalizar o sistema");

            System.out.print("Digite a opção desejada: ");
            String resposta = leituraDados.nextLine();

            switch (resposta) {
                case "1" -> {
                    List<Livro> livrosDisponiveis = biblioteca.listaLivrosDisponiveis();
                    if (livrosDisponiveis.isEmpty()) {
                        System.out.println("Não há livros disponíveis no momento!");
                    } else {
                        System.out.println(livrosDisponiveis);
                    }
                    break;
                }
                case "2" -> {
                    Cliente cliente = new Cliente();
                    System.out.print("Nome do Usuário: ");
                    String nome = leituraDados.nextLine();
                    cliente.setNome(nome);

                    System.out.print("Data de Nascimento: ");
                    String datanascimento = leituraDados.nextLine();
                    cliente.setDataNascimento(datanascimento);

                    System.out.print("Email: ");
                    String email = leituraDados.nextLine();
                    cliente.setEmail(email);

                    biblioteca.setCliente(cliente);
                    
                   break; 
                }
                case "3" -> {
                    System.out.println(biblioteca.getClientes());
                    break;
                }
                case "4" -> {
                    System.out.print("Informe o id do Livro: ");
                    String idLivro = leituraDados.nextLine();

                    Livro livroSelecionado = biblioteca.buscaLivroPorId(idLivro);
                    if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
                        System.out.print("Digite seu nome: ");
                        String nome = leituraDados.nextLine();

                        biblioteca.setEmprestimo(livroSelecionado, nome);
                        System.out.println(
                            "O livro: " + 
                            livroSelecionado.getTitulo() + 
                            " foi emprestado para: " + nome
                        );
                    }
                    break;
                }
                case "5" -> {
                    System.out.print("Informe o ID do livro: ");
                    String idlivro = leituraDados.nextLine();
                    System.out.println(biblioteca.getHistoricoEmprestimoLivro(idlivro));
                    break;
                }
                case "6" -> {
                    System.out.print("Informe o ID do livro: ");
                    String idlivro = leituraDados.nextLine();
                    biblioteca.devolverLivro(idlivro);
                    break;
                }
                case "7" -> {
                    System.out.println("Registro geral dos empréstimos:");
                    System.out.println(biblioteca.getRegistroDosEmprestimos());
                    break;
                }
                case "8" -> {
                    System.out.print("Nome do livro: ");
                    String nomeLivro = leituraDados.nextLine();

                    System.out.print("Nome do autor: ");
                    String nomeAutor = leituraDados.nextLine();

                    Autor autor = new Autor(nomeAutor, new Date());
                    Livro livro = new Livro(nomeLivro, autor);
                    biblioteca.setLivro(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                }
                case "0" -> {
                    continuar = false;
                    break;
                }
                default -> System.out.println("Comando inválido");
            }
        }

        leituraDados.close();
    }
}