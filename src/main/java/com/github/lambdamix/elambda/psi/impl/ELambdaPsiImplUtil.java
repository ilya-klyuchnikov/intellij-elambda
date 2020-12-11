package com.github.lambdamix.elambda.psi.impl;

import com.github.lambdamix.elambda.psi.*;
import org.jetbrains.annotations.NotNull;

public class ELambdaPsiImplUtil {

    @NotNull
    public static String getName(ConstructorExpr element) {
        return element.getUid().getText();
    }

    @NotNull
    public static String getName(DataConstructor element) {
        return element.getUid().getText();
    }

    @NotNull
    public static String getName(Pattern element) {
        return element.getUid().getText();
    }

    @NotNull
    public static String getName(RemoteConstructorExpr element) {
        return element.getRemoteCtr().getUid().getText();
    }

    @NotNull
    public static String getName(RemoteTypeConstructor element) {
        return element.getRemoteTypeId().getUid().getText();
    }

    @NotNull
    public static String getName(RemoteVariableExpr element) {
        return element.getLid().getText();
    }

    @NotNull
    public static String getName(TypeConstructor element) {
        return element.getUid().getText();
    }

    @NotNull
    public static String getName(TypeVariable element) {
        return element.getLid().getText();
    }

    @NotNull
    public static String getName(TypeVariableDef element) {
        return element.getLid().getText();
    }

    @NotNull
    public static String getName(Variable element) {
        return element.getLid().getText();
    }


    @NotNull
    public static String getName(VariableExpr element) {
        return element.getLid().getText();
    }
}
