package com.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeClientes implements IGerenciadorClientes{
    private List<Cliente> clientes;

    public GerenciadorDeClientes(ArrayList<Cliente> clientes) {
        this.clientes =clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public String consultarCliente(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return clientes.get(i).getNome();
            }
        }
        return "Cliente não encontrado";
    }

}
