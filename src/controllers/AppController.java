package controllers;

import entity.*;
import repository.AluguelRepository;
import repository.ClientePessoaFisicaRepository;
import repository.ClientePessoaJuridicaRepository;
import repository.VeiculoRepository;
import service.AluguelService;
import service.ClientePessoaFisicaService;
import service.ClientePessoaJuridicaService;
import service.VeiculoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppController {
    private final VeiculoService veiculoService;

    private final ClientePessoaFisicaService clientePessoaFisicaService;

    private final ClientePessoaJuridicaService clientePessoaJuridicaService;

    private final AluguelService aluguelService;
    private final Scanner scanner;

    private int tipoCadastro;
    public AppController() {
        this.aluguelService = new AluguelService(new AluguelRepository());
        this.clientePessoaFisicaService = new ClientePessoaFisicaService(new ClientePessoaFisicaRepository());
        this.clientePessoaJuridicaService = new ClientePessoaJuridicaService(new ClientePessoaJuridicaRepository());
        this.veiculoService = new VeiculoService(new VeiculoRepository());
        this.scanner = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("---LOCADORA DE VEÍCULOS---");
        System.out.println("Está acessando como:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionario");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção:");
    }
    public void menuTipoCliente(){
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção:");
    }
    public void menuCliente(){
        System.out.println("1 - Alugar um veículo");
        System.out.println("2 - Devolver um veículo");
        System.out.println("3 - Cadastrar um cliente");
        System.out.println("4 - Alterar um cliente");
        System.out.println("0 - Voltar");
        System.out.println("Escolha uma opção:");
    }
    public void menuFuncionario(){
        System.out.println("1 - Cadastrar um veículo");
        System.out.println("2 - Alterar um veículo");
        System.out.println("3 - Buscar um veículo");
        System.out.println("0 - Voltar");
        System.out.println("Escolha uma opção:");
    }


    public void executar(){
        int opcao;

        do {
            int opcaoCliente = 0;
            int opcaoFuncionario = 0;
            menu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1){
                menuTipoCliente();
                tipoCadastro = scanner.nextInt();
                do {
                    menuCliente();
                    opcaoCliente = scanner.nextInt();
                    scanner.nextLine();
                    verificaOpcaoCliente(opcaoCliente);
                }while (opcaoCliente != 0);
            } else if (opcao == 2) {
               do {
                   menuFuncionario();
                   opcaoFuncionario = scanner.nextInt();
                   scanner.nextLine();
                   verificaOpcaoFuncionario(opcaoFuncionario);
               }while (opcaoFuncionario != 0);
            }
        }while (opcao != 0);
    }

    public void verificaOpcaoCliente(int opcao){
        switch (opcao){
            case 1 -> alugarVeiculo();
            case 2 -> devolverVeiculo();
            case 3 -> cadastrarCliente();
            case 4 -> alterarCliente();
        }
    }
    public void verificaOpcaoFuncionario(int opcao){
        switch (opcao){
            case 1 -> cadastrarVeiculo();
            case 2 -> alterarVeiculo();
            case 3 -> buscarVeiculo();
        }
    }

    public void cadastrarVeiculo(){
        System.out.println("Placa do veículo:");
        String placa = scanner.nextLine();
        System.out.println("Modelo:");
        String modelo = scanner.nextLine();
        System.out.println("Ano do modelo:");
        int anoModelo = scanner.nextInt();
        System.out.println("Cor:");
        scanner.nextLine();
        String cor = scanner.nextLine();
        Veiculo veiculo = new Veiculo(modelo, placa, anoModelo, cor);
        System.out.println("Tamanho:");
        System.out.println("1 - Pequeno");
        System.out.println("2 - Medio");
        System.out.println("3 - SUV");
        System.out.println("Escolha uma opção: ");
        int opcaoTamanho = scanner.nextInt();
        switch (opcaoTamanho){
            case 1:
                veiculo.setTamanho(TamanhoVeiculo.PEQUENO);
                break;
            case 2:
                veiculo.setTamanho(TamanhoVeiculo.MEDIO);
                break;
            case 3:
                veiculo.setTamanho(TamanhoVeiculo.SUV);
                break;
        }
        if (veiculoService.buscaVeiculo(placa) == null){
            veiculoService.addVeiculo(veiculo);
            System.out.println("\nVeículo cadastrado com sucesso\n");
        }else {
            System.out.println("\nVeículo já existe.\n");
        }
    }
    public void alterarVeiculo(){
        System.out.println("Digite a placa do veículo que deseja alterar: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = veiculoService.buscaVeiculo(placa);
        if (veiculo!= null) {
            System.out.println("Digite o novo ano do modelo: ");
            int anoModelo = scanner.nextInt();
            System.out.println("Digite a nova cor do veículo:");
            scanner.nextLine();
            String cor = scanner.nextLine();
            veiculoService.alteraVeiculo(new Veiculo(veiculo.getModelo(), placa, anoModelo, cor));
            System.out.println("\nVeículo atualizado com sucesso.\n");
        }else {
            System.out.println("\nVeículo não encontrado.\n");
        }

    }

    public void buscarVeiculo(){
        System.out.println("Digite a placa do veículo que deseja consultar: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = veiculoService.buscaVeiculo(placa);
        if (veiculo == null){
            System.out.println("\nVeículo não econtrado\n");
        }else {
            System.out.println("\n" + veiculo + "\n");
        }
    }
    public void cadastrarCliente(){
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Idade");
        int idade = scanner.nextInt();
        scanner.nextLine();
        if (tipoCadastro == 1){
            System.out.println("CPF:");
            String cadastro = scanner.nextLine();
            if (clientePessoaFisicaService.buscaCliente(cadastro) == null){
                ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica(nome, idade, cadastro);
                clientePessoaFisicaService.addCliente(clientePessoaFisica);
                System.out.println("\nCliente adicionado com sucesso\n");
            }else {
                System.out.println("\nCPF já existe\n");
        }
        }else if(tipoCadastro == 2){
            System.out.println("CNPJ:");
            String cadastro = scanner.nextLine();
            if (clientePessoaJuridicaService.buscaCliente(cadastro) == null){
                ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica(nome, idade, cadastro);
                clientePessoaJuridicaService.addCliente(clientePessoaJuridica);
                System.out.println("\nCliente adicionado com sucesso\n");
            }else {
                System.out.println("\nCNPJ já existe\n");
        }
        }
    }

    public void alterarCliente(){
        System.out.println("Digite seu cadastro: ");
        String cadastro = scanner.nextLine();
        if (tipoCadastro == 1){
            if (clientePessoaFisicaService.buscaCliente(cadastro) == null){
                System.out.println("\nUsuário(CPF) não foi encontrado.\n");
                return;
            }
        } else if (tipoCadastro == 2) {
            if (clientePessoaJuridicaService.buscaCliente(cadastro) == null){
                System.out.println("\nUsuário(CNPJ) não foi encontrado.\n");
                return;
            }
        }
        System.out.println("Digite o novo nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite a nova idade:");
        int idade = scanner.nextInt();
        if (tipoCadastro == 1){
            clientePessoaFisicaService.alteraCliente(new ClientePessoaFisica(nome, idade, cadastro));
            System.out.println("\nCliente(CPF) alterado com sucesso.\n");
        }else if(tipoCadastro == 2){
            clientePessoaJuridicaService.alteraCliente(new ClientePessoaJuridica(nome, idade, cadastro));
            System.out.println("\nCliente(CNPJ) alterado com sucesso.\n");
        }
    }

    public void alugarVeiculo(){
        System.out.println("VEÍCULOS DA LOCADORA");
        System.out.println(veiculoService.listarVeiculo());
        System.out.println("Digite o seu cadastro:");
        String cadastro = scanner.nextLine();
        System.out.println("Digite a placa de um dos veículos que deseja alugar:");
        String placa = scanner.nextLine();
        System.out.println("Digite um local para alugar: ");
        String local = scanner.nextLine();
        System.out.println("Digite quando irá alugar: (dd/mm/yyyy hh:mm:ss)");
        LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("Digite a data que irá devolver: (dd/mm/yyyy hh:mm:ss)");
        LocalDateTime dataHoraDevolucao = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        Veiculo veiculo = veiculoService.buscaVeiculo(placa);
        Aluguel aluguel = new Aluguel(cadastro, veiculo, dataHora, dataHoraDevolucao, local);
        if (tipoCadastro == 1) {
            if (clientePessoaFisicaService.alugaVeiculoCpf(veiculo, cadastro)) {
                aluguelService.addAluguel(aluguel);
                System.out.println("\nVeiculo alugado com sucesso\n");
            } else {
                System.out.println("\nOcorreu um erro ao efetuar o aluguel, revise as informações\n");
            }
        }else {
            if (clientePessoaJuridicaService.alugaVeiculoCnpj(veiculo, cadastro)){
                aluguelService.addAluguel(aluguel);
                System.out.println("\nVeiculo alugado com sucesso\n");
            }else {
                System.out.println("\nOcorreu um erro ao efetuar o aluguel, revise as informações\n");
            }
        }
    }
    public void devolverVeiculo(){
        System.out.println("Digite a placa do veículo que deseja devolver: ");
        String placa = scanner.nextLine();
        Aluguel aluguel = aluguelService.buscaAluguel(placa);
        if (aluguel != null){
            Veiculo veiculo = veiculoService.buscaVeiculo(placa);
            System.out.println("Seu cadastro é " + aluguel.getCadastroAluguel() + " ?      1-Sim / 2-Nao");
            if (scanner.nextInt() == 1){
                aluguelService.devolucaoAluguel(placa, veiculo, tipoCadastro);
                System.out.println("\nDevolução feita com sucesso! O valor a pagar é de R$ " + aluguel.getValorDevolucao() + "\n");
            }else{
                System.out.println("\nDevolução cancelada\n");
            }
        }else {
            System.out.println("\nEste veículo não foi cadastrado ou alugado!\n");
        }
    }

}
