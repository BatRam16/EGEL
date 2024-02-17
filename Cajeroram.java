package com.mycompany.cajeroram;
import java.util.Scanner;


public class Cajeroram {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta (180823,5000.00);
        Cajero cajero = new Cajero (cuenta);
        
        cajero.consultarSaldo();
        cajero.retiraDinero();
        
    }
    
    public static class Cuenta{
        
        public int numcuenta;
        public double saldo;
        
        public Cuenta (int numcuenta,double saldo){
            this.numcuenta = numcuenta;
            this.saldo = saldo;
        }
        
        public int getNumeroCuenta (){
            return numcuenta;
        }
        
        public void setNumeroCuenta(int numcuenta){
            this.numcuenta = numcuenta;
        }
        
        public double getSaldo(){
            return saldo;
        }
        
        public void setSaldo (double saldo){
            this.saldo = saldo;
        }
        
        public boolean Retiro(double monto){
            if (monto <= saldo){
                saldo -= monto;
                return true;
            }else {
                return false;
            }
        }
    }
    
    public static class Cajero {       
        public Cuenta cuenta;
        public Scanner scanner;
        
        public Cajero (Cuenta cuenta){
            this.cuenta = cuenta;
            this.scanner = new Scanner(System.in);
        }
        
        public void consultarSaldo (){
            System.out.println("Su saldo actual es: " + cuenta.getSaldo());
        }
        
        public boolean retiraDinero (){
            System.out.println("Introduzca el monto a retirar: ");
            double monto = scanner.nextDouble();
            if (cuenta.Retiro (monto)){
                System.out.println("Se ha retirado $" + monto + " exitosamente");
                System.out.println("Su nuevo saldo es: $" + cuenta.getSaldo());
            return true;
            }
            else {
                System.out.println ("Saldo insuficiente");
                return false;
            }
        }
    }
}