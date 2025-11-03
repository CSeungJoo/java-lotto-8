package lotto.view;

import lotto.dto.LottoResponse;

public final class OutputView {
    private OutputView() {
    }

    public static void printBoughtCount(int boughtCount) {
        System.out.println(boughtCount + "개를 구매했습니다.");
    }

    public static void printMyLotto(LottoResponse lottoResponse) {
        System.out.println(lottoResponse.getLottoNumber());
    }

    public static void printResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResult(int sameCount, boolean bonus, int reward, int winningCount) {
        System.out.print(sameCount + "개 일치");

        if (bonus) {
            System.out.print(", 보너스 볼 일치");
        }

        System.out.printf("(%,d원)", reward);

        System.out.println(" - " + winningCount + "개");
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.printf("총 수익률은 %.2f%%입니다.", rateOfReturn);
    }
}
