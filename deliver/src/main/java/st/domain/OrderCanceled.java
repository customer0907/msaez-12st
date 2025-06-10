package st.domain;

import java.util.*;
import lombok.*;
import st.domain.*;
import st.infra.AbstractEvent;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String itemId;
    private Integer qty;
    private String address;
}
