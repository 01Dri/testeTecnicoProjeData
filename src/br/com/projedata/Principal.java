package br.com.projedata;

import br.com.projedata.models.Funcionario;
import br.com.projedata.repository.FuncionarioRepository;
import br.com.projedata.services.FuncionarioServices;
import br.com.projedata.services.FuncionariosPrinter;

import java.math.BigDecimal;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        List<Funcionario> funcionarios = funcionarioRepository.getFuncionarios();
        FuncionariosPrinter funcionariosPrinter = new FuncionariosPrinter(funcionarios);
        FuncionarioServices funcionarioServices = new FuncionarioServices(funcionarios);

        funcionarioRepository.removerFuncionarioByNome("João");
        funcionariosPrinter.exibirFuncionarios();
        funcionarioServices.aumentarSalarioFuncionariosPorPorcentagem(BigDecimal.valueOf(10)); // 10 %
        System.out.println("FUNCIONÁRIOS APÓS REAJUSTE DO SALÁRIO: \n");
        funcionariosPrinter.exibirFuncionarios();
        System.out.println("FUNCIONÁRIOS AGRUPADOS POR FUNÇÕES: ");
        funcionarioServices.agruparFuncionariosPorFunções();
        System.out.println("");
        funcionariosPrinter.exibirAniversariantes();
        System.out.println("");
        funcionariosPrinter.exibirFuncionarioMaiorIdade();
        funcionariosPrinter.exibirFuncionariosEmOrdemAlfabetica();
        System.out.println("");
        funcionariosPrinter.exibirTotalSalarioTodosFuncionarios();
        System.out.println("");
        funcionariosPrinter.exibirQuantidadeSalarioMinimoPorFuncionario();



    }


}
