package hello;


import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import repository.SolrOrderRepository;
import solr.Order;

import java.util.List;

@RestController
@Log4j2
public class OrderController {

    @Autowired
    SolrOrderRepository solrOrderRepository;

    @Autowired
    Logger logger;

    @PostMapping("/order")
    public String createOrder(@RequestBody Order order) {
        String description = "Order Created";
        solrOrderRepository.save(order);
        logger.info("Order saved to db");
        return description;
    }

    @GetMapping("/order/{orderid}")
    public Order readOrder(@PathVariable Long orderid) {
        return solrOrderRepository.findByOrderid(orderid);
    }

    @PutMapping("/order")
    public String updateOrder(@RequestBody Order order) {
        String description = "Order Updated";
        solrOrderRepository.save(order);
        logger.info("Order updated to db");
        return description;
    }

    @DeleteMapping("/order/{orderid}")
    public String deleteOrder(@PathVariable Long orderid) {
        String description = "Order Deleted";
        solrOrderRepository.delete(solrOrderRepository.findByOrderid(orderid));
        logger.info("Order deleted");
        return description;
    }

    @GetMapping("/order/desc/{orderDesc}/{page}")
    public List<Order> findOrder(@PathVariable String orderDesc, @PathVariable int page) {
        return solrOrderRepository.findByOrderDescription(orderDesc, PageRequest.of(page, 2)).getContent();
    }

    @GetMapping("/order/search/{searchTerm}/{page}")
    public List<Order> cfindOrderBySearchTerm(@PathVariable String searchTerm, @PathVariable int page) {
        return solrOrderRepository.findByCustomerQuery(searchTerm, PageRequest.of(page, 2)).getContent();
    }
}
