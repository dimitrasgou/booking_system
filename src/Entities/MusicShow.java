package Entities;

import Entities.Show;

public class MusicShow extends Show {

    String SingerName;

    public MusicShow(String id, String title, String theater, String date, String singerName) {
        super(id, title, theater, date);
        SingerName = singerName;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    @Override
    public String toString() {
        return "Entities.MusicShow{" +
                "SingerName='" + SingerName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", theater='" + theater + '\'' +
                ", date='" + date + '\'' +
                ", ClientList=" + ClientList +
                '}';
    }
}
