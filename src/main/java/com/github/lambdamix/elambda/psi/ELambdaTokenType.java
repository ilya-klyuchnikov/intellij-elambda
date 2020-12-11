package com.github.lambdamix.elambda.psi;

import com.github.lambdamix.elambda.ELambdaLanguage;
import com.intellij.psi.tree.IElementType;

public class ELambdaTokenType extends IElementType {
    public ELambdaTokenType(String debug) {
        super(debug, ELambdaLanguage.INSTANCE);
    }
}
