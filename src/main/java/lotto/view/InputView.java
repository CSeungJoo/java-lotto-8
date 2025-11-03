package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView implements AutoCloseable {

    public String getBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        String price = Console.readLine();

        System.out.println();
        return price;
    }

    public String getWinNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        String winNumber = Console.readLine();


        return winNumber;
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumber = Console.readLine();


        return bonusNumber;
    }

    @Override
    public void close() {
        Console.close();
    }
}
