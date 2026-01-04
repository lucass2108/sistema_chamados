package model;

import java.time.LocalDateTime;

public class solicitacao {
    private int id;
    private String nome;
    private TipoSolicitacao tipoSolicitacao;
    private String descricao;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public solicitacao(String nome, TipoSolicitacao tipoSolicitacao, String descricao) {
        this.nome = nome;
        this.tipoSolicitacao = tipoSolicitacao;
        this.descricao = descricao;
    }
}
