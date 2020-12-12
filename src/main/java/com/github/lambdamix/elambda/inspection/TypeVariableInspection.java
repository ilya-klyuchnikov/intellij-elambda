package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.github.lambdamix.elambda.psi.TypeVariable;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class TypeVariableInspection extends _ELambdaInspectionBase {
    @Override
    protected ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor() {
            @Override
            public void visitTypeVariable(@NotNull TypeVariable o) {
                if (o.getReference().resolve() == null) {
                    holder.registerProblem(o.getLid(), "Type variable '" + o.getName() + "' undefined");
                }
            }
        };
    }
}
