package br.com.projedata.repository;

import br.com.projedata.models.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    private final List<Funcionario> funcionarios = new ArrayList<>();


    public FuncionarioRepository() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Funcionario maria = new Funcionario("Maria", LocalDate.parse("18/10/2000", dtf), new BigDecimal("2009.44"), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.parse("12/05/1990", dtf), new BigDecimal("2284.38"), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.parse("02/05/1961", dtf), new BigDecimal("9836.14"), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.parse("14/10/1988", dtf), new BigDecimal("19119.88"), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.parse("05/01/1995", dtf), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.parse("19/11/1999", dtf), new BigDecimal("1582.72"), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.parse("31/03/1993", dtf), new BigDecimal("4071.84"), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.parse("08/07/1994", dtf), new BigDecimal("3017.45"), "Gerente");
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.parse("24/05/2003", dtf), new BigDecimal("1606.85"), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.parse("02/09/1996", dtf), new BigDecimal("2799.93"), "Gerente");

        funcionarios.add(maria);
        funcionarios.add(joao);
        funcionarios.add(caio);
        funcionarios.add(miguel);
        funcionarios.add(alice);
        funcionarios.add(heitor);
        funcionarios.add(arthur);
        funcionarios.add(laura);
        funcionarios.add(heloisa);
        funcionarios.add(helena);
    }

    public boolean addFuncionario(Funcionario funcionario) {
        return this.funcionarios.add(funcionario);
    }


    public void removerFuncionarioByNome(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

}
