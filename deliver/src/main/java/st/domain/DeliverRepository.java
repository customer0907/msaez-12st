package st.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import st.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "delivers", path = "delivers")
public interface DeliverRepository
    extends PagingAndSortingRepository<Deliver, Long> {}
