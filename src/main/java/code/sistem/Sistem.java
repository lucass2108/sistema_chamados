package code.sistem;

import code.exeception.ArgumentoInvalidoException;
import code.model.Solicitacao;
import code.model.Status;
import code.model.TipoSolicitacao;

import java.util.ArrayList;
import java.util.List;

public class Sistem {
    private List<Solicitacao> solicitacoes = new ArrayList<>();
    private List<Solicitacao> solicitacoesFinalizado = new ArrayList<>();
    private int id = 1;

    public void criarSolicitacao(String nome, TipoSolicitacao tipoSolicitacao, String descricao) {
        if (nome == null)
            throw new ArgumentoInvalidoException("Declarar nome do solicitante");
        if (tipoSolicitacao == null)
            throw new ArgumentoInvalidoException("Declarar tipo de solicitação");
        if (descricao == null)
            throw new ArgumentoInvalidoException("A solicitação deve ter uma descrição precisa");

        Solicitacao temporario = new Solicitacao(nome, tipoSolicitacao, descricao, id);
        System.out.println(temporario);
        temporario = null;

        solicitacoes.add(new Solicitacao(nome, tipoSolicitacao, descricao, id));
        id++;
    }

    public void listar() {
        System.out.println("Em aberto");
        for (Solicitacao solicitacoe : solicitacoes) {
            System.out.println(solicitacoe);
        }

        System.out.println("Encerradas");
        for (Solicitacao solicitacao : solicitacoesFinalizado) {
            System.out.println(solicitacao.toStringFinalizado());
        }

    }

    public void atualizarStatus(int id) {
        try {
            for (Solicitacao solicitacoe : solicitacoes) {
                if (solicitacoe.getId() == id) {
                    switch (solicitacoe.getStatus()) {
                        case ABERTO:
                            solicitacoe.setStatus(Status.EM_ANDAMENTO);
                            System.out.println("Staus atualizado de ABERTO para EM_ANDAMENTO");
                            break;
                        case EM_ANDAMENTO:
                            solicitacoe.setStatus(Status.FINALIZADO);
                            System.out.println("Status atualizado de EM_ANDAMENTO para FINALIZADO");
                            System.out.println("Solicitação de ID-" + id + " foi FINALIZADA sendo retirada da fila de solicitações e adicionada ao histórico de solicitações disponível na função LISTAR");
                            solicitacoes.remove(solicitacoe);
                            solicitacoesFinalizado.add(solicitacoe);
                            break;
                        case FINALIZADO:
                            System.out.println("Solicitação já atendida");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atender, tente novamente mais tarde");
        }
    }
}
