package com.github.lambdamix.elambda.psi.impl;

import com.github.lambdamix.elambda.psi.*;
import com.github.lambdamix.elambda.psi.reference.RemoteTypeConstructorReference;
import com.github.lambdamix.elambda.psi.reference.TypeConstructorReference;
import com.github.lambdamix.elambda.psi.reference.TypeVariableReference;
import com.github.lambdamix.elambda.psi.reference.VariableExprReference;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class ELambdaPsiImplUtil {

    @NotNull
    public static String getName(ConstructorExpr element) {
        return element.getCtrName().getText();
    }

    @NotNull
    public static String getName(DataConstructor element) {
        return element.getCtrName().getText();
    }

    @NotNull
    public static String getName(Pattern element) {
        return element.getPatName().getText();
    }

    @NotNull
    public static String getName(RemoteConstructorExpr element) {
        return element.getRemoteCtr().getCtrName().getText();
    }

    @NotNull
    public static String getName(RemoteTypeConstructor element) {
        return element.getCtrName().getText();
    }

    @NotNull
    public static RemoteTypeConstructorReference getReference(RemoteTypeConstructor element) {
        return new RemoteTypeConstructorReference(element);
    }

    @NotNull
    public static String getName(RemoteVariableExpr element) {
        return element.getVarName().getText();
    }

    @NotNull
    public static String getName(TypeConstructor element) {
        return element.getCtrName().getText();
    }

    @NotNull
    public static TypeConstructorReference getReference(TypeConstructor element) {
        return new TypeConstructorReference(element);
    }

    @NotNull
    public static String getName(TypeDefinition element) {
        return element.getTypeName().getText();
    }

    @NotNull
    public static String getName(TypeVariable element) {
        return element.getVarName().getText();
    }

    @NotNull
    public static TypeVariableReference getReference(@NotNull TypeVariable element) {
        return new TypeVariableReference(element);
    }

    @NotNull
    public static String getName(TypeVariableDef element) {
        return element.getVarName().getText();
    }

    @NotNull
    public static String getName(Variable element) {
        return element.getVarName().getText();
    }


    @NotNull
    public static String getName(VariableExpr element) {
        return element.getVarName().getText();
    }

    @NotNull
    public static VariableExprReference getReference(@NotNull VariableExpr element) {
        return new VariableExprReference(element);
    }

    /// Utils
    @NotNull
    private static TextRange rangeInParent(@NotNull TextRange parent, @NotNull TextRange child) {
        int start = child.getStartOffset() - parent.getStartOffset();
        return TextRange.create(start, start + child.getLength());
    }

    public static TextRange rangeForReference(@NotNull PsiElement owner, @NotNull PsiElement ref) {
        return rangeInParent(owner.getTextRange(), ref.getTextRange());
    }
}
