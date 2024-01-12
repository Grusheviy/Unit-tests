package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
//Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
//который обычно проверяет, доступен ли номер в отеле.
//Вам необходимо проверить правильность работы класса BookingService, который
//использует HotelService для бронирования номера, если он доступен.

class BookingServiceTest {

    @Test
    void HotelServiceMockTest(){
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(1)).thenReturn(false);

        Boolean result = bookingService.bookRoom(1);

        assertFalse(result);

    }
}