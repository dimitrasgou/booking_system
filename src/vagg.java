import Entities.Client;
import Entities.MusicShow;
import Entities.TheaterShow;

public class vagg {

    public static void main(String[] args) {
        Client vaggelis = new Client("00001","Giannakosian","Evangelos","vaggelis@gmail.com","6978478690");
        Client dimitra = new Client("00002","Sgourdou","Dimitra","diimm@gmail.com","6978478690");
        System.out.println(vaggelis);
        TheaterShow show = new TheaterShow("000","Swan","Avaton","20-06-1992","Vaggelis Giannakosian");
        MusicShow sshow = new MusicShow("0040","Swan444","trtrg","20-06-1992","Dimsgordsk");
        System.out.println(show);
        show.bookTicket(vaggelis);
        show.bookTicket(vaggelis);
        sshow.bookTicket(vaggelis);
        sshow.bookTicket(vaggelis);
        System.out.println(show);
        System.out.println(sshow);

    }
}
