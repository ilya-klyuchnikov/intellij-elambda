package com.github.lambdamix.elambda;

import com.intellij.lang.Language;

public class ELambdaLanguage extends Language {

    public static final ELambdaLanguage INSTANCE = new ELambdaLanguage();
    private ELambdaLanguage() {
        super("elambda");
    }
}
