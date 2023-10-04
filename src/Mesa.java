public class Mesa {

    private Garfo[] garfos;

    public Mesa() {
        garfos = new Garfo[5];
        for (int i = 0; i < 5; i++) {
            garfos[i] = new Garfo(i);
        }
    }

    public Garfo getGarfo(int id) {
        return garfos[id];
    }


}

