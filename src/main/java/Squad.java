public class Squad {
    private String mSquadName;
    private String mCause;


    public Squad(String squadName, String cause) {
        mSquadName = squadName;
        mCause = cause;


    }

    public String getName() {
        return mSquadName;
    }

    public String getCause() {
        return mCause;
    }
}
