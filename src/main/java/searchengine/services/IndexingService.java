package searchengine.services;

import searchengine.model.Page;
import searchengine.model.Site;
import searchengine.model.enums.Status;

public interface IndexingService {

    void dropSiteAndPageData(Site site, Page page);
    boolean createSiteIndexing(Status status);
    void startParsing(Page page);
    boolean changeStatusByFinishParsing(Status status);
    boolean changeStatusToFailed(Status status);
}
