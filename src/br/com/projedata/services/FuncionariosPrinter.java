package br.com.projedata.services;

import br.com.projedata.models.Funcionario;
import br.com.projedata.models.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FuncionariosPrinter {


    private final List<Funcionario> funcionarios;
    private final BigDecimal SALÁRIO_MINIMO = new BigDecimal("1212.00");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FuncionariosPrinter(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void exibirFuncionarios() {
        this.funcionarios.forEach( funcionario -> {
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("Data Nascimento: " + funcionario.getDataNascimento().format(formatter));
                    System.out.println("Função: " + funcionario.getFuncao());
                    System.out.println("Salário: " + this.formatarSalario(funcionario.getSalario()));
                    System.out.println("");
                }
        );
    }

    public  void exibirAniversariantes() {
        System.out.println("FUNCIONÁRIOS ANIVERSARIANTES: ");
        funcionarios.forEach(funcionario -> {
            int mesAniversarioFuncionario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversarioFuncionario == 10 || mesAniversarioFuncionario == 12) {
                System.out.println(funcionario);
            }
        });
    }

    public void exibirFuncionariosEmOrdemAlfabetica() {
        List<Funcionario> listaClone = new java.util.ArrayList<>(funcionarios.stream().toList());
        Collections.sort(listaClone, Comparator.comparing(Pessoa::getNome));
        System.out.println("");
        System.out.println("FUNCIONÁRIOS EM ORDEM ALFABÉTICA:");
        listaClone.forEach(funcionario -> {
            System.out.println("");
            System.out.println("NOME: " +funcionario.getNome());
            System.out.println("FUNÇÃO: " + funcionario.getFuncao());
            System.out.println("SALÁRIO: " + this.formatarSalario(funcionario.getSalario()));
            System.out.println("DATA NASCIMENTO: " + funcionario.getDataNascimento().format(formatter));

        });
    }


    public void exibirFuncionarioMaiorIdade() {
        int maiorIdade = 0;
        Funcionario funcionarioComMaiorIdade = null;
        for (Funcionario funcionario : funcionarios) {
            int anoAtual = LocalDateTime.now().getYear();
            int idadeFuncionario = anoAtual - funcionario.getDataNascimento().getYear();
            if (idadeFuncionario > maiorIdade) {
                maiorIdade = idadeFuncionario;
                funcionarioComMaiorIdade = funcionario;
            }
        }
        System.out.println("FUNCIONÁRIO COM MAIOR IDADE:");
        System.out.println("Nome:" + funcionarioComMaiorIdade.getNome());
        System.out.println("Idade:" + maiorIdade);

    }





    public void exibirTotalSalarioTodosFuncionarios() {
        BigDecimal soma = BigDecimal.ZERO;
        for (Funcionario funcionario : this.funcionarios) {
            soma = soma.add(funcionario.getSalario());
        }
        System.out.println("TOTAL SALARIO TODOS FUNCIONÁRIOS: " + formatarSalario(soma));
    }

    public void exibirQuantidadeSalarioMinimoPorFuncionario() {
        System.out.println("QUATIDADE SALARIOS MINIMOS POR FUNCIONÁRIO:");
        this.funcionarios.forEach(funcionario -> {
            System.out.println("");
            System.out.println("Funcionário: " + funcionario.getNome());
            System.out.println("Quantidade de salários minimos: " + funcionario.getSalario().divide(SALÁRIO_MINIMO, 0, RoundingMode.HALF_UP));
        });
    }


    private String formatarSalario(BigDecimal salario) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance();
        df.applyPattern("#,##0.00");
        var formato = df.format(salario);
        return "R$" + formato;
    }

}
