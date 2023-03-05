package searchengine.services;

import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import searchengine.dto.statistics.DetailedStatisticsItem;
import searchengine.dto.statistics.TotalStatistics;
import searchengine.model.Site;
import searchengine.model.enums.Status;

import java.util.List;

@Component
public class StatisticsService {

    private SiteService siteService;
    private PageService pageService;
    private LemmaService lemmaService;

    @Autowired
    public StatisticsService(SiteService siteService, PageService pageService, LemmaService lemmaService) {
        this.siteService = siteService;
        this.pageService = pageService;
        this.lemmaService = lemmaService;
    }

    public Statistics getStatistics(){
        TotalStatistics total = getTotal();
        List<Site> siteList = siteService.findAllSites();
        DetailedStatisticsItem[] detailed = new DetailedStatisticsItem[siteList.size()];
        for (int i = 0; i < siteList.size(); i++) {
            detailed[i] = getDetailed(siteList.get(i));
        }
        return new Statistics(total, detailed);
    }

    private DetailedStatisticsItem getDetailed(Site site){
        String url = site.getUrl();
        String name = site.getName();
        Status status = site.getStatus();
        long statusTime = site.getStatusTime().getTime();
        String error = site.getLastError();
        long pages = pageService.countPagesOnSite(site.getId());
        long lemmas = lemmaService.countLemmasOnSite(site.getId());
        return new DetailedStatisticsItem(url, name, status, statusTime, error, pages, lemmas);
    }

    private TotalStatistics getTotal(){
        long siteNumber = siteService.countSites();
        long lemmaNumber = lemmaService.countlemmas();
        long pageNumber = pageService.countPages();
        boolean isIndexing = isIndexingInProcess();
        return new TotalStatistics(siteNumber, pageNumber, lemmaNumber, isIndexing);
    }

    public boolean isIndexingInProcess(){
        boolean isIndexing = false;
        for(Site s : siteService.findAllSites()){
            if(s.getStatus().equals(Status.INDEXING)){
                isIndexing = true;
                break;
            }
        }
        return isIndexing;
    }
}
