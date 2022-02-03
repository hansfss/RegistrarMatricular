/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.Calendar;

/**
 *
 * @author folke
 */
public class Fecha implements Comparable<Fecha> {
   private int dia;
   private int mes;
   private int año;
   private static int contFechas=0;
   private static int[] diasMeses={31,28,31,30,31,30,31,31,30,31,30,31};
   private static String[] nombreMeses={"Ene","Feb","Mar","Abr","May","Jun",
                                       "Jul","Ago","Sep","Oct","Npv","Dic"};


   public Fecha(){
      Calendar c= Calendar.getInstance();
      dia= c.get(Calendar.DAY_OF_MONTH);
      mes= c.get(Calendar.MONTH) + 1;
      año= c.get(Calendar.YEAR);
      contFechas++;
   }
   public Fecha(int d, int m, int a){
      dia= d;
      mes= m;
      año= a;
      if (!valida()){
          Calendar c= Calendar.getInstance();
          dia= c.get(Calendar.DAY_OF_MONTH);
          mes= c.get(Calendar.MONTH) + 1;
          año= c.get(Calendar.YEAR);
      }
      contFechas++;
   } 
   public Fecha(int d, int m){
      dia= d;
      mes= m;
      Calendar c= Calendar.getInstance();
      año= c.get(Calendar.YEAR);
      if (!valida()){
          dia= c.get(Calendar.DAY_OF_MONTH);
          mes= c.get(Calendar.MONTH) + 1;
      }
      contFechas++;
      
      
   } 
   public Fecha(int f) { //ddmmaaaa{  
      dia= f/1000000;
      mes= (f/10000)%100;
      año= f%10000;
      if (!valida()){
          Calendar c= Calendar.getInstance();
          dia= c.get(Calendar.DAY_OF_MONTH);
          mes= c.get(Calendar.MONTH) + 1;
          año= c.get(Calendar.YEAR);
      }
      contFechas++;
   }  
   public Fecha(String f){ //dd/mes/aaaa
          String [] datos= f.split("/");
          try{
               dia=Integer.parseInt(datos[0]);
               mes=Integer.parseInt(datos[1]);
               año=Integer.parseInt(datos[2]);
              
          }catch (NumberFormatException e){
              Calendar c= Calendar.getInstance();
              dia= c.get(Calendar.DAY_OF_MONTH);
              mes= c.get(Calendar.MONTH) + 1;
              año= c.get(Calendar.YEAR);
          }
          
          if (!valida())
          {
            Calendar c= Calendar.getInstance();
            dia= c.get(Calendar.DAY_OF_MONTH);
            mes= c.get(Calendar.MONTH) + 1;
            año= c.get(Calendar.YEAR);
          }
          contFechas++;
   }   
   public Fecha(Fecha f){
       dia= f.dia;
       mes= f.mes;
       año= f.año;
       contFechas++;
   }  
   public int getDia(){
       return dia;
   }   
   public int getMes() {
       return mes;
   }
   public int getAño(){
       return año;
   }
   public void setDia(int d){
       dia=d;    
   }
   public void setMes(int d){
       mes=d;    
   }
   public void setAño(int d){
       año=d;    
   }
   @Override
   public String toString(){
        String fecha=dia+"/"+mes+"/"+año;
        return fecha;
   }
  
   public void listar(){
       System.out.println(dia +"/"+mes + "/"+año);
   }
   
   
   public boolean valida(){
      if (mes < 1 || mes > 12){
          return false;
      }
      int diasDelMes;
      if (mes==2 && esBisiesto()){
          diasDelMes=29;
      }
      else{
          diasDelMes= diasMeses[mes-1];
      }
      return dia <= diasDelMes;
      
   }
   public boolean esBisiesto(){
       return (año%4==0 && año%100!=0) || (año%4==0 && año%100==0 && año%400==0);
           
    }
   
   public int compareTo(Fecha f){
       if (dia == f.dia && mes == f.mes && año == f.año){
           return 0;
       }
       else{
           if (año < f.año){
               return -1;
           }
           else if(mes < f.mes){
               return -1;
           }
           else if(dia < f.dia){
               return -1;
           }
           else{
               return 1;
           }
       }
   }
   
   @Override
    public boolean equals(Object f){
        Fecha fecha;
        if(f instanceof Fecha){
            fecha = (Fecha)f;
            return fecha.dia == dia && fecha.mes == mes && fecha.año == año;
        }
        return false;
    }
}
