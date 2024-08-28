import java.util.Date;
import java.util.UUID;

public class Livro {
    private final UUID id;
    private String titulo;
    private final Autor autor;
    private boolean disponivel;
    private final Date dataCadastro;
    private final Date dataAtualizacao;

    public Livro(String titulo, Autor autor) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = new Date();
        this.dataAtualizacao = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro{"+
        "id=" + getId() + ", " +
        "titulo=" + getTitulo() + ", " +
        "autor=" + getAutor() + ", " +
        "disponivel=" + isDisponivel() + ", " +
        "dataDeCadastro=" + getDataCadastro() + ", " +
        "ultimaAtualizacao=" + getDataAtualizacao() +
        "}";
    }

}