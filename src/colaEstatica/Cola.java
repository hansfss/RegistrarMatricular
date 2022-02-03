/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaEstatica;

/**
 *
 * @author folke
 */
public class Cola<T> {
    private T[] lista;
    private int ini;
    private int fin;
    private int tamaño;
    
    public Cola(){
        tamaño=100;
        lista= (T[]) new Object[tamaño];
        ini=0;
        fin=tamaño-1;
    }
    
    public Cola(int t){
        tamaño=t;
        lista= (T[]) new Object[tamaño];
        ini=0;
        fin=tamaño-1;
    }
    
    public boolean add(T e){
        if (ini!= (fin+2)%tamaño){//para ver si la cola esta llena
            fin= (fin+1)%tamaño;
            lista[fin]=e;
            return true;
        }
        return false;
    }
    public T remove(){
        T e= lista[ini];
        ini= (ini+1)%tamaño;
        return e;
    }
    
    public boolean isEmpty(){
        return ini==(fin+1)%tamaño;
    }
    
    public String toString(){
        StringBuilder s=new StringBuilder();
        
        if (!isEmpty()){
            int p=ini;
            while (p!=fin){
                s.append(lista[p].toString()+"\n");
                p= (p+1)% tamaño;
            }
            s.append(lista[p].toString());
        }
        
        return s.toString();
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}
