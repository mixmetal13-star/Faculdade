package dominio;

public class FuncionarioPadrao {

    String nome;
    String matricula;

    double salarioFixo = 2000;
    double extras = 0;
    double salarioFinal;

    public FuncionarioPadrao(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        salarioFinal = salarioFixo + extras;
    }

    public void exibirResumo() {

        System.out.println("\n----- FUNCIONÁRIO PADRÃO -----");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Fixo: " + salarioFixo);
        System.out.println("Extras: " + extras);
        System.out.println("Salário Final: " + salarioFinal);
    }
}
