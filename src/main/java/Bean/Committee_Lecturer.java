package Bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Committee_Lecturer implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

    @Id
    @ManyToOne
    @JoinColumn
    private Committee committee;

    @Id
    @ManyToOne
    @JoinColumn
    private Programme programme;
}
