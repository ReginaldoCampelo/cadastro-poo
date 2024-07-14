/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastropoo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author regin
 */
public class PessoaFisicaRepo {
    private List<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        this.pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }

    public void alterar(PessoaFisica pessoa) {
        int index = obterIndex(pessoa.getId());
        if (index != -1) {
            pessoasFisicas.set(index, pessoa);
        }
    }

    public boolean excluir(int id) {
        int index = obterIndex(id);
        if (index != -1) {
            pessoasFisicas.remove(index);
            return true;
        }
        return false;
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : pessoasFisicas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
        out.writeObject(pessoasFisicas);
        out.close();
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));
        pessoasFisicas = (List<PessoaFisica>) in.readObject();
        in.close();
    }

    private int obterIndex(int id) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
