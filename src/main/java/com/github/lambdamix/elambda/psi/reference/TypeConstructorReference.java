package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.FindUtil;
import com.github.lambdamix.elambda.psi.TypeConstructor;
import com.github.lambdamix.elambda.psi.TypeDefinition;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TypeConstructorReference extends PsiReferenceBase<TypeConstructor>  {
    public TypeConstructorReference(@NotNull TypeConstructor element) {
        super(element, element.getCtrName().getTextRangeInParent());
    }

    private List<TypeDefinition> multiResolve() {
        return FindUtil.findTypeDefinitions(myElement.getContainingFile(), myElement.getName());
    }

    @Override
    public @Nullable TypeDefinition resolve() {
        List<TypeDefinition> resolveResults = multiResolve();
        return resolveResults.size() == 1 ? resolveResults.get(0) : null;
    }
}
