import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private String cause;
    private int squadSize;
    private static ArrayList<Squad> mInstances = new ArrayList<>();
    private List<Warriors> warriors = new ArrayList<>();
    private int memberId;

    public Squad(String squadName, String cause, int squadSize) {
        this.squadName = squadName;
        this.cause = cause;
        this.squadSize = squadSize;
        mInstances.add(this);
        this.memberId = mInstances.size();

    }

    public String getSquadName() {
        return squadName;
    }

    public String getCause() {
        return cause;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public List<Warriors> getWarriors() {
        return warriors;
    }

    public int getMemberId() {
        return memberId;
    }

    public void addWarriors(Warriors warrior) {
        if (warriors.size() < this.getSquadSize()) {
            warriors.add(warrior);
        }
    }

    //    public void addWarriors(Warriors warriors) {
//        if (warriors.length()<this.getSquadSize())
//    }
    public static ArrayList<Squad> getAllSquad() {
        return mInstances;
    }

    public static Squad search(int index) {
        return mInstances.get(index - 1);
    }
}
