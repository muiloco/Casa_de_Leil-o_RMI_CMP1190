/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Fernando R
 */
public interface OperacoesCL extends Remote{
    public void lance(String nomeItem, double valor) throws RemoteException;
    public Item resgatarItem(String nomeItem) throws RemoteException;
    public String listarItens() throws RemoteException;
}
