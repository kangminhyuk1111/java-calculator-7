package calculator.domain.input;

import calculator.domain.delimiter.Delimiters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";
    private static final int INDEX_PUSH_RIGHT = 1;

    private final Delimiters delimiters;

    public InputParser(final Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public Integer[] extractNumbersFromInput(final String input) {
        String delimiterRegex = getDelimiterPattern(input);

        String[] inputSplitCustomDelimiter = input
                .substring(input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR) + INDEX_PUSH_RIGHT)
                .split(delimiterRegex);

        return Arrays.stream(inputSplitCustomDelimiter)
                .map(this::parse)
                .toArray(Integer[]::new);
    }

    private String getDelimiterPattern(String input) {
        return delimiters.getAllDelimiters(input)
                .stream().filter(delimiter -> !delimiter.isBlank())
                .collect(Collectors.joining("|"));
    }

    private int parse(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}
