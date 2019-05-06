/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

/**
 *
 * @author Fernando R
 */
public class Registro {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1234);
            System.out.println("Registro em execução!!!");
            new Scanner(System.in).next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
