/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;

/**
 *
 * @author Fernando R
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    final int maxLances = 5;
    String nomeProduto;
    double precoProduto;
    double maiorLance;
    int qntLances;
    boolean arremate;

    public Item(String nomeProduto, double precoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.maiorLance = 0.0;
        this.qntLances = 0;
        this.arremate = false;
    }

    @Override
    public String toString() {
        String msg = "Nome do Produto: " + nomeProduto + "\n"
                + "Status: " + (arremate ? "Arrematado" : "Disponivel") + "\n"
                + "Preço: $" + precoProduto + "\n"
                + "Maior Lance: $" + maiorLance + "\n"
                + "Quantidade de Lances Dados no Item: " + qntLances + "\n\n";
        return msg;
    }

    public void darLance(double valor) {
        if (qntLances >= maxLances || arremate) {
            System.out.println("Item Vendido!!!");
            return;
        }
        if (valor >= precoProduto) {
            maiorLance = valor;
            qntLances++;
            arremate = true;
        } else if (valor > precoProduto) {
            maiorLance = valor;
            qntLances++;
            if (qntLances >= maxLances) {
                arremate = true;
            }
        }
    }

}
