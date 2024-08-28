import java.util.Date;
import java.util.UUID;

public class Emprestimo {
    private final UUID id;
    private String nomeUsuario;
    private Livro livro;
    private boolean ativo;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Livro livro, String nomeUsuario) {
        this.id = UUID.randomUUID();
        this.nomeUsuario = nomeUsuario;
        this.livro = livro;
        this.dataEmprestimo = new Date();
        this.dataDevolucao = new Date();
        this.ativo = true;
    }

    public UUID getId() {
        return id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void devolver() {
        this.dataDevolucao = new Date();
        this.ativo = false;
        this.livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
        "id=" + getId() + ", " +
        "nome=" + getNomeUsuario() + ", " +
        "livro=" + getLivro() + ", " +
        "dataEmprestimo=" + getDataEmprestimo() + ", " +
        "dataDevolucao=" + getDataDevolucao() + ", " +
        "ativo=" + isAtivo() +
        "}";
    }
}
