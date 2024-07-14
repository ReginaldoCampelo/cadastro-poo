/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastropoo;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author regin
 */
public class CadastroPOO {
    private static final int OPCAO_INCLUIR = 1;
    private static final int OPCAO_ALTERAR = 2;
    private static final int OPCAO_EXCLUIR = 3;
    private static final int OPCAO_EXIBIR_POR_ID = 4;
    private static final int OPCAO_EXIBIR_TODOS = 5;
    private static final int OPCAO_SALVAR_DADOS = 6;
    private static final int OPCAO_RECUPERAR_DADOS = 7;
    private static final int OPCAO_SAIR = 0;

    public static void main(String[] args) {
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case OPCAO_INCLUIR:
                    incluirPessoa(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_ALTERAR:
                    alterarPessoa(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_EXCLUIR:
                    excluirPessoa(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_EXIBIR_POR_ID:
                    exibirPorId(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_EXIBIR_TODOS:
                    exibirTodos(pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_SALVAR_DADOS:
                    salvarDados(pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_RECUPERAR_DADOS:
                    recuperarDados(pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case OPCAO_SAIR:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != OPCAO_SAIR);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("1. Incluir");
        System.out.println("2. Alterar");
        System.out.println("3. Excluir");
        System.out.println("4. Exibir pelo ID");
        System.out.println("5. Exibir todos");
        System.out.println("6. Salvar dados");
        System.out.println("7. Recuperar dados");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void incluirPessoa(Scanner scanner, PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        System.out.print("Tipo (1-Física, 2-Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        if (tipo == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
            pfRepo.inserir(pf);
        } else if (tipo == 2) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
            pjRepo.inserir(pj);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void alterarPessoa(Scanner scanner, PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        System.out.print("Tipo (1-Física, 2-Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        if (tipo == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            PessoaFisica pf = pfRepo.obter(id);
            if (pf != null) {
                System.out.println("Nome atual: " + pf.getNome());
                System.out.print("Novo nome: ");
                pf.setNome(scanner.nextLine());
                System.out.println("CPF atual: " + pf.getCpf());
                System.out.print("Novo CPF: ");
                pf.setCpf(scanner.nextLine());
                System.out.println("Idade atual: " + pf.getIdade());
                System.out.print("Nova idade: ");
                pf.setIdade(scanner.nextInt());
                scanner.nextLine();
                pfRepo.alterar(pf);
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            PessoaJuridica pj = pjRepo.obter(id);
            if (pj != null) {
                System.out.println("Nome atual: " + pj.getNome());
                System.out.print("Novo nome: ");
                pj.setNome(scanner.nextLine());
                System.out.println("CNPJ atual: " + pj.getCnpj());
                System.out.print("Novo CNPJ: ");
                pj.setCnpj(scanner.nextLine());
                pjRepo.alterar(pj);
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluirPessoa(Scanner scanner, PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        System.out.print("Tipo (1-Física, 2-Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        if (tipo == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (pfRepo.excluir(id)) {
                System.out.println("Pessoa física excluída com sucesso.");
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (pjRepo.excluir(id)) {
                System.out.println("Pessoa jurídica excluída com sucesso.");
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        System.out.print("Tipo (1-Física, 2-Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        if (tipo == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            PessoaFisica pf = pfRepo.obter(id);
            if (pf != null) {
                System.out.println(pf);
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            PessoaJuridica pj = pjRepo.obter(id);
            if (pj != null) {
                System.out.println(pj);
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodos(PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        System.out.println("Pessoas físicas:");
        for (PessoaFisica pf : pfRepo.obterTodos()) {
            System.out.println(pf);
        }
        System.out.println("Pessoas jurídicas:");
        for (PessoaJuridica pj : pjRepo.obterTodos()) {
            System.out.println(pj);
        }
    }

    private static void salvarDados(PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        try {
            pfRepo.persistir("pessoasFisicas.bin");
            pjRepo.persistir("pessoasJuridicas.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(PessoaFisicaRepo pfRepo, PessoaJuridicaRepo pjRepo) {
        try {
            pfRepo.recuperar("pessoasFisicas.bin");
            pjRepo.recuperar("pessoasJuridicas.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
}
