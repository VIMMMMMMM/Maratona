public class Filosofo extends Thread {

    private final String nome;
    private final Garfo esquerdo;
    private final Garfo direito;

    private int vezesQueComeu = 0;
    private int vezesQuePensou = 0;

    public static volatile boolean executando = true;

    public Filosofo(String nome, int id, Mesa mesa) {
        this.nome = nome;
        this.esquerdo = mesa.getGarfo(id);
        this.direito = mesa.getGarfo((id) % 5);
    }

    public void run() {
        while (executando) {
            pensar();
            pegarGarfos();
            comer();
            devolverGarfos();
        }
    }

    public void pensar() {
        try {
            System.out.println(nome + " está pensando...");
            Thread.sleep((long) (Math.random()*10000));
            vezesQuePensou++;
        } catch (InterruptedException e) {
            // A thread foi interrompida, então vamos sair
        }
    }

    public void comer() {
        try {
            System.out.println(nome + " está comendo...");
            Thread.sleep((long) (Math.random() * 10000));
            vezesQueComeu++;
        } catch (InterruptedException e) {
            // A thread foi interrompida, então vamos sair
        }
    }

    public synchronized void pegarGarfos() {
        System.out.println(nome + " está tentando pegar os garfos...");
        esquerdo.pegar();
        direito.pegar();
        System.out.println(nome + " conseguiu pegar os garfos!");
    }

    public synchronized void devolverGarfos() {
        System.out.println(nome + " está devolvendo os garfos...");
        esquerdo.devolver();
        direito.devolver();
        System.out.println(nome + " devolveu os garfos!");
    }

    public int getVezesQueComeu() {
        return vezesQueComeu;
    }

    public int getVezesQuePensou() {
        return vezesQuePensou;
    }

    public String getNome() {
        return nome;
    }

}