package teste;

import model.TipoSolicitacao;
import sistem.Sistem;

public class Teste {
    static void main(String[] args) {
        Sistem sistem = new Sistem();

        sistem.criarSolicitacao("Lucas", TipoSolicitacao.ACESSO_SISTEMA, "Acesso");
        sistem.criarSolicitacao("Teste", TipoSolicitacao.MANUTENCAO, "Teste");
        sistem.listar();
        sistem.atualizarStatus(1);
        sistem.listar();
        sistem.atualizarStatus(1);
        sistem.listar();
    }
}
