import java.util.ArrayList;

public class Team {
    public ArrayList<Athlete> team;
    private ArrayList<Athlete> subs;
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
    public ArrayList<Athlete> getsubs(){
        return this.subs;
    }
    public void setsubs(ArrayList<Athlete> subs){
        this.subs = subs;
    }
    public void addsubs(Athlete athlete){
        this.subs.add(athlete);
    }
    public void removesubs(Athlete athlete){
        this.subs.remove(athlete);
    }
    public void printsubs(){
        for (int i = 0; i < this.subs.size(); i++) {
            Athlete athlete = this.subs.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
        }
    }
    public void subtite(Athlete onathlete, int off_pos){
        //gui in mind
        this.subs.add(this.team.get(off_pos));
        this.team.set(off_pos, onathlete);
    }
    public void subtite(Athlete onathlete, Athlete offathlete){
        //gui in mind
        this.subs.add(offathlete);
        this.team.set(this.team.indexOf(offathlete), onathlete);
    }
    public void subtite(int on_pos, int off_pos){
        //grouping with the select_subon() and select_suboff()
        System.out.println("Substituting " + this.team.get(off_pos).getName() + " with " + this.subs.get(on_pos).getName() + "comfirm? (y/n)");
        String comfirm = System.console().readLine();
        if (comfirm.equals("y")){
            this.subs.add(this.team.get(off_pos));
            this.team.set(off_pos, this.subs.get(on_pos));
        }
        else{
            System.out.println("Substitution cancelled");
        }   
        
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
    public int select_subon(){
        System.out.println("Select the athlete you want to sub on:");
        this.printsubs();
        int subon_pos = Integer.parseInt(System.console().readLine());
        return subon_pos;
    }
    public int select_suboff(){
        System.out.println("Select the athlete you want to sub off:");
        this.printteam();
        int suboff_pos = Integer.parseInt(System.console().readLine());
        return suboff_pos;
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
