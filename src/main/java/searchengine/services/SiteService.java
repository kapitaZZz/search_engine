package searchengine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import searchengine.dao.SiteDao;
import searchengine.repository.SiteRepository;

import java.util.List;
import java.util.Optional;

@Component
public class SiteService {

    private SiteDao siteDao;
    private SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteDao siteDao, SiteRepository siteRepository) {
        this.siteDao = siteDao;
        this.siteRepository = siteRepository;
    }

    public Optional<Site> findById(Integer id) {return siteRepository.findById(id);}

    public int saveSite(Site site) {
        return siteRepository.save(site).getId();
    }

    public void updateSite(Site site) {
        siteDao.update(site);
    }

    public void dropAndCreateTableSite() {
        siteDao.dropAndCreateTable();
    }

    public long countSites() {
        return siteRepository.count();
    }

    public Site findByName(String url) {return siteRepository.findByUrlLike(url);}

    public Site findByExactName(String url) {return siteRepository.findByUrlEquals(url);}

    public Boolean checkIfSiteExists(String name) {return siteDao.checkIfSiteExists(name);}

    public Boolean checkIfSiteExistsByExactMatch(String url) {return siteRepository.existsByUrl(url);}

    public void markAllSitesAsFailed(){ siteDao.markAllSitesAsFailed();}

    public void delete(Site site) {
        siteRepository.delete(site);}

    public List<Site> findAllSites() {
        return siteRepository.findAll();
    }
}
