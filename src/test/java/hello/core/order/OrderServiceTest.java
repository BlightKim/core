package hello.core.order;

import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    MemberRepository memberRepository = new MemoryMemberRepository();
    @Test
    void createOrderTest() {
        Long memberId = 1L;
        Member member = new Member(memberId, "nameA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(memberId);

        Assertions.assertThat(findMember).isEqualTo(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
    }

}
