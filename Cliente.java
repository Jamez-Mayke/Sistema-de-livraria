import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente {
    private final UUID id;
    private String nome;
    private String dataNascimento;
    private String email;
    private final List<Emprestimo> emprestimos;

    public Cliente() {
        this.id = UUID.randomUUID();
        this.emprestimos = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void removeEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.remove(emprestimo);
    }

    public void setEmprestimos(Emprestimo emprestimos) {
        this.emprestimos.add(emprestimos);
    }

    @Override
    public String toString() {
        return "{" +
        "id: " + getId() + ", " +
        "nome: " + getNome() + ", " +
        "dataNascimento: " + getDataNascimento() + ", " +
        "email: " + getEmail() + ", " +
        "emprestimos:" + getEmprestimos() +
        "}";
    }

}
