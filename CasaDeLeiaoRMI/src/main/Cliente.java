/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Fernando R
 */
public class Cliente {

    private static final long serialVersionUID = 1L;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            CasaDeLeilao casaLeilao = (CasaDeLeilao) registry.lookup("CasaLeilao");
            System.out.println("Se deseja entrar na farra do leitão press S, se não press N");
            Scanner in = new Scanner(System.in);
            String resposta = in.nextLine();
            while (resposta.equals("S")) {
                System.out.println(casaLeilao.listarItens());
                System.out.println("Para dar um lance por Favor digite o Nome correto do Item:");
                in = new Scanner(System.in);
                String nomeItem = in.nextLine();
                System.out.println("Digite o Valor do Lance:");
                in = new Scanner(System.in);
                double valorLance = in.nextFloat();
                casaLeilao.lance(nomeItem, valorLance);
                System.out.println(casaLeilao.listarItens());
                System.out.println("Para Sair press N:");
                in = new Scanner(System.in);
                resposta = in.nextLine();
            }
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

}
