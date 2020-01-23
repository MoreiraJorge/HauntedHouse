package HauntedHouse.MapDefinitions;

/**
 * map definition class
 * @author Jorge, Miguel
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class map {

    private String title;
    private int points;
    //private NetworkMatrix GraphMap????

    /**
     * o mapa traz um conjunto de aposentos do json,
     * sera que se podia guardalos num array e cada posição seria associada
     * a um vertice ?
     */
    private room[] roomList;


    public map(String title, int roomQuanity) {
        this.title = title;
        this.points = 100;
        this.roomList = new room[roomQuanity];
        //quando tivermos o grafo retificar o constructor se quiseres colocar aqui o grafo
    }

    /**
     *
     * este metodo poderia ser usado pra transferir o mapa
     * carregado do json pro grafo?
     *
     * mandas praqui a lista do que foi carregado como parametro
     * se nao me engano tinhas dito que ias carregar a info do json
     * pra uma lista?
     *
     * @return false if not loaded
     */
    public boolean loadToGraph(){
        return false;
    }

    /**
     * aqui poderias mandar o array de rooms
     * ir buscar o custo dos fantasmas a cada room
     * e ao adicionar o room, adicionar também as ligaçoes com
     * os custos dos fantasmas? ou seria melhor em metododos
     * separados?
     * @return false if not added
     */
    public boolean addRoomsToMap(room[] rooms){
        return false;
    }


}
