package code.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitacao {
    private final int id;
    private final String nome;
    private final TipoSolicitacao tipoSolicitacao;
    private final String descricao;
    private final LocalDateTime localDateTime = LocalDateTime.now();
    private LocalDateTime dataFinalizada;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss");
    private Status status = Status.ABERTO;

    public Solicitacao(String nome, TipoSolicitacao tipoSolicitacao, String descricao, int id) {
        this.nome = nome;
        this.tipoSolicitacao = tipoSolicitacao;
        this.descricao = descricao;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoSolicitacao=" + tipoSolicitacao +
                ", descricao='" + descricao + '\'' +
                ", localDateTime=" + localDateTime +
                ", status=" + status +
                '}';
    }

    public String toStringFinalizado() {
        return "Solicitacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoSolicitacao=" + tipoSolicitacao +
                ", descricao='" + descricao + '\'' +
                ", localDateTime=" + localDateTime +
                ", dataFinalizada=" + dataFinalizada +
                ", status=" + status +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(LocalDateTime dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public int getId() {
        return id;
    }
}
