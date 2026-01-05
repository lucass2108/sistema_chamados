package code.main;

import code.exeception.ArgumentoInvalidoException;
import code.model.TipoSolicitacao;
import code.sistem.Sistem;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistem sistem = new Sistem();
        int opcao = 15;

        System.out.println("======SEJA BEM-VINDO(A) AO SISTEMA DE CADASTRO DE CHAMADOS=====");

        do {
            System.out.println("Escolha sua opção");
            System.out.println("1- Criar chamado | 2- Listar Chamados | 3- Atender Chamando | 0 - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o seu nome completo: ");
                        String nome = scanner.nextLine();

                        System.out.println("Qual o tipo do chamado? (MATERIAL/MANUTENCAO/ACESSO_SISTEMA/OUTROS)");
                        String tipo = scanner.nextLine();
                        TipoSolicitacao tipoSolicitacao = TipoSolicitacao.valueOf(tipo.toUpperCase());

                        System.out.println("Descreva seu problema:");
                        String desc = scanner.nextLine();

                        System.out.println("Solicitaçõa de abertura de chamado concluída");

                        sistem.criarSolicitacao(nome, tipoSolicitacao, desc);

                        break;
                    case 2:
                        sistem.listar();
                        break;
                    case 3:
                        System.out.println("Digite o ID do chamado a ser atendido: ");
                        int in = scanner.nextInt();
                        scanner.nextLine();

                        sistem.atualizarStatus(in);

                        break;
                    default:
                        throw new ArgumentoInvalidoException("Opção inválida");
                }

            } catch (Exception exception) {
                System.out.println("Erro");
                scanner.nextLine();
            }

        } while (opcao != 0);
        System.out.println("Programa encerrado");
    }
}
