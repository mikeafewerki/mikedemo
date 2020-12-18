package solr;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(collection = "Order")
public class Order {
    @Id
    @Indexed(name = "oid", type = "long")
    private Long orderid;
    @Indexed(name = "oname", type = "string")
    private String orderName;
    @Indexed(name = "odesc", type = "string")
    private String orderDescription;
    @Indexed(name = "pname", type = "string")
    private String productName;
    @Indexed(name = "cname", type = "string")
    private String customerName;
    @Indexed(name = "cmobile", type = "string")
    private String customerMobile;

}
