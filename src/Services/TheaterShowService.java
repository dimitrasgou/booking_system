package Services;

import Entities.MusicShow;
import Entities.TheaterShow;

import java.util.ArrayList;

public class TheaterShowService extends EntityService {
    private ArrayList<TheaterShow> theaterShows;

    TheaterShowService() {
        loadTheaterShows();
    }

    public void loadTheaterShows() {
        theaterShows = storageService.getTheaterShows();
    }

    public void save()
    {
        storageService.saveTheaterShows(theaterShows);
    }
}
