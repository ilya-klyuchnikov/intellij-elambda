package com.github.lambdamix.elambda;

import com.intellij.lexer.FlexAdapter;

public class ELambdaLexerAdapter extends FlexAdapter {
    public ELambdaLexerAdapter() {
        super(new ELambdaLexer(null));
    }
}
