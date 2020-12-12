package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.DataConstructor;
import com.github.lambdamix.elambda.psi.FindUtil;
import com.github.lambdamix.elambda.psi.RemoteConstructorExpr;
import com.github.lambdamix.elambda.psi.impl.ELambdaPsiImplUtil;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RemoteConstructorExprReference extends PsiReferenceBase<RemoteConstructorExpr> {
    public RemoteConstructorExprReference(@NotNull RemoteConstructorExpr element) {
        super(element, ELambdaPsiImplUtil.rangeForReference(element, element.getCtrName()));
    }

    private List<DataConstructor> multiResolve() {
        String module = myElement.getRemoteCtr().getMod().getModName().getText();
        PsiFile moduleFile = myElement.getContainingFile().getContainingDirectory().findFile(module + ".elambda");
        return FindUtil.findDataConstructors(moduleFile, myElement.getName());
    }

    @Override
    public @Nullable DataConstructor resolve() {
        List<DataConstructor> resolveResults = multiResolve();
        return resolveResults.size() == 1 ? resolveResults.get(0) : null;
    }
}
