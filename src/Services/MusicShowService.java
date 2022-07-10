package Services;

import Entities.Client;
import Entities.MusicShow;

import java.util.ArrayList;

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
}
