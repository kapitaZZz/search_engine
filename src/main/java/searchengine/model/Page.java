package searchengine.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "page")
public class Page {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", insertable = false, updatable = false)
    private Site site;

    @ManyToMany
    @JoinTable(
            name = "index",
            joinColumns = @JoinColumn(name = "lemma_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id")
    )
    private Set<Lemma> lemmata;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int", name = "id")
    private int id;
    @NotNull
    @Column(columnDefinition = "int", name = "site_id")
    private int siteId;
    @NotNull
    @Column(columnDefinition = "varchar(255)", name = "path")
    private String path;
    @NotNull
    @Column(columnDefinition = "int", name = "code")
    private int code;
    @NotNull
    @Column(columnDefinition = "mediumtext", name = "content")
    private String content;
}
