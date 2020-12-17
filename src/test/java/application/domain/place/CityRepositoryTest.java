package application.domain.place;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityRepositoryTest {
    @AfterEach
    void clearUp() {
        CityRepository.deleteAll();
    }

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

    @Test
    void 도시_저장소에서_도시를_삭제할_수_있다() {
        //given
        String name = "인천";
        City city = new City(name);
        CityRepository.save(city);

        //when
        CityRepository.delete(city);
        boolean isExist = CityRepository.isExist(name);

        //then
        assertThat(isExist).isFalse();
    }
}