package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

@Test
    public void WeatherServiceMock(){
    WeatherService weatherService = mock(WeatherService.class);
    when(weatherService.getCurrentTemperature()).thenReturn(20);
    WeatherReporter weatherReporter = new WeatherReporter(weatherService);

    String result = weatherReporter.generateReport();

    assertThat(result).isEqualTo("Текущая температура: " + 20 +  " градусов.");
    }
}