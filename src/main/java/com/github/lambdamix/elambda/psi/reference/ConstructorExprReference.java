package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.ConstructorExpr;
import com.github.lambdamix.elambda.psi.DataConstructor;
import com.github.lambdamix.elambda.psi.FindUtil;
import com.github.lambdamix.elambda.psi.impl.ELambdaPsiImplUtil;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ConstructorExprReference extends PsiReferenceBase<ConstructorExpr> {
    public ConstructorExprReference(@NotNull ConstructorExpr element) {
        super(element, ELambdaPsiImplUtil.rangeForReference(element, element.getCtrName()));
    }

    private List<DataConstructor> multiResolve() {
        return FindUtil.findDataConstructors(getElement().getContainingFile(), getElement().getName());
    }

    @Override
    public @Nullable DataConstructor resolve() {
        List<DataConstructor> resolveResults = multiResolve();
        return resolveResults.size() == 1 ? resolveResults.get(0) : null;
    }
}
