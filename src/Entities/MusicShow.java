package Entities;

public class MusicShow extends Show {

    String singerName;

    public MusicShow(String id, String title, String theater, String date, String singerName) {
        super(id, title, theater, date);
        singerName = singerName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        singerName = singerName;
    }

    @Override
    public String toString() {
        return "Entities.MusicShow{" +
                "SingerName='" + singerName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", theater='" + theater + '\'' +
                ", date='" + date + '\'' +
                ", ClientList=" + ClientList +
                '}';
    }

    public String AsCsvLine(){
        return  ID + ";" + title + ";" + theater + ";" + date + ";" + singerName;
    }

}
