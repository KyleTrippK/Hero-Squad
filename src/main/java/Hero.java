import java.util.ArrayList;

public class Hero {
    private String mName;
    private int mAge;
    private String mSuperPower;
    private String mWeakness;
    private static ArrayList<Hero> mInstances = new ArrayList<>();


    public Hero(String name,int age,String superPower,String weakness){
        this.mName=name;
        this.mAge=age;
        this.mSuperPower=superPower;
        this.mWeakness=weakness;
        this.mInstances.add(this);
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getSuperPower() {
        return mSuperPower;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public static void clearAllHero() {
        mInstances.clear();
    }

    public static ArrayList<Hero> getAll() {
        return mInstances;
    }
}