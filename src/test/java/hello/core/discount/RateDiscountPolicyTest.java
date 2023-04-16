package hello.core.discount;


import static org.assertj.core.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private OrderService orderService = new OrderServiceImpl();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(memberVIP, 10000);
        int discount2 = discountPolicy.discount(memberVIP, 15000);
        // then
        assertThat(1000).isEqualTo(discount);
        assertThat(1500).isEqualTo(discount2);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 말아야 한다.")
    void vip_x () {
        // given
        Member memberBasic = new Member(2L, "memberBasic", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(memberBasic, 10000);
        // then
        assertThat(0).isEqualTo(discount);
    }
}
