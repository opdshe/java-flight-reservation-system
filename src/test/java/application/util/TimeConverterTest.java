package application.util;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TimeConverterTest {
    @Test
    void toLocalDateTime_테스트() {
        //given
        String dateTime = "2020-08-22 08:23";
        LocalDateTime expectLocalDateTime = LocalDateTime.of(2020, 8, 22, 8, 23);

        //when
        LocalDateTime localDateTime = TimeConverter.toLocalDateTime(dateTime);

        //then
        assertThat(expectLocalDateTime).isEqualTo(localDateTime);
    }
}