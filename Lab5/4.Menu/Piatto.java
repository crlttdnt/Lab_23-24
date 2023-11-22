public class Piatto {
//OVERVIEW: classe non mutabile che rappresenta un piatto di un menu con il suo nome, tipo (primo, secondo), e costo 

//ATTRIBUTI
    private String nome, tipo;
    private int costo;

//COSTRUTTORI
public Piatto(String nome, String tipo, int costo) throws IllegalArgumentException, NullPointerException {
    //MODIFIES: this
    //EFFECTS: inizializza un piatto con nome, tipo e costo
    //         lancia IllegalArgumentException se tipo non è ne primo ne secondo, se costo <= 0 o se nome è vuoto
    //         lancia NullPointerException se tipo o nome sono nulli

    if(tipo == null || nome == null) {
        throw new NullPointerException("Gli elementi non possono essere nulli");
    }

    if (costo <= 0)
        throw new IllegalArgumentException("Costo non puo essere <= 0");

    if (nome.equals(""))
        throw new IllegalArgumentException("Nome non puo essere vuoto");
    
    if (!tipo.equals("primo") || !tipo.equals("secondo"))
        throw new IllegalArgumentException("Tipo deve essere o primo o secondo");

    this.nome = nome;
    this.tipo = tipo;
    this.costo = costo;

    assert repOk();

}

//METODI
public boolean repOk() {
    if (nome == null || tipo == null)
        return false;

    if (nome.equals(""))
        return false;

    if (!tipo.equals("primo") || !tipo.equals("secondo"))
        return false;

    if (costo <= 0)
        return false;

    return true;
}


public String getNome() {
    return nome;
}

public String getTipo() {
    return tipo;
}

public int getCosto() {
    return costo;
}

@Override
public String toString() {
    return this.nome + " " + this.tipo + " " + this.costo + "E";
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Piatto other = (Piatto) obj;
    if (nome == null) {
        if (other.nome != null)
            return false;
    } else if (!nome.equals(other.nome))
        return false;
    if (tipo == null) {
        if (other.tipo != null)
            return false;
    } else if (!tipo.equals(other.tipo))
        return false;
    if (costo != other.costo)
        return false;
    return true;
}

/*
 public Piatto copiaPiatto(int costo) throws IllegalArgumentException {
        // EFFECTS: ritorna un nuovo Piatto con costo = costo e gli altri parametri
        // uguali a this.
        // lancia IllegalArgumentException se costo <= 0
        if (costo <= 0)
            throw new IllegalArgumentException("Costo non valido (>0)");

        return new Piatto(this.nome, this.tipo, costo);
    }
 */


}
