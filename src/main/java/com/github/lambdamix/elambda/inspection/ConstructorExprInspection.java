package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ConstructorExpr;
import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class ConstructorExprInspection extends _ELambdaInspectionBase {
    @Override
    ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor() {
            @Override
            public void visitConstructorExpr(@NotNull ConstructorExpr o) {
                if (o.getReference().resolve() == null) {
                    holder.registerProblem(o.getUid(), "Constructor '" + o.getName() + "' undefined" );
                }
            }
        };
    }
}
