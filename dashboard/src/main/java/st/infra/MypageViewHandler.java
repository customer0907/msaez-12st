package st.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import st.config.kafka.KafkaProcessor;
import st.domain.*;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setOrderId(orderPlaced.getId());
            mypage.setCustomerId(orderPlaced.getCustomerId());
            mypage.setItemId(orderPlaced.getItemId());
            mypage.setAddress(orderPlaced.getAddress());
            mypage.setQty(orderPlaced.getQty());
            mypage.setOrderStatus(ORDERPLACED);
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_1(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(
                deliveryCompleted.getOrderId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setDeliveryStatus(DELIVER);
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_2(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(
                orderCanceled.getId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setOrderStatus(ORDERCANCELED);
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryReturned_then_DELETE_1(
        @Payload DeliveryReturned deliveryReturned
    ) {
        try {
            if (!deliveryReturned.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mypageRepository.deleteById(deliveryReturned.getOrderId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
