package st.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import st.domain.*;

@Component
public class DeliverHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Deliver>> {

    @Override
    public EntityModel<Deliver> process(EntityModel<Deliver> model) {
        return model;
    }
}
