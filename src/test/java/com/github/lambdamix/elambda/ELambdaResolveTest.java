package com.github.lambdamix.elambda;

import com.github.lambdamix.elambda.psi.*;
import com.github.lambdamix.elambda.psi.reference.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class ELambdaResolveTest extends BasePlatformTestCase {

    @Override
    protected String getTestDataPath() {
        return "src/test/testData/reference";
    }

    public void testRemoteTypeConstructor() {
        myFixture.configureByFiles(getFileName(), getFileNameAux());
        PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        RemoteTypeConstructor typeConstructor = PsiTreeUtil.getParentOfType(element, RemoteTypeConstructor.class);
        assertNotNull(typeConstructor);
        RemoteTypeConstructorReference reference = typeConstructor.getReference();
        TypeDefinition typeDefinition = reference.resolve();
        assertNotNull(typeDefinition);
        assertEquals(typeConstructor.getName(), typeDefinition.getName());
        assertEquals(getFileNameAux(), typeDefinition.getContainingFile().getName());
    }

    public void testRemoteVariableExpr() {
        myFixture.configureByFiles(getFileName(), getFileNameAux());
        PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        RemoteVariableExpr remoteVariableExpr = PsiTreeUtil.getParentOfType(element, RemoteVariableExpr.class);
        assertNotNull(remoteVariableExpr);
        RemoteVariableExprReference reference = remoteVariableExpr.getReference();
        Variable variable = reference.resolve();
        assertNotNull(variable);
        assertEquals(remoteVariableExpr.getName(), variable.getName());
        assertEquals(getFileNameAux(), variable.getContainingFile().getName());
    }

    public void testTypeConstructor() {
        myFixture.configureByFile(getFileName());
        PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        TypeConstructor typeConstructor = PsiTreeUtil.getParentOfType(element, TypeConstructor.class);
        assertNotNull(typeConstructor);
        TypeConstructorReference reference = typeConstructor.getReference();
        TypeDefinition typeDefinition = reference.resolve();
        assertNotNull(typeDefinition);
        assertEquals(typeConstructor.getName(), typeDefinition.getName());
    }

    public void testTypeVariable() {
        myFixture.configureByFile(getFileName());
        PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        TypeVariable typeVariable = PsiTreeUtil.getParentOfType(element, TypeVariable.class);
        assertNotNull(typeVariable);
        TypeVariableReference reference = typeVariable.getReference();
        TypeVariableDef typeVariableDef = reference.resolve();
        assertNotNull(typeVariableDef);
        assertEquals(typeVariable.getName(), typeVariableDef.getName());
    }

    public void testVariableExpr01() {
        doTestVariableExpr();
    }

    public void testVariableExpr02() {
        doTestVariableExpr();
    }

    public void testVariableExpr03() {
        doTestVariableExpr();
    }

    private void doTestVariableExpr() {
        myFixture.configureByFile(getFileName());
        PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        VariableExpr variableExpr = PsiTreeUtil.getParentOfType(element, VariableExpr.class);
        assertNotNull(variableExpr);
        VariableExprReference reference = variableExpr.getReference();
        Variable variable = reference.resolve();
        assertNotNull(variable);
        assertEquals(variableExpr.getName(), variable.getName());
    }

    private String getFileName() {
        return getTestName(true) + ".elambda";
    }

    private String getFileNameAux() {
        return getTestName(true) + "Aux.elambda";
    }
}
