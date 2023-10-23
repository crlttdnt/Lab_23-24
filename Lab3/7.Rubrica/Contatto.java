import java.util.IllegalFormatWidthException;

public class Contatto {
    String nome, cognome;
    String numeroTelefono; //facoltativo
    String mail; //facoltativo

    //Costruttori

    public Contatto(String nome, String cognome) throws IllegalArgumentException {
        //Effects: istanzia un nuovo contatto
        //lancia IllegalArgument Exception se nome e cognome sono nulli o vuoti
        
        if (nome == null || nome.equals("") || cognome == null || cognome.equals("")) {
            throw new IllegalArgumentException("Gli argomenti non possono essere vuoti o nulli");
        }

        this.nome = nome;
        this.cognome = cognome;
    }

    public Contatto(String nome, String cognome, String numeroTelefono, String mail) throws IllegalArgumentException {
        //Effects: istanzia un nuovo contatto
        //lancia IllegalArgument Exception se nome e cognome sono nulli o vuoti, accetta che mail e telefono siano vuoti
        if (nome == null || nome.equals("") || cognome == null || cognome.equals("")) {
            throw new IllegalArgumentException("Gli argomenti non possono essere vuoti o nulli");
        }

        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        this.mail = mail;
    }

//metodi
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome == "") {
            throw new IllegalArgumentException("Gli argomenti non possono essere vuoti o nulli");
        }
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) throws IllegalArgumentException {
        if (cognome == null || cognome == "") {
            throw new IllegalArgumentException("Gli argomenti non possono essere vuoti o nulli");
        }
        this.cognome = cognome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + numeroTelefono + " " + mail;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contatto other = (Contatto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (numeroTelefono == null) {
            if (other.numeroTelefono != null)
                return false;
        } else if (!numeroTelefono.equals(other.numeroTelefono))
            return false;
        if (mail == null) {
            if (other.mail != null)
                return false;
        } else if (!mail.equals(other.mail))
            return false;

        return true;
    }

    

    


}