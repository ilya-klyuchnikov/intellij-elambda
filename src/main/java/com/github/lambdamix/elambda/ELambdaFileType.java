package com.github.lambdamix.elambda;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ELambdaFileType extends LanguageFileType {
    public static final ELambdaFileType INSTANCE = new ELambdaFileType();

    private ELambdaFileType() {
        super(ELambdaLanguage.INSTANCE);
    }

    @Override
    public @NotNull String getName() {
        return "elambda";
    }

    @Override
    public @NotNull String getDescription() {
        return "Enriched lambda calculus";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "elambda";
    }

    @Override
    public @NotNull Icon getIcon() {
        return ELambdaIcons.FILE;
    }
}
