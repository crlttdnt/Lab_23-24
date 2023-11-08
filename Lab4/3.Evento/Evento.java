import java.sql.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;

import javax.swing.text.DateFormatter;

public class Evento {
    //OVERVIEW: classe Evento che modelli un evento di un calendario, definito da una data specificata e dal suo nome

    //attributi
    Date data;
    String nome;


    //costruttori
    public Evento(Date data, String nome) throws DataFormatException, IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto Evento tramite data e nome inseriti
        //se data è null o non valida lancia DateFormatException
        //se nome è null o vuoto lancia IllegalArgumentException

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("nome non valido");
        }

        if (data == null) {
            throw new DataFormatException("data non valida");
        }

        this.data = data;
        this.nome = nome;

    }


    //metodi
    public Date getData() {
        return data;
    }


    public String getNome() {
        return nome;
    }

    @Override
    public Object clone() {
        Evento nuovo = null;
        try {
            nuovo = (Evento) super.clone();
        } catch (CloneNotSupportedException e) {
            nuovo = new Evento(data, nome);
        }
        // Eventuali attributi mutabili devono essere clonati
        nuovo.data = (Date) data.clone();

        return nuovo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    public Evento copiaEvento(int n) throws IllegalArgumentException{
        //EFFECTS: crea un nuovo evento con lo stesso nome ma a n giorni di distanza
        //se n <=0 lancia IllegalArgumentException

        if (n<=0) {
            throw new IllegalArgumentException("inserire un numero positivo");
        }

        
        Evento nuovo = (Evento) this.clone();
        nuovo.data = new Date(nuovo.data.getTime() + TimeUnit.DAYS.toMillis(n));
        return nuovo;

    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       
        String[] pieces = s.next().split("/");

        Date data1 = new Date(Integer.parseInt(pieces[2]) - 1900,
                Integer.parseInt(pieces[1]),
                Integer.parseInt(pieces[0]));

        System.out.println("Inserisci nome del primo evento");
        String nome1 = s.next();

        System.out.println("Inserisci data del secondo evento");
        pieces = s.next().split("/");

        Date data2 = new Date(Integer.parseInt(pieces[2]) - 1900,
                Integer.parseInt(pieces[1]),
                Integer.parseInt(pieces[0]));

        System.out.println("Inserisci nome del secondo evento");
        String nome2 = s.next();

        try {
           Evento evento1 = new Evento(data1, nome1); 
        } catch (DataFormatException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        
        try {
           Evento evento2 = new Evento(data2, nome2); 
        } catch (DataFormatException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
       
        /*
        Evento evento1 = new Evento(data1, nome1);
        Evento evento2 = new Evento(data2, nome2);   
*/



        if (evento1.equals(evento2)) {
            System.out.println("I due eventi sono uguali");
       } else {
            System.out.println("I due eventi sono diversi");
       }

       int n;
       n = Integer.parseInt(s.next());
       Evento eventocopiato = new Evento(Date(1/1/01),"0");
       try {
           eventocopiato = evento1.copiaEvento(n);
       } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
       }
       System.out.println("Evento copiato: " + eventocopiato);
    }
}

    

    

