import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Mesa mesa = new Mesa();
        Filosofo[] filosofos = new Filosofo[5];

        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo("Filósofo " + i, i, mesa);
            executorService.execute(filosofos[i]);
        }

        Thread.sleep(40000);
        Filosofo.executando = false;

        executorService.shutdownNow();
        for (Filosofo filosofo : filosofos) {
            System.out.println("--------------------------------------------------\n "+filosofo.getNome()
                    + " comeu " + filosofo.getVezesQueComeu()
                    + " vezes e pensou " + filosofo.getVezesQuePensou() + " vezes.");        
        }

        exit(0);
    }
}