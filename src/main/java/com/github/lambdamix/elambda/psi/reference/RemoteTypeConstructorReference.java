package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.FindUtil;
import com.github.lambdamix.elambda.psi.RemoteTypeConstructor;
import com.github.lambdamix.elambda.psi.TypeConstructor;
import com.github.lambdamix.elambda.psi.TypeDefinition;
import com.github.lambdamix.elambda.psi.impl.ELambdaPsiImplUtil;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RemoteTypeConstructorReference extends PsiReferenceBase<RemoteTypeConstructor>  {
    public RemoteTypeConstructorReference(@NotNull RemoteTypeConstructor element) {
        super(element, ELambdaPsiImplUtil.rangeForReference(element, element.getCtrName()));
    }

    private List<TypeDefinition> multiResolve() {
        String remoteMod = myElement.getMod().getModName().getText();
        @Nullable PsiFile remoteFile = myElement.getContainingFile().getContainingDirectory().findFile(remoteMod + ".elambda");
        return FindUtil.findTypeDefinitions(remoteFile, myElement.getName());
    }

    @Override
    public @Nullable TypeDefinition resolve() {
        List<TypeDefinition> resolveResults = multiResolve();
        return resolveResults.size() == 1 ? resolveResults.get(0) : null;
    }
}
