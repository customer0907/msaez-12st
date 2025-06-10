package st.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import st.domain.*;
import st.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryReturned extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String customerId;
    private String itemId;
    private Integer qty;
    private String address;

    public DeliveryReturned(Deliver aggregate) {
        super(aggregate);
    }

    public DeliveryReturned() {
        super();
    }
}
//>>> DDD / Domain Event
