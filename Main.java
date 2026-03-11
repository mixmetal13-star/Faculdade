import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário Produção");
            System.out.println("4 - Mostrar Relatório");
            System.out.println("0 - Sair");

            opcao = lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    System.out.println("\nCadastro Funcionário Padrão");

                    String nome1 = lerNome(sc);
                    int mat1 = lerMatricula(sc, funcionarios);

                    funcionarios.add(new FuncionarioPadrao(nome1, mat1));

                    System.out.println("Funcionário cadastrado com sucesso.");

                    break;

                case 2:

                    System.out.println("\nCadastro Funcionário Comissionado");

                    String nome2 = lerNome(sc);
                    int mat2 = lerMatricula(sc, funcionarios);

                    double vendas = lerDoublePositivo(sc, "Valor das vendas: ");
                    double comissao = lerDoublePositivo(sc, "Percentual de comissão: ");

                    funcionarios.add(new FuncionarioComissionado(nome2, mat2, vendas, comissao));

                    System.out.println("Funcionário cadastrado com sucesso.");

                    break;

                case 3:

                    System.out.println("\nCadastro Funcionário Produção");

                    String nome3 = lerNome(sc);
                    int mat3 = lerMatricula(sc, funcionarios);

                    int pecas = lerInteiroPositivo(sc, "Quantidade de peças: ");
                    double valor = lerDoublePositivo(sc, "Valor por peça: ");

                    funcionarios.add(new FuncionarioProducao(nome3, mat3, pecas, valor));

                    System.out.println("Funcionário cadastrado com sucesso.");

                    break;

                case 4:

                    System.out.println("\n===== RELATÓRIO =====");

                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        for (Funcionario f : funcionarios) {
                            System.out.println(f.gerarRelatorio());
                        }
                    }

                    System.out.println("\nVoltando ao menu em 20 segundos...");

                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        System.out.println("Erro na pausa.");
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

    // -------- MÉTODOS DE VALIDAÇÃO --------

    static int lerInteiro(Scanner sc, String msg) {

        while (true) {

            try {

                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());

            } catch (Exception e) {

                System.out.println("Erro: digite um número inteiro válido.");

            }
        }
    }

    static int lerInteiroPositivo(Scanner sc, String msg) {

        int valor;

        do {

            valor = lerInteiro(sc, msg);

            if (valor < 0) {
                System.out.println("Erro: valor não pode ser negativo.");
            }

        } while (valor < 0);

        return valor;
    }

    static double lerDoublePositivo(Scanner sc, String msg) {

        double valor;

        while (true) {

            try {

                System.out.print(msg);
                valor = Double.parseDouble(sc.nextLine());

                if (valor < 0) {
                    System.out.println("Erro: valor não pode ser negativo.");
                } else {
                    return valor;
                }

            } catch (Exception e) {

                System.out.println("Erro: digite um número válido.");

            }
        }
    }

    static String lerNome(Scanner sc) {

        String nome;

        do {

            System.out.print("Nome: ");
            nome = sc.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.println("Erro: nome não pode ser vazio.");
            }

        } while (nome.trim().isEmpty());

        return nome;
    }

    static int lerMatricula(Scanner sc, ArrayList<Funcionario> funcionarios) {

        int matricula;

        while (true) {

            matricula = lerInteiro(sc, "Matrícula: ");

            if (matricula < 0) {

                System.out.println("Erro: matrícula não pode ser negativa.");
                continue;

            }

            boolean existe = false;

            for (Funcionario f : funcionarios) {

                if (f.matricula == matricula) {

                    existe = true;
                    break;

                }
            }

            if (existe) {

                System.out.println("Erro: matrícula já cadastrada.");

            } else {

                return matricula;

            }
        }
    }
}