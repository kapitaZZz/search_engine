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
@Setter
@Getter
@Entity
@Table(name = "lemma")
public class Lemma {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "index",
            joinColumns = @JoinColumn(name = "page_id"),
            inverseJoinColumns = @JoinColumn(name = "lemma_id")
    )
    private Set<Page> pages;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int", name = "id")
    private int id;
    @NotNull
    @Column(columnDefinition = "int", name = "site_id")
    private int siteId;
    @NotNull
    @Column(columnDefinition = "varchar(255)", name = "lemma")
    private String lemma;
    @NotNull
    @Column(columnDefinition = "int", name = "frequency")
    private int frequency;
}
