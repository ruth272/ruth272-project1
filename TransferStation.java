import java.util.List;
import java.util.ArrayList;

public class TransferStation extends Station {
    public ArrayList<Station> otherStations;

    public TransferStation (String color, String name) {
        super(color,name);
        this.otherStations = new ArrayList<>();
    }

    public void addTransferStationNext(Station station) {
        if (station.prev == null) {
            station.prev = this;
        }
        this.otherStations.add(station);

    }
    
    public void addTransferStationPrev(Station station) {
        if (station.next == null) {
            station.next = this;
        }
        this.otherStations.add(station);

    }

    public String toString() {
        String prevName;
        String nextName;

        if (getPrev() == null) {
            prevName = "none";
        } else {
            prevName = getPrev().getName();
        }
        if (getNext() == null ) {
            nextName = "none";
        } else {
            nextName = getNext().getName();
        }
        String list = "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
        ", previous station: " + prevName + ", next station: " + nextName + "\n" +"\t" +"Transfers:" + " " + "\n";
        for(int i=0; i<otherStations.size(); i++){
            list += "\t" + otherStations.get(i).toString() + "\n";
        }
        return list;
    }

}
