package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.*;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class ReferenceInspection extends _ELambdaInspectionBase {

    @Override
    ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new Visitor(holder);
    }

    private static class Visitor extends ELambdaVisitor {
        private final @NotNull ProblemsHolder holder;

        private Visitor(@NotNull ProblemsHolder holder) {
            this.holder = holder;
        }

        @Override
        public void visitConstructorExpr(@NotNull ConstructorExpr o) {
            if (o.getReference().resolve() == null) {
                holder.registerProblem(o.getUid(), "Constructor '" + o.getName() + "' undefined" );
            }
        }
    }
}
