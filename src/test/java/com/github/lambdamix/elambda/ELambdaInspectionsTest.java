package com.github.lambdamix.elambda;

import com.github.lambdamix.elambda.inspection._ELambdaInspectionBase;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.Ignore;

@Ignore
public class ELambdaInspectionsTest extends BasePlatformTestCase {
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/inspections";
    }

    private void testInspection(Class<? extends _ELambdaInspectionBase> inspection) {
        //noinspection unchecked
        myFixture.enableInspections(inspection);
        myFixture.configureByFile(getTestName(true) + ".elambda");
        myFixture.checkHighlighting();
    }
}
