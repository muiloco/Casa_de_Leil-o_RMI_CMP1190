/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Fernando R
 */
public class Server {
    public static void main(String[] args) {
        try {
            CasaDeLeilao casaleila = new CasaDeLeilao();
            System.out.println("Quantos Itens deseja cadastrar?\n");
            Scanner in = new Scanner(System.in);
            int nItens = in.nextInt();
            for (int i = 0 ; i < nItens ; i++){
                System.out.println("Nome do item " + i + ":");
                in = new Scanner(System.in);
                String nomeItem = in.nextLine();
                System.out.println("Valor do item " + i + ":");
                in = new Scanner(System.in);
                double valorItem = in.nextFloat();
                casaleila.leiloarItem(nomeItem, valorItem);
            }
            System.out.println(casaleila.listarItens());
            OperacoesCL stub = (OperacoesCL) UnicastRemoteObject.exportObject(casaleila, 0);
            Naming.rebind("rmi://localhost:1234/" + "CasaLeilao", stub);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
