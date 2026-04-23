package sistema.folhapagamento;

import dominio.FuncionarioComissionado;
import dominio.FuncionarioPadrao;
import dominio.FuncionarioProducao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // ===== MENU =====
    static void exibirMenu() {

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║      SISTEMA DE GESTÃO DE COLABORADORES  ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1 - Funcionário Padrão                  ║");
        System.out.println("║  2 - Funcionário Comissionado            ║");
        System.out.println("║  3 - Funcionário Produção                ║");
        System.out.println("║  4 - Mostrar Folha                       ║");
        System.out.println("║  0 - Sair                                ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("Selecione uma opção: ");
    }

    // ===== VALIDAR NOME =====
    static String lerNome(Scanner sc) {

        String nome;
        boolean valido;

        do {
            System.out.print("Nome: ");
            nome = sc.nextLine();
            valido = true;

            for (int i = 0; i < nome.length(); i++) {
                if (Character.isDigit(nome.charAt(i))) {
                    valido = false;
                }
            }

            if (!valido)
                System.out.println("Nome não pode conter números.");

        } while (!valido);

        return nome;
    }

    // ===== MATRÍCULA =====
    static String lerMatricula(Scanner sc) {

        String matricula;

        do {
            System.out.print("Matrícula: ");
            matricula = sc.nextLine();

            if (Integer.parseInt(matricula) <= 0)
                System.out.println("Matrícula deve ser positiva.");

        } while (Integer.parseInt(matricula) <= 0);

        return matricula;
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<FuncionarioPadrao> padrao = new ArrayList<>();
        ArrayList<FuncionarioComissionado> comissionado = new ArrayList<>();
        ArrayList<FuncionarioProducao> producao = new ArrayList<>();

        int opcao;

        do {

            exibirMenu();
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                // ================= PADRÃO =================
                case 1:

                    String nomeP = lerNome(sc);
                    String matP = lerMatricula(sc);

                    padrao.add(new FuncionarioPadrao(nomeP, matP));

                    System.out.println("Funcionário cadastrado!");
                    break;

                // ================= COMISSIONADO =================
                case 2:

                    String nomeC = lerNome(sc);
                    String matC = lerMatricula(sc);

                    System.out.print("Comissão: ");
                    double comissao = Double.parseDouble(sc.nextLine());

                    comissionado.add(
                            new FuncionarioComissionado(nomeC, matC, comissao)
                    );

                    System.out.println("Funcionário cadastrado!");
                    break;

                // ================= PRODUÇÃO =================
                case 3:

                    String nomePr = lerNome(sc);
                    String matPr = lerMatricula(sc);

                    System.out.print("Informe a quantidade de peças: ");
                    int quantidade = Integer.parseInt(sc.nextLine());

                    System.out.print("Informe o valor da peça: ");
                    double valorPeca = Double.parseDouble(sc.nextLine());

                    producao.add(
                            new FuncionarioProducao(
                                    nomePr,
                                    matPr,
                                    quantidade,
                                    valorPeca
                            )
                    );

                    System.out.println("Funcionário cadastrado!");
                    break;

                // ================= FOLHA =================
                case 4:

                    System.out.println("\n===== FOLHA DE PAGAMENTO =====");

                    for (FuncionarioPadrao f : padrao)
                        f.exibirResumo();

                    for (FuncionarioComissionado f : comissionado)
                        f.exibirResumo();

                    int i = 0;
                    while (i < producao.size()) {
                        producao.get(i).exibirResumo();
                        i++;
                    }

                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}

