package com.github.lambdamix.elambda;

import com.intellij.testFramework.ParsingTestCase;

public class ELambdaParsingTest extends ParsingTestCase {
    public ELambdaParsingTest() {
        super("", "elambda", true, new ELambdaParserDefinition());
    }

    public void testSimple() {
        doTest(true);
    }

    public void testErr01() {
        doTest(true);
    }

    public void testErr02() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData/parsing";
    }
}
