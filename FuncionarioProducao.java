public class FuncionarioProducao extends Funcionario {

    private int quantidadePecas;
    private double valorPeca;

    public FuncionarioProducao(String nome, int matricula, int quantidadePecas, double valorPeca) {
        super(nome, matricula);
        this.quantidadePecas = quantidadePecas;
        this.valorPeca = valorPeca;
    }

    @Override
    public double calcularSalario() {
        return quantidadePecas * valorPeca;
    }

    @Override
    public String gerarRelatorio() {
        return "Tipo: Funcionário Produção\n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Peças produzidas: " + quantidadePecas + "\n" +
                "Valor por peça: " + valorPeca + "\n" +
                "Salário: R$ " + calcularSalario() +
                "\n-----------------------";
    }
}
