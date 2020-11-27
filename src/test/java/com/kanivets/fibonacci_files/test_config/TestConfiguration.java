package com.kanivets.fibonacci_files.test_config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestConfiguration {

    public static final List<String> testList = Stream.of("row 1", "row 2", "row 3", "row 4", "row 5", "row 6", "row 7", "row 8", "row 9", "row 10")
            .collect(Collectors.toList());
    public static final List<String> testListReverse = Stream.of("1 wor", "2 wor", "3 wor", "row 4", "5 wor", "row 6", "row 7", "8 wor", "row 9", "row 10")
            .collect(Collectors.toList());

    public static final String testInFilePath = "src/test/resources/source.txt";
    public static final String testOutFilePath = "src/test/resources/output.txt";

    private TestConfiguration() {
    }

}
