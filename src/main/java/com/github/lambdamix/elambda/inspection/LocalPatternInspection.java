package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.github.lambdamix.elambda.psi.LocalPattern;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class LocalPatternInspection extends _ELambdaInspectionBase {
    @Override
    ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor() {
            @Override
            public void visitLocalPattern(@NotNull LocalPattern o) {
                if (o.getReference().resolve() == null) {
                    holder.registerProblem(o.getPatName(), "Constructor '" + o.getName() + "' undefined" );
                }
            }
        };
    }
}
