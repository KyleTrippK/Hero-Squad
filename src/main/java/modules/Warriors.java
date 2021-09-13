package modules;

import java.util.ArrayList;


public class Warriors {
        private String hero;
        private int heroAge;
        private String powers;
        private String weakness;
        private int id;
        private int memberId;
        private static ArrayList<Warriors> mInstances = new  ArrayList<>();

        public Warriors(String hero, int heroAge, String powers, String weakness, int memberId){
            this.hero = hero;
            this.heroAge = heroAge;
            this.powers = powers;
            this.weakness = weakness;
            this.memberId = memberId;
            Squad squad = Squad.search(memberId);
            squad.addWarriors(this);
            this.id = mInstances.size();
            mInstances.add(this);
        }

        public static ArrayList<Warriors> getAll() {
            return mInstances;
        }
        public static void clearAllHero() {
            mInstances.clear();
        }
        public String getHero() {
            return hero;
        }
        public int getAge() {
            return heroAge;
        }
        public String getPowers() {
            return powers;
        }
        public String getWeakness(){
            return weakness;
        }

        public int getId(){
            return id;
        }
        public int getMemberId(){
            return memberId;
        }
        public static Warriors searchWarrior(int index){
            return mInstances.get(index-1);
        }
}
