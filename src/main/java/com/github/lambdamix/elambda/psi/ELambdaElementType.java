package com.github.lambdamix.elambda.psi;

import com.github.lambdamix.elambda.ELambdaLanguage;
import com.intellij.psi.tree.IElementType;

public class ELambdaElementType extends IElementType {
    public ELambdaElementType(String debug) {
        super(debug, ELambdaLanguage.INSTANCE);
    }
}
