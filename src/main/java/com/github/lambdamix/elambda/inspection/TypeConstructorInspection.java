package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.github.lambdamix.elambda.psi.TypeConstructor;
import com.github.lambdamix.elambda.psi.reference.TypeConstructorReference;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class TypeConstructorInspection extends _ELambdaInspectionBase {
    @Override
    protected ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor() {
            @Override
            public void visitTypeConstructor(@NotNull TypeConstructor o) {
                TypeConstructorReference reference = o.getReference();
                if (reference.resolve() == null) {
                    holder.registerProblem(o.getUid(), "Type '" + o.getName() + "' undefined" );
                }
            }
        };
    }
}
