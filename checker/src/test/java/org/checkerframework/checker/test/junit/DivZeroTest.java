package org.checkerframework.checker.test.junit;

import org.checkerframework.framework.test.CheckerFrameworkPerDirectoryTest;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.util.List;

/** JUnit tests for the DivZero Checker. */
public class DivZeroTest extends CheckerFrameworkPerDirectoryTest {

    /**
     * Create a DivZeroTest.
     *
     * @param testFiles the files containing test code, which will be type-checked
     */
    public DivZeroTest(List<File> testFiles) {
        super(
                testFiles,
                org.checkerframework.checker.divzero.DivZeroChecker.class,
                "divzero",
                "-nowarn");
    }

    @Parameters
    public static String[] getTestDirs() {
        return new String[] {"divzero"};
    }
}
