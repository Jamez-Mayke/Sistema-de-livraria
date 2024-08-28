
import java.util.Date;
import java.util.UUID;

public class Autor {
    private final UUID id;
    private String nome;
    private final Date dataNascimento;

    public Autor(String nome, Date dataNascimento) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor{" + 
        "id=" + getId() + ", " +
        "nome=" + getNome() + ", " +
        "dataNascimento=" + getDataNascimento() +
        "}";
    }
}
