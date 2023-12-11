import java.text.NumberFormat;

public abstract class Utenza implements Comparable<Utenza> {
//OVERVIEW:Una singola Utenza telefonica è caratterizzata da un numero telefonico e dal nome dell'utente.
    
// attributi
    final String numero;
    final String nome;
    double durataChiamataEffettuata;

//costruttori
    public Utenza(String numero, String nome, double durataChiamataEffettuata) throws IllegalArgumentException, NullPointerException, NumberFormatException {
        //inizializza una nuova utenza
        //lancia IllegalArg se numero non ha esattamente 10 cifre
        //lancia NullPointerException se nome == null o vuoto
        // lancia IllegalArg se durata < 0
        
        if (nome == null || nome.equals("")) {
            throw new NullPointerException("Nome null o vuoto");
        }

        if (durataChiamataEffettuata < 0) {
            throw new IllegalArgumentException("Durata non puo essere negativa");
        }

        try {
            long n = parseLong.this.numero();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Numero non è composto da soli numeri");
        }

        if (numero.size() != 10) {
            throw new IllegalArgumentException("Numero non di 10 cifre");
        }

        this.numero = numero;
        this.nome = nome;
        this.durataChiamataEffettuata = durataChiamataEffettuata;

        assert repOk();
    }

//metodi
@Override 
public boolean repOk() {
    if (nome == null || nome.equals("")) {
        return false;
    }

    try {
        long n = Long.parseLong(this.numero());
    } catch (NumberFormatException e) {
        return false;
    }

    if (numero.length() != 10) 
        return false;

    if (durataChiamataEffettuata < 0) {
        return false;
    }

    return true;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Utenza other = (Utenza) obj;
    if (numero == null) {
        if (other.numero != null)
            return false;
    } else if (!numero.equals(other.numero))
        return false;
    return true;
}


public abstract void aumentaDurataChiamata(double tempo);

public abstract void reset();

@Override
public int compareTo(Utenza u) {
    //Le utenze sono naturalmente ordinate per la durata delle chiamate effettuate.
    if (this.durataChiamata < u.durataChiamata) {
        return -1;
    } else if (this.durataChiamata > u.durataChiamata)
        return 1;


    return 0;
}





/* @Override
protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
}*/


public String getNumero() {
    return numero;
}

public String getNome() {
    return nome;
}

public double getDurataChiamataEffettuata() {
    return durataChiamataEffettuata;
}

@Override
public String toString() {
    return "Utenza [numero=" + numero + ", nome=" + nome + ", durataChiamataEffettuata=" + durataChiamataEffettuata
            + "]";
}









}
