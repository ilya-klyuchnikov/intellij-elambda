package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.*;
import com.github.lambdamix.elambda.psi.impl.ELambdaPsiImplUtil;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModReference extends PsiReferenceBase<Mod> {
    public ModReference(@NotNull Mod element) {
        super(element, ELambdaPsiImplUtil.rangeForReference(element, element.getModName()));
    }

    @Override
    public @Nullable ELambdaFile resolve() {
        String module = myElement.getName();
        PsiFile ref = myElement.getContainingFile().getContainingDirectory().findFile(module + ".elambda");
        if (ref instanceof ELambdaFile) {
            return (ELambdaFile) ref;
        } else {
            return null;
        }
    }
}
