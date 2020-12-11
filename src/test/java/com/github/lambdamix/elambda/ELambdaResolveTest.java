package com.github.lambdamix.elambda;

import com.github.lambdamix.elambda.psi.*;
import com.github.lambdamix.elambda.psi.reference.RemoteTypeConstructorReference;
import com.github.lambdamix.elambda.psi.reference.TypeConstructorReference;
import com.github.lambdamix.elambda.psi.reference.TypeVariableReference;
import com.intellij.psi.PsiElement;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class ELambdaResolveTest extends BasePlatformTestCase {

    @Override
    protected String getTestDataPath() {
        return "src/test/testData/reference";
    }

    public void testRemoteTypeConstructor() {
        myFixture.configureByFiles(getFileName(), getFileNameAux());
        PsiElement id = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        RemoteTypeId remoteTypeId = (RemoteTypeId) id.getParent();
        RemoteTypeConstructor typeConstructor = (RemoteTypeConstructor) remoteTypeId.getParent();
        RemoteTypeConstructorReference reference = typeConstructor.getReference();
        TypeDefinition typeDefinition = reference.resolve();
        assertNotNull(typeDefinition);
        assertEquals(typeConstructor.getName(), typeDefinition.getName());
        assertEquals(getFileNameAux(), typeDefinition.getContainingFile().getName());
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
        return getTestName(true) + ".elambda";
    }

    private String getFileNameAux() {
        return getTestName(true) + "Aux.elambda";
    }
}
