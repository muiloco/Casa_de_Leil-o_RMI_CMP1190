/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Fernando R
 */
public class CasaDeLeilao implements OperacoesCL, Serializable {

    private static final long serialVersionUID = 1L;
    ArrayList<Item> listaitens;

    public CasaDeLeilao() {
        this.listaitens = new ArrayList<>();
    }
    
    public void leiloarItem(String nome, double valor){
        Item novoItem = new Item(nome, valor);
        System.out.println(novoItem.toString());
        listaitens.add(novoItem);
    }
    
    @Override
    public void lance(String nomeItem, double valor) throws RemoteException {
        listaitens.stream().filter((item) -> (item.nomeProduto.equals(nomeItem))).forEachOrdered((item) -> {
            item.darLance(valor);
        });
    }

    @Override
    public Item resgatarItem(String nomeItem) throws RemoteException {
        for(Item item : listaitens){
            if(item.arremate)
                return item;
        }
        return null;
    }

    @Override
    public String listarItens() throws RemoteException {
        String statusCasaLeilao = "Lista de Itens:\n";
        statusCasaLeilao = listaitens.stream().filter((item) -> (item.arremate == false)).map((item) -> item.toString()).reduce(statusCasaLeilao, String::concat);
        return statusCasaLeilao;
    }
    
}
