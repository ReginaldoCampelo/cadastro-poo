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
public class PessoaJuridicaRepo {
    private List<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        pessoasJuridicas.add(pessoa);
    }

    public void alterar(PessoaJuridica pessoa) {
        int index = obterIndex(pessoa.getId());
        if (index != -1) {
            pessoasJuridicas.set(index, pessoa);
        }
    }

    public boolean excluir(int id) {
        int index = obterIndex(id);
        if (index != -1) {
            pessoasJuridicas.remove(index);
            return true;
        }
        return false;
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : pessoasJuridicas) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
        out.writeObject(pessoasJuridicas);
        out.close();
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));
        pessoasJuridicas = (List<PessoaJuridica>) in.readObject();
        in.close();
    }

    private int obterIndex(int id) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
