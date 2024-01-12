package seminars.fourth.database;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
//Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет
// SQLзапрос и возвращает результат.
//Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
//выполнения запроса и обработки результатов.

class DataProcessorTest {
        DataProcessor dataProcessor;
        Database databaseMock;
        String testSQL;
        List<String> testData;

    @BeforeEach
    public void setUp(){
        testSQL = "Test SQL query";
        testData = List.of("1", "2", "3");
        databaseMock = mock(Database.class);
        dataProcessor = new DataProcessor(databaseMock);
        when(databaseMock.query(testSQL)).thenReturn(testData);
    }
    @Test
    public void queryMethodInvocedOnce(){
        dataProcessor.processData(testSQL);
        verify(databaseMock, times(1)).query(testSQL);
    }
    @Test
    public void processDataMethodTest(){
        List<String> result = dataProcessor.processData(testSQL);
        assertEquals(testData, result);
    }
}