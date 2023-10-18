import java.util.InputMismatchException;

public class CalcolatriceConMemoria {
//OVERVIEW: calcolatrice con uno stato in memoria al quale si possono apllicare operazioni aritmetiche di base
    
//attributi
    double mem;

//costruttori
    public CalcolatriceConMemoria() {
    //MODIFIES: this
    //EFFECTS: //EFFECTS: inizializza e restituisce una nuova CalcolatriceConMemoria, con stato = 0
        this.mem = 0;
    }

    public CalcolatriceConMemoria(double mem) {
    //MODIFIES: this
    //EFFECTS: inizializza e restituisce una nuova CalcolatriceConMemoria, con stato = mem
        this.mem = mem;         //this.mem è quello di sopra, mentre mem è quello della funzione!!

    }

//metodi
    public double getMem() {
        return mem;
    }

    public double add(double op2) {
    //MODIFIES: this
    //EFFECTS: imposta mem a op2 + this e restituisce il risultato
       return this.mem += op2;
    }

    public double sub(double op2) {
    //MODIFIES: this
    //EFFECTS: imposta mem a this - op2 e restituisce il risultato
        return this.mem -= op2;
    }
    
    
    public double mul(double op2) {
    //MODIFIES: this
    //EFFECTS: imposta mem a op2 * this e restituisce il risultato
        return this.mem *= op2;
    }

    public double div(double op2) throws DivideByZeroException {
    //MODIFIES: this
    //EFFECTS: imposta mem a this/op2 e restituisce il risultato
        // se op2 == 0 lancia DivideByZeroException
        
        if (op2 == 0) {
            throw new DivideByZeroException("Non è possibile dividere per zero");
        }
        return this.mem/=op2;
    }

    public double operate(char operator, double op2) throws InputMismatchException, DivideByZeroException {
    //MODIFIES: this
    //EFFECTS: imposta mem_post a risultato dell'operazione definita da operator tra mem e op2
    //  se operator != + - * / lancia InputMismatchException
    //  se operatori = / e op2 == 0 lancia DivideByZeroException

        switch(operator) {
            case '+':
                return this.add(op2);
            case '-':
                return this.sub(op2);
            case '*':
                return this.mul(op2);
            case '/':
                return this.div(op2);
            default:
                throw new InputMismatchException(operator + "!= + - * /");
        }

    }

}

