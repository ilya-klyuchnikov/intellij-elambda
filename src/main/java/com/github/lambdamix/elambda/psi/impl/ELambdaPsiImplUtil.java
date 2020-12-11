package com.github.lambdamix.elambda.psi.impl;

import com.github.lambdamix.elambda.psi.*;
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
    public static String getName(RemoteVariableExpr element) {
        return element.getVarName().getText();
    }

    @NotNull
    public static String getName(TypeConstructor element) {
        return element.getCtrName().getText();
    }

    @NotNull
    public static String getName(TypeVariable element) {
        return element.getVarName().getText();
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
}
