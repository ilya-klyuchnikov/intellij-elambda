package com.github.lambdamix.elambda;

import com.github.lambdamix.elambda.inspection.*;
import com.intellij.testFramework.TestDataPath;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

@TestDataPath("$CONTENT_ROOT/testData/inspections")
public class ELambdaInspectionsTest extends BasePlatformTestCase {
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/inspections";
    }

    public void testConstructorExprs() {
        testInspection(ConstructorExprInspection.class, false);
    }

    public void testRemoteTypeConstructors() {
        testInspection(RemoteTypeConstructorInspection.class, true);
    }

    public void testRemoteVariables() {
        testInspection(RemoteVariableInspection.class, true);
    }

    public void testTypeConstructor() {
        testInspection(TypeConstructorInspection.class, false);
    }

    public void testTypeVariables() {
        testInspection(TypeVariableInspection.class, false);
    }

    public void testVariables() {
        testInspection(VariableInspection.class, false);
    }

    private void testInspection(Class<? extends _ELambdaInspectionBase> inspection, boolean aux) {
        //noinspection unchecked
        myFixture.enableInspections(inspection);
        if (aux) {
            String mainFile = getTestName(true) + ".elambda";
            String auxFile = getTestName(true) + "Aux.elambda";
            myFixture.configureByFiles(mainFile, auxFile);
        } else {
            myFixture.configureByFile(getTestName(true) + ".elambda");
        }
        myFixture.checkHighlighting();
    }
}
