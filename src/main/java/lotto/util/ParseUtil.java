package lotto.util;

public class ParseUtil {

    private ParseUtil() {
    }

    public static int parseInt(String intValue) {
        try {
            int parsedInt = Integer.parseUnsignedInt(intValue);

            return parsedInt;
        }catch (NumberFormatException ignore) {
            throw new IllegalArgumentException("잘못된 숫자 형태 이거나 입력한 숫자가 너무 크거나 작아서 처리할 수 없습니다");
        }
    }
}
