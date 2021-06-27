package com.icu.ctyk.other;

import java.util.Random;

/**
 * @author ctykwz on 2021-06-15 22:20
 */
public class Rand10 {

    /**
     * random(2)=[1,2] random(3) = 1,2,3 random(6) = 1,2,3,4,5,6
     * (random3-1)*2 + random2 = random(6) ; random(6)%random3 + 1
     * 现在有rand7 要求 random10
     * (randomN-1)*7 + random7 = random10 or (random10-1)*7+random7 = randomN
     * (random7-1)*7+random7 = random49
     *
     * @return val
     */
    public int rand10() {
        while (true) {
            int val = (rand7() - 1) * 7 + rand7();
            if (val <= 40) {
                return val % 10 + 1;
            }
        }
    }

    private int rand7() {
        return new Random(7).nextInt();
    }
}
