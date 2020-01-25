package HauntedHouse.MapDefinitions;

import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;
import Structures.Network.NetworkInList;

/**
 * Map definition class
 * @author Jorge, Miguel
 */
public class Map {

    private String title;
    private int points;
    private NetworkInList networkMap;

    /**
     * o mapa traz um conjunto de aposentos do json,
     * sera que se podia guardalos num array e cada posição seria associada
     * a um vertice ?
     */
    private UnorderedListADT<Room> roomList;


    public Map(String title, int points) {
        this.title = title;
        this.points = points;
        this.roomList = new UnorderedArray();


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
     * aqui poderias mandar o array de Rooms
     * ir buscar o custo dos fantasmas a cada Room
     * e ao adicionar o Room, adicionar também as ligaçoes com
     * os custos dos fantasmas? ou seria melhor em metododos
     * separados?
     * @return false if not added
     */
    public boolean addRoomsToMap(Room[] Rooms){
        return false;
    }


}
