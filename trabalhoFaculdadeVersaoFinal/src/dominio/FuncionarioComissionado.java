package dominio;

public class FuncionarioComissionado {

    String nome;
    String matricula;

    double salarioFixo = 2000;
    double comissao;
    double salarioFinal;

    public FuncionarioComissionado(String nome, String matricula, double comissao) {

        this.nome = nome;
        this.matricula = matricula;
        this.comissao = comissao;

        salarioFinal = salarioFixo + comissao;
    }

    public void exibirResumo() {

        System.out.println("\n----- FUNCIONÁRIO COMISSIONADO -----");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Fixo: " + salarioFixo);
        System.out.println("Comissão: " + comissao);
        System.out.println("Salário Final: " + salarioFinal);
    }
}
