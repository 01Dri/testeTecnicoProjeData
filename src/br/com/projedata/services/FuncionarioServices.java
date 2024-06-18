package br.com.projedata.services;

import br.com.projedata.models.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioServices {


    private List<Funcionario> funcionarios;

    public FuncionarioServices(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }


    public void aumentarSalarioFuncionariosPorPorcentagem(BigDecimal porcentagem) {
        funcionarios.forEach(funcionario -> {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(porcentagem.divide(BigDecimal.valueOf(100)));
            BigDecimal novoSalario = salarioAtual.add(aumento).setScale(2, RoundingMode.HALF_UP);
            funcionario.setSalario(novoSalario);
        });
    }

    public void  agruparFuncionariosPorFunções() {
        var agrupados =  funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        for (var valores : agrupados.entrySet()) {
            System.out.println("");
            System.out.println("FUNÇAO: " + valores.getKey());
            System.out.println("QUANTIDADE: " + valores.getValue().size());
            System.out.println("FUNCIONÁRIOS: " + valores.getValue());
        }
    }
}
