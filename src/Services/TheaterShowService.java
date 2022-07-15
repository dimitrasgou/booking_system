package Services;

import Entities.Client;
import Entities.TheaterShow;

import java.util.ArrayList;

/**
 * the services in order to manage the Theater Entity
 */
public class TheaterShowService extends EntityService {
    private ArrayList<TheaterShow> theaterShows;

    TheaterShowService() {
        loadTheaterShows();
    }


    public void loadTheaterShows() {
        theaterShows = storageService.getTheaterShows();
    }

    public void save() {
        storageService.saveTheaterShows(theaterShows);
    }

    public void insert(String id, String title, String venue, String date, String actor) {

        theaterShows.add(new TheaterShow(id, title, venue, date, actor));
    }

    public TheaterShow SearchTheaterShow(String code) {
        for (TheaterShow show : theaterShows ){
            if (show.getCode().equals(code)  ){
                System.out.println("Theater show found");
                return show;
            }
            else if(show== null)
                System.out.println("Theater show not found");
        }
        return null;
    }


    public void update(TheaterShow show, String title, String venue, String date, String actor)
    {
        show.setTitle(title);
        show.setTheater(venue);
        show.setDate(date);
        show.setActorName(actor);

    }

    public void remove(TheaterShow show){

        theaterShows.remove(show);
    }

    public void bookTicketForShow(TheaterShow theaterShow, Client client){
        theaterShow.bookTicket(client);
    }
    public void showtickets() {
        ;
        System.out.println("====Theater Show list====");
        int x = 1;
        for (Entities.TheaterShow show : theaterShows) {
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

    public void AllTheaterShows() {
        System.out.println("====Theater Show list====");
        int i=1;
        for (Entities.TheaterShow show : theaterShows) {
            System.out.println("==================== no" + i);
            System.out.println("ID number..........: " + show.getCode());
            System.out.println("Title..............: " + show.getTitle());
            System.out.println("Venue..............: " + show.getTheater());
            System.out.println("Date...............: " + show.getDate());
            System.out.println("Main Character.....: " + show.getActorName());
            System.out.println("Clients booked.....: " + show.getClientList());
            i++;
        }
    }

}
