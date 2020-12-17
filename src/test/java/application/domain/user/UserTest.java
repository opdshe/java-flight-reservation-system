package application.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    void 입력받은_금액만큼_통장에_돈을_입금할_수_있다() {
        //given
        int amount = 100000;
        int currentBalance = User.getBalance();

        //when
        User.deposit(amount);

        //then
        assertThat(User.getBalance()).isEqualTo(currentBalance + amount);
    }
}