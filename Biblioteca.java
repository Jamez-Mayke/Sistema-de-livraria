import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Biblioteca {
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Livro> livros = new ArrayList<>();
    private final List<Autor> autores = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private final List<Emprestimo> registroDosEmprestimos = new ArrayList<>();

    public void setLivro(Livro livro) {
        this.livros.add(livro);
    }
    
    public List<Livro> getLivros() {
        return livros;
    }

    public List<Livro> listaLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public Livro buscaLivroPorId(String id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(UUID.fromString(id))) {
                return livro;
            }
        }
        return null;
    }

    public void atualizaTituloLivro(String id, String novoTitulo) {
        for (var livro : livros) {
            if (livro.getId().equals(UUID.fromString(id))) {
                livro.setTitulo(novoTitulo);
                break;
            }
        }
    }

    public void removerLivro(String id) {
        for(Livro livro : livros) {
            if (livro.getId().equals(UUID.fromString(id))) {
                livros.remove(livro);
            }
        }
    }

    public void adicionaAutor(Autor autor) {
       this.autores.add(autor);
    }

    public List<Autor> geAutors() {
        return autores;
    }

    public void atualizaNomeAutor(String id, String novoNome) {
        for (Autor autor : autores) {
            if (autor.getId().equals(UUID.fromString(id))) {
                autor.setNome(novoNome);
                break;
            }
        }
    }

    public void removerAutor(String id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(UUID.fromString(id))) {
                autores.remove(autor);
            }
        }
    }

    public void setEmprestimo(Livro livro, String nomeUsuario) {
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);

            for(Cliente cliente : clientes) {
                if (cliente.getNome().equals(nomeUsuario)) {
                    cliente.setEmprestimos(emprestimo);
                    emprestimos.add(emprestimo);
                    livro.setDisponivel(false);
                    registroDosEmprestimos.add(emprestimo);
                    break;
                }
            }
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
            registroDosEmprestimos.add(emprestimo);

        } else {
            System.out.println("Livro indisponível!");
        }
    }

    public void devolverLivro(String id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getId().equals(UUID.fromString(id)) && emprestimo.isAtivo()) {
                emprestimo.devolver();
                registroDosEmprestimos.add(emprestimo);
                break;
            }
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Emprestimo> getHistoricoEmprestimoLivro(String id) {
        List<Emprestimo> historicoLivroEmprestado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getId().equals(UUID.fromString(id))) {
                historicoLivroEmprestado.add(emprestimo);
            }
        }

        return historicoLivroEmprestado;
    }

    public List<Emprestimo> getRegistroDosEmprestimos() {
        return registroDosEmprestimos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
