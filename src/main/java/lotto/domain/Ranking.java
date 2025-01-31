package lotto.domain;

import lotto.view.OutputView;

import java.util.Random;

public enum Ranking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, "");
    Ranking(int countOfMatch, int winningAmount, String message) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }
    private int countOfMatch;
    private int winningAmount;
    private String message;

    private static final int WINNG_MIN_COUNT=3;
    public static Ranking valueOf(int countOfMatch, boolean matchBonus){
        if (countOfMatch<WINNG_MIN_COUNT){
            return MISS;
        }
        if (SECOND.getCountOfMatch()==countOfMatch && matchBonus){
            return SECOND;
        }
        for (Ranking rank : values()) {
            if (rank.getCountOfMatch()==countOfMatch && rank!=SECOND){
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }


    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void printMessage(int count) {
        if (this!=MISS){
            OutputView.printSuccessMessage(message,count);
        }

    }
}
