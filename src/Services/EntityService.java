package Services;

/**
 * an abstract class , without instance in order to pass access to StorageService to subclasses
 * -ClientService,MusicShowService,TheaterShowService-
  */


public abstract class EntityService {
    protected StorageService storageService = new StorageService();
}
