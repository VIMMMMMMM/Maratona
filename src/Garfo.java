public class Garfo {

    private boolean livre;

    public Garfo(int id) {
        this.livre = true;
    }

    public synchronized void pegar() {
        while (!livre) {
            try {
                wait();
            } catch (InterruptedException e) {
                // A thread foi interrompida, então vamos sair
                return;
            }
        }
        livre = false;
    }

    public synchronized void devolver() {
        livre = true;
        notifyAll();
    }
}