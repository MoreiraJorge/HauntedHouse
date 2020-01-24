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
     * Constructor for a room
     * @param roomName
     * @param numConnections
     */
    public Room(String roomName, int numConnections, int ghostCost) {
        this.roomName = roomName;
        this.connections = new UnorderedArray();
        this.ghostCost = ghostCost;
    }

    /**
     * If the room has a cost, it has a ghost
     * @return true if the room has a ghost
     */
    public boolean hasGhost(){
        if(ghostCost!=0){
            return true;
        }
        return false;
    }


}
