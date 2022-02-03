/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGenericaArreglos;

import java.util.Iterator;

/**
 *
 * @author folke
 */
public class Lista<T> implements Iterable<T> {
    private T[] lista;
    private int tope; //Puntero al último elemento
    
    public Lista(){
        lista= (T[])new Object[50];
        tope=-1;
    }
    public Lista(int tamaño){
        lista= (T[])new Object[tamaño];
        tope=-1;
    }
    public String toString(){
        StringBuilder s= new StringBuilder();
        for(int i=0; i<=tope; i++){
            s.append(lista[i]+"\n");
        }
        
        return s.toString();
    }
    
    public int size(){
        return tope+1;
    }
    
    public boolean add(T e){
        boolean ok=false;
        if(tope< lista.length - 1){
            tope++;
            lista[tope]=e;
            ok=true;
        }
        return ok;
    }
    
    public boolean remove(T e){
        boolean encontrado=false;
        int i=0;
        while (i<=tope && !encontrado){// usamos boolean para dejar de recorrer cuando encontramos el elemento e
            if (e.equals(lista[i])){
                encontrado=true;
                //Desplazar
                for (int k=i; k<tope;k++){
                    lista[k]=lista[k+1];
                }
                tope--;//tope se reduce porque estamos eliminando un elemento
            }
            else{
                i++;
            }
            
        }
        return encontrado;

    }
    
    public void reset(){
        tope=-1;
    }
    
    //Elimina el último elementos ingresado
    public T remove(){
        T e= lista[tope];
        tope--;
        return e;
    }
    
    public boolean isEmpty(){
        return tope == -1;
    }
    
    //iTERABLE
    public Iterator<T> iterator(){
        return new MiClase();
    }
    
    private class MiClase implements Iterator<T>{
        private int actual;
        public MiClase(){
            actual=-1;
        }
        public boolean hasNext(){
            return actual<=tope;
        }
        public T next(){
            actual++;
            T e= lista[actual];
            return e;
        }
    }
    
}
