package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    private static final String OUTPUT_MESSAGE = "결과 : ";

    public OutputView() {
    }

    public void output(int result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
