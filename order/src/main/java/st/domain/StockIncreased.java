package st.domain;

import java.util.*;
import lombok.*;
import st.domain.*;
import st.infra.AbstractEvent;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
}
