import java.util.ArrayList;

public class Hero {
    private String mName;
    private int mAge;
    private String mSuperPower;
    private String mWeakness;
    private static ArrayList<Hero> mInstances = new ArrayList<>();


    public Hero(String name,int age,String superPower,String weakness){
        mName=name;
        mAge=age;
        mSuperPower=superPower;
        mWeakness=weakness;
        mInstances.add(this);
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

    public static ArrayList<Hero> getAll() {
        return mInstances;
    }
}