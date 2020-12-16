package application.domain.place;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityRepositoryTest {
    @Test
    void 도시_저장소에_도시를_추가할_수_있다() {
        //given
        String name = "인천";
        City city = new City(name);

        //when
        CityRepository.save(city);

        //then
        City findByName = CityRepository.findByName(name);
        assertThat(findByName).isEqualTo(city);
    }
}