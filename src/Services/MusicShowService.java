package Services;

import Entities.Client;
import Entities.MusicShow;

import java.util.ArrayList;

/**
 * the services in order to manage the Music Show Entity
 */
public class MusicShowService extends EntityService
{
    private ArrayList<MusicShow> musicShows;

    MusicShowService(){
        loadMusicShows();
    }

    public void loadMusicShows()
    {
        musicShows = storageService.getMusicShows();
    }

    public void save()
    {
        storageService.saveMusicShows(musicShows);
    }

    public void insert(String id, String title, String venue, String date, String singer) {

        musicShows.add(new MusicShow(id, title, venue, date, singer));
    }


    public MusicShow SearchMusicShow(String code) {
        for (MusicShow show : musicShows ){
            if (show.getCode().equals(code)){
                System.out.println("Music show found");
                return show;
            }
            else if (show==null)
                System.out.println("Music show not found");
        }
        return null;
    }


    public void update(MusicShow show, String title, String venue, String date, String singer)
    {
        show.setTitle(title);
        show.setTheater(venue);
        show.setDate(date);
        show.setSingerName(singer);

    }

    public void remove(MusicShow show){
        musicShows.remove(show);

    }

    public void bookTicketForShow(MusicShow musicShow, Client client){
        musicShow.bookTicket(client);
    }

    public void showtickets() {
        ;
        System.out.println("====Music Show list====");
        int x = 1;
        for (Entities.MusicShow show : musicShows) {
            System.out.println("==================== no" + x);
            System.out.println("ID number..........: " + show.getCode());
            int i;
            for (i = 0; i < show.getClientList().size(); i++) {
                System.out.println("Clients booked.....: " + show.getClientList());
            }
            System.out.println(i);
            x++;
        }
    }
    public void AllMusicShows() {
        System.out.println("====Music Show List====");
        int i=1;
        for (Entities.MusicShow show : musicShows) {
            System.out.println("  ==================== no" + i);
            System.out.println("ID number..........: " + show.getCode());
            System.out.println("Title..............: " + show.getTitle());
            System.out.println("Venue..............: " + show.getTheater());
            System.out.println("Date...............: " + show.getDate());
            System.out.println("Singer.............: " + show.getSingerName());
            System.out.println("Clients booked.....: " + show.getClientList());

            i++;
        }
    }
}
