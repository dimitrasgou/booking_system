package Entities;

import java.util.ArrayList;

public class MusicShow extends Show {

    String singerName;

    public MusicShow(String id, String title, String theater, String date, String singerName) {
        super(id, title, theater, date);
        this.singerName = singerName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        singerName = singerName;
    }

    @Override
    public String toString() {
        return "Entities.MusicShow{"  +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", theater='" + theater + '\'' +
                ", date='" + date + '\'' +
                "SingerName='" + singerName + '\''+
                " ClientList=" + ClientList +
                '}';
    }

    public String AsCsvLine(){
        ArrayList<String> clientList = ClientList;
        return  ID + ";" + title + ";" + theater + ";" + date + ";" + singerName+";" + ClientList+";" ;
    }

}
