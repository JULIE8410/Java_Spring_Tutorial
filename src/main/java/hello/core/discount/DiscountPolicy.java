package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return Amount to be discounted
     */
    int discount(Member member, int price);
}
