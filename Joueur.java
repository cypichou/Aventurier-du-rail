package ProjetAR;


public class Joueur {
    
    int wagons;
    int[] carteWagons;
    String missions; // va casser les couilles
    int gare;
    int point;

    Joueur(String Missions, int Wagons, int[] CarteWagons, int Gare, int Points){
        this.missions = Missions;
        this.wagons = Wagons;
        this.carteWagons = CarteWagons;
        this.gare = Gare;
        this.point = Points;
    }

    public String getMissions() {
        return missions;
    }

    public void setMissions (String Missions){
        this.missions = Missions;
    }

    public int getWagons (){
        return wagons;
    }

    public void setWagons(int Wagons){
        this.wagons = Wagons;
    }

    public int[] getCarte (){
        return carteWagons;
    }

    public int[] setCarte(int[] tab){
        return tab;
    }

    public int getGare(){
        return gare;
    }

    public void setGare(int Gare){
        this.gare = Gare;
    }

    public int getPoint (){
        return point;
    }

    public void setPoint(int Point){
        this.point = Point;
    }
}