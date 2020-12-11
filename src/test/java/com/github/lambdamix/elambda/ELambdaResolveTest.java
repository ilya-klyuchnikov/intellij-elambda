package com.github.lambdamix.elambda;

import com.github.lambdamix.elambda.psi.TypeConstructor;
import com.github.lambdamix.elambda.psi.TypeDefinition;
import com.github.lambdamix.elambda.psi.TypeVariable;
import com.github.lambdamix.elambda.psi.TypeVariableDef;
import com.github.lambdamix.elambda.psi.reference.TypeConstructorReference;
import com.github.lambdamix.elambda.psi.reference.TypeVariableReference;
import com.intellij.psi.PsiElement;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class ELambdaResolveTest extends BasePlatformTestCase {

    @Override
    protected String getTestDataPath() {
        return "src/test/testData/reference";
    }

    public void testTypeConstructor() {
        myFixture.configureByFile(getFileName());
        PsiElement id = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        TypeConstructor typeConstructor = (TypeConstructor) id.getParent();
        TypeConstructorReference reference = typeConstructor.getReference();
        TypeDefinition typeDefinition = reference.resolve();
        assertNotNull(typeDefinition);
        assertEquals(typeConstructor.getName(), typeDefinition.getName());
    }

    public void testTypeVariable() {
        myFixture.configureByFile(getFileName());
        PsiElement id = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        TypeVariable typeVariable = (TypeVariable) id.getParent();
        TypeVariableReference reference = typeVariable.getReference();
        TypeVariableDef typeVariableDef = reference.resolve();
        assertNotNull(typeVariableDef);
        assertEquals(typeVariable.getName(), typeVariableDef.getName());
    }

    private String getFileName() {
        return getTestName(false) + ".elambda";
    }
}
