public abstract class Funcionario {

    protected String nome;
    protected int matricula;

    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public abstract double calcularSalario();

    public abstract String gerarRelatorio();
}