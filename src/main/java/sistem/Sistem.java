package sistem;

import exeception.ArgumentoInvalidoException;
import model.Solicitacao;
import model.Status;
import model.TipoSolicitacao;

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
            solicitacoes.get(id - 1);
            if (solicitacoes.get(id - 1).getStatus() == Status.ABERTO) {
                solicitacoes.get(id - 1).setStatus(Status.EM_ANDAMENTO);
                System.out.println("Status atualizado de ABERTO para EM_ANDAMENTO");
            } else if (solicitacoes.get(id - 1).getStatus() == Status.EM_ANDAMENTO) {
                solicitacoes.get(id - 1).setStatus(Status.FINALIZADO);
                System.out.println("Status atualizado de EM_ANDAMENTO para FINALIZADO");
                Solicitacao solicitacao = solicitacoes.get(id - 1);
                solicitacoesFinalizado.add(solicitacao);
                System.out.println("Solicitação de ID-" + id + " foi FINALIZADA sendo retirada da fila de solicitações e adicionada ao histórico de solicitações disponível na função LISTAR");
                solicitacoes.remove(id - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
