package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.FindUtil;
import com.github.lambdamix.elambda.psi.RemoteVariableExpr;
import com.github.lambdamix.elambda.psi.Variable;
import com.github.lambdamix.elambda.psi.impl.ELambdaPsiImplUtil;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RemoteVariableExprReference extends PsiReferenceBase<RemoteVariableExpr> {
    public RemoteVariableExprReference(@NotNull RemoteVariableExpr element) {
        super(element, ELambdaPsiImplUtil.rangeForReference(element, element.getVarName()));
    }

    private List<Variable> multiResolve() {
        String remoteMod = myElement.getMod().getModName().getText();
        @Nullable PsiFile remoteFile = myElement.getContainingFile().getContainingDirectory().findFile(remoteMod + ".elambda");
        return FindUtil.findTopLevelVariables(remoteFile, myElement.getName());
    }

    @Override
    public @Nullable Variable resolve() {
        List<Variable> variables = multiResolve();
        if (variables.size() == 1) {
            return variables.get(0);
        }
        return null;
    }
}
