package Entities;

public class TheaterShow extends Show {

    String actorName;

    public TheaterShow(String id, String title, String theater, String date, String actorName) {
        super(id, title, theater, date);
        this.actorName = actorName;
    }

    public String getActorName() {

        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }


    public String toString() {
        return "Entities.TheaterShow{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", theater='" + theater + '\'' +
                ", date='" + date + '\'' +
                "actorName='" + actorName + '\'' +
                ", ClientList=" + ClientList +
                '}';
    }

    public String AsCsvLine(){
        return  ID + ";" + title + ";" + theater + ";" + date + ";" + actorName;
    }
}
