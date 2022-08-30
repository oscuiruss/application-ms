package news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private long id;

    private String title;


    private String text;


    private String author;


//    private Date createDate;
//
//
//    private Date updateDate;


    private String appId;
}
