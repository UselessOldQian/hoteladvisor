package cn.itcast.hotel.mq;

import cn.itcast.hotel.constants.MqConstants;
import cn.itcast.hotel.service.IHotelService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Qian
 * @create 2022-01-167:38 下午
 */
@Component
public class HotelListener {

  @Autowired
  private IHotelService hotelService;

  @RabbitListener(queues = MqConstants.HOTEL_INSERT_QUEUE)
  public void listenerHotelInsertOrUpdate(Long id) {
    hotelService.saveById(id);
  }

  @RabbitListener(queues = MqConstants.HOTEL_DELETE_QUEUE)
  public void listenerHotelDeleteOrUpdate(Long id) {
    hotelService.deleteById(id);
  }
}
