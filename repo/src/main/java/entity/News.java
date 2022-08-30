package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ??
    private long id;
    @Column
    private String title;

    @Column
    private String text;

    @Column
    private String author;

    @Column
    @CreationTimestamp
    private Date createDate;

    @Column
    @CreationTimestamp
    private Date updateDate;

    @Column
    @UpdateTimestamp
    private String appId;

}
