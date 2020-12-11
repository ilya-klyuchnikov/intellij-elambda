package com.github.lambdamix.elambda.psi;

import com.github.lambdamix.elambda.ELambdaFileType;
import com.github.lambdamix.elambda.ELambdaLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ELambdaFile extends PsiFileBase implements PsiNameIdentifierOwner {

    public ELambdaFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ELambdaLanguage.INSTANCE);
    }

    @Override
    @NotNull
    public FileType getFileType() {
        return ELambdaFileType.INSTANCE;
    }

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return this;
    }
}
