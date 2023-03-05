package searchengine.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int", name = "id")
    private int id;
    @NotNull
    @Column(columnDefinition = "int", name = "lemma_id")
    private int lemmaId;
    @NotNull
    @Column(columnDefinition = "int", name = "page_id")
    private int pageId;
    @NotNull
    @Column(columnDefinition = "float", name = "rank")
    private float rank;
}
