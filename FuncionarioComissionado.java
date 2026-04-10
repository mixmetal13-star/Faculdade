public class FuncionarioComissionado extends Funcionario {

    private double valorVendas;
    private double percentualComissao;

    public FuncionarioComissionado(String nome, int matricula, double valorVendas, double percentualComissao) {
        super(nome, matricula);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        double comissao = valorVendas * (percentualComissao / 100);
        return SALARIO_BASE + comissao;
    }

    @Override
    public String gerarRelatorio() {
        return "Tipo: Funcionário Comissionado\n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Valor de vendas: " + valorVendas + "\n" +
                "Comissão (%): " + percentualComissao + "\n" +
                "Salário: R$ " + calcularSalario() +
                "\n-----------------------";
    }
}