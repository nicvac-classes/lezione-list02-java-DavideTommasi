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
        System.out.println("posizione negativa ");  // throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
    }
    
    Nodo<T> Nodo = new Nodo<>(dato);
    Nodo.next = curr.next;
    curr.next = Nodo;
}

 }


}
