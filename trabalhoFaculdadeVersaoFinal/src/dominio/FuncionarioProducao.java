package dominio;

public class FuncionarioProducao {

    String nome;
    String matricula;

    double salarioFixo = 2000;

    int quantidadePecas;
    double valorPeca;

    double produtividade;
    double salarioFinal;

    public FuncionarioProducao(String nome,
                               String matricula,
                               int quantidadePecas,
                               double valorPeca) {

        this.nome = nome;
        this.matricula = matricula;
        this.quantidadePecas = quantidadePecas;
        this.valorPeca = valorPeca;

        // calcula produtividade
        produtividade = quantidadePecas * valorPeca;

        // calcula salario final
        salarioFinal = salarioFixo + produtividade;
    }

    public void exibirResumo() {

        System.out.println("\n----- FUNCIONÁRIO PRODUÇÃO -----");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Fixo: " + salarioFixo);
        System.out.println("Produtividade: " + produtividade);
        System.out.println("Salário Final: " + salarioFinal);
    }
}

