public class FuncionarioPadrao extends Funcionario {

    public FuncionarioPadrao(String nome, int matricula) {
        super(nome, matricula);
    }

    @Override
    public double calcularSalario() {
        return 0;
    }

    @Override
    public String gerarRelatorio() {
        return "Tipo: Funcionário Padrão\n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Salário: R$ " + calcularSalario() +
                "\n-----------------------";
    }
}