import java.util.ArrayList;

public class Team {
    public ArrayList<Athlete> team;
    public int score;
    public String name;
    private int pos = 0;
    public Team(Team team) {
        this.name = team.name;
        this.team = team.team;
        this.score = team.score;
    }
    public Team(String name) {
        this.name = name;
        this.team = new ArrayList<Athlete>();
        this.score = 0;
    }
    public Team(String name, ArrayList<Athlete> team) {
        this.name = name;
        this.team = team;
        this.score = 0;

    }
    public int getpos(){
        return this.pos;
    }
    public void setpos(int pos){
        this.pos = pos;
    }
    public ArrayList<Athlete> getteam(){
        return this.team;
    }
    public void printteam(){
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
        }
    }
    public void setteam(ArrayList<Athlete> team){
        this.team = team;
    }
    public int getscore(){
        return this.score;
    }
    public void setscore(int score){
        this.score = score;
    }
    public String getname(){
        return this.name;
    }
    public void setname(String name){
        this.name = name;
    }
    public void addAthlete(Athlete athlete) {
        this.team.add(athlete);
    }
    public void removeAthlete(Athlete athlete) {
        this.team.remove(athlete);
    }
    public void addScore(int score) {
        this.score += score;
    }
    public int gettotalestpower(){
        int total = 0;
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            total += athlete.esimatepower();
        }
        return total;
    }
    public void displayTeam_cmd() {
        System.out.println("Team " + this.name + ":");
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
            System.out.println("Stamina: " + athlete.getStamina());
            System.out.println("Offence: " + athlete.getOffence());
            System.out.println("Defence: " + athlete.getDefence());
            System.out.println("Injury: " + athlete.getInjury());

        }
    }
    public int size() {
        return this.team.size();
    }

    
    
}
