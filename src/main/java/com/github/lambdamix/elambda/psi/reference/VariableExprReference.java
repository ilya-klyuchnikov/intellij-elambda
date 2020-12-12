package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.PairProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VariableExprReference extends PsiReferenceBase<VariableExpr> {

    public VariableExprReference(@NotNull VariableExpr element) {
        super(element, element.getVarName().getTextRangeInParent());
    }

    private List<Variable> multiResolve() {
        Processor variableProcessor = new Processor(myElement.getName());
        PsiTreeUtil.treeWalkUp(getElement(), getElement().getContainingFile(), variableProcessor);
        List<Variable> variables = variableProcessor.variables;
        if (variables.isEmpty()) {
            variables = FindUtil.findTopLevelVariables(myElement.getContainingFile(), myElement.getName());
        }
        return variables;
    }

    @Override
    public @Nullable Variable resolve() {
        List<Variable> variables = multiResolve();
        if (variables.size() == 1) {
            return variables.get(0);
        }
        return null;
    }

    private static class Processor implements PairProcessor<PsiElement, PsiElement> {
        @NotNull
        final String name;
        @NotNull
        List<Variable> variables = Collections.emptyList();

        Processor(@NotNull String name) {
            this.name = name;
        }

        @Override
        public boolean process(PsiElement scope, PsiElement prev) {
            if (scope instanceof LambdaExpr) {
                LambdaExpr lambdaExpr = (LambdaExpr) scope;
                List<Variable> vars = lambdaExpr.getVariableList();
                variables = vars.stream().filter(v -> name.equals(v.getName())).collect(Collectors.toList());
            } else if (scope instanceof Branch) {
                Branch branch = (Branch) scope;
                List<Variable> vars = branch.getPattern().getVariableList();
                variables = vars.stream().filter(v -> name.equals(v.getName())).collect(Collectors.toList());
            }
            return variables.isEmpty();
        }
    }

}
