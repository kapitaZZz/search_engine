package searchengine.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import searchengine.model.enums.Status;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequestMapping
@Getter
@Setter
@Entity
@Table(name = "site")
public class Site {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
    private List<Page> pages;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int", name = "id")
    private int id;
    @NotNull
    @Column(columnDefinition = "datetime", name = "status_time")
    private String statusTime;
    @Column(columnDefinition = "varchar(255)", name = "last_error")
    private String lastError;
    @NotNull
    @Column(columnDefinition = "varchar(255)", name = "url")
    private String url;
    @NotNull
    @Column(columnDefinition = "varchar(255)", name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('indexing', 'indexed', 'failed')", name = "status")
    private Status status;

}
