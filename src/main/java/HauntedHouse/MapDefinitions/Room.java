package HauntedHouse.MapDefinitions;

import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;

/**
 * Room definition class
 * @author Jorge, Miguel
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class Room {

    protected String roomName;
    protected UnorderedListADT<String> connections;
    protected int ghostCost;

    /**
     * será que n era
     * melhor por por exemplo um boolean hasGhost?
     * so pra saber que o node tem fantasma, pode servir
     * pro gameplay a fazer a gui, mas isso pode-se deixar pra mais tarde.
     */

    /**
     *
     * @param roomName
     * @param numConnections
     */
    public Room(String roomName, int numConnections, int ghostCost) {
        this.roomName = roomName;
        this.connections = new UnorderedArray();
        this.ghostCost = ghostCost;
    }

}
