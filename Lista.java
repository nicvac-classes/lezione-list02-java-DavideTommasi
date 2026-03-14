public class Lista<T> {
    private Nodo<T> head;

    public Lista() {
    this.head = null;
    }

    public boolean isEmpty() {
    return head == null;

}

 /*
 METODO NON OTTIMIZATO
   public boolean isEmpty(){
   if (head==null){
   return true;
   }else{
    return false;
 }
}
*/

public void aggiungiInTesta(T dato) {
    Nodo<T> Nodo = new Nodo<>(dato);
    Nodo.next = head;
    head = Nodo;
}

public void aggiungiInCoda(T dato) {
    Nodo<T> Nodo = new Nodo<>(dato);
    
    if (head == null) {
        head = Nodo;
        return;
    }
    
    Nodo<T> curr = head;
    while (curr.next != null) {
        curr = curr.next;
    }
    curr.next = Nodo;
}
public void aggiungiInPosizione(T dato, int posizione) {
    if (posizione < 0) {
        System.out.println("posizione negativa ");  //throw new IndexOutOfBoundsException("Posizione negativa"); INDICA UN EVENTO 
    }
    
    if (posizione == 0) {
        aggiungiInTesta(dato);
        return;
    }
    
    Nodo<T> curr = head;
    int i = 0;
    
    while (curr != null && i < posizione - 1) {
        curr = curr.next;
        i++;
    }
    
    if (curr == null) {
        System.out.println("posizione oltre la lista ");  // throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
    }
    
    Nodo<T> Nodo = new Nodo<>(dato);
    Nodo.next = curr.next;
    curr.next = Nodo;
}
public T leggiTesta() {
    if (head == null) {
        throw new NoSuchElementException("Lista vuota");
    }
    return head.dato;
}
 
public T leggiTesta() {
    if (head == null) {
        throw new NoSuchElementException("la lista è vuota");
    }
    return head.dato;
}

public T leggiCoda() {
    if (head == null) {
        throw new NoSuchElementException("Lista vuota");
    }
    
    Nodo<T> curr = head;
    while (curr.next != null) {
        curr = curr.next;
    }
    return curr.dato;
}
public T leggiInPosizione(int posizione) {
    if (posizione < 0) {
        throw new IndexOutOfBoundsException("Posizione negativa");
    }
    
    Nodo<T> curr = head;
    int i = 0;
    
    while (curr != null && i < posizione) {
        curr = curr.next;
        i++;
    }
    
    if (curr == null) {
        throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
    }
    
    return curr.dato;
}





public int size() {
    int c = 0;
    Nodo<T> curr = head;
    
    while (curr != null) {
        c++;
        curr = curr.next;
    }
    
    return c;
}

public boolean contiene(T dato) {
    Nodo<T> curr = head;
    
    while (curr != null) {
        if (curr.dato.equals(dato)) {
            return true;
        }
        curr = curr.next;
    }
    
    return false;
}

public int indexOf(T dato) {
    Nodo<T> curr = head;
    int i = 0;
    
    while (curr != null) {
        if (curr.dato.equals(dato)) {
            return i;
        }
        curr = curr.next;
        i++;
    }
    
    return -1;
}
public boolean cancella(T dato) {
        if (head == null) {
            return false;
        }
        
        if (head.dato.equals(dato)) {
            head = head.next;
            return true;
        }
        
        Nodo<T> prec = head;
        Nodo<T> curr = head.next;
        
        while (curr != null) {
            if (curr.dato.equals(dato)) {
                prec.next = curr.next;
                return true;
            }
            prec = corrente;
            curr = corrente.next;
        }
        
        return false;
    }

 public T cancellaInPosizione(int pos) {
        if (pos < 0 || head == null) {
            throw new IndexOutOfBoundsException("posizione nn valida");
        }
        
        if (pos == 0) {
            T dato = head.dato;
            head = head.next;
            return dato;
        }
        
        Nodo<T> prec = head;
        int i = 0;
        
        while (prec.next != null && i < pos - 1) {
            prec = prec.next;
            i++;
        }
        
        if (prec.next == null) {
            throw new IndexOutOfBoundsException("posizione oltre la lista");
        }
        
        T dato = prec.next.dato;
        prec.next = prec.next.next;
        return dato;
    }

public void concatena(Lista<T> Lista2) {
    if (Lista2 == null || Lista2.head == null) {
        return;
    }
    
    if (head == null) {
        head = Lista2.head;
        return;
    }
    
    Nodo<T> curr = head;
    while (curr.next != null) {
        curr = curr.next;
    }
    curr.next = Lista2.head;
}

public String toString() {
    StringBuilder attributi = new StringBuilder();
    Nodo<T> curr = head;
    
    while (curr != null) {
        attributi.append(curr.dato);
        attributi.append(" -> ");
        curr = curr.next;
    }
    attributi.append("null");
    
    return attributi.toString();
}


}


}
