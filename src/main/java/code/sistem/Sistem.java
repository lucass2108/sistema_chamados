package code.sistem;

import code.exeception.ArgumentoInvalidoException;
import code.model.Solicitacao;
import code.model.Status;
import code.model.TipoSolicitacao;

import java.util.ArrayList;
import java.util.Iterator;
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
            Iterator<Solicitacao> solicitacaoIterator = solicitacoes.iterator();

            while (solicitacaoIterator.hasNext()) {
                Solicitacao solicitacao = solicitacaoIterator.next();

                if (solicitacao.getId() == id) {
                    switch (solicitacao.getStatus()) {
                        case ABERTO:
                            solicitacao.setStatus(Status.EM_ANDAMENTO);
                            System.out.println("Status atualizado de ABERTO para EM_ANDAMENTO");
                            break;
                        case EM_ANDAMENTO:
                            solicitacao.setStatus(Status.FINALIZADO);
                            System.out.println("Status atualizado de EM_ANDAMENTO para FINALIZADO");
                            System.out.println("Solicitação de ID-" + id + " foi FINALIZADA sendo retirada da fila de solicitações e adicionada ao hitórico disponível na função LISTAR");

                            solicitacaoIterator.remove();
                            solicitacoesFinalizado.add(solicitacao);
                            break;
                        case FINALIZADO:
                            System.out.println("Solicitaçõa já atendida");
                            break;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //formatações únicas
}
