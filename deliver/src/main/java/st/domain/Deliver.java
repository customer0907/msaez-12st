package st.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import st.DeliverApplication;
import st.domain.DeliveryCompleted;
import st.domain.DeliveryReturned;

@Entity
@Table(name = "Deliver_table")
@Data
//<<< DDD / Aggregate Root
public class Deliver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String customerId;

    private String itemId;

    private Integer qty;

    private String address;

    private String status;

    public static DeliverRepository repository() {
        DeliverRepository deliverRepository = DeliverApplication.applicationContext.getBean(
            DeliverRepository.class
        );
        return deliverRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Deliver deliver = new Deliver();
        repository().save(deliver);

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(deliver);
        deliveryCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderPlaced.get???()).ifPresent(deliver->{
            
            deliver // do something
            repository().save(deliver);

            DeliveryCompleted deliveryCompleted = new DeliveryCompleted(deliver);
            deliveryCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Deliver deliver = new Deliver();
        repository().save(deliver);

        DeliveryReturned deliveryReturned = new DeliveryReturned(deliver);
        deliveryReturned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderCanceled.get???()).ifPresent(deliver->{
            
            deliver // do something
            repository().save(deliver);

            DeliveryReturned deliveryReturned = new DeliveryReturned(deliver);
            deliveryReturned.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
