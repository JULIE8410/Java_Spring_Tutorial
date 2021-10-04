package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP should receive 10% discount")
    void vio_o(){
        //given
        Member member = new Member(1L, "Julie", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("If not VIP, discount should not be allowed")
    void vio_x(){
        //given
        Member member = new Member(2L, "Orimi", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);

    }
}