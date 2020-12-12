package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.github.lambdamix.elambda.psi.RemoteTypeConstructor;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class RemoteTypeConstructorInspection extends _ELambdaInspectionBase {
    @Override
    protected ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor() {
            @Override
            public void visitRemoteTypeConstructor(@NotNull RemoteTypeConstructor o) {
                if (o.getMod().getReference().resolve() == null) {
                    holder.registerProblem(o.getMod(), "Module '" + o.getMod().getName() + "' undefined");
                } else if (o.getReference().resolve() == null) {
                    String fqn = o.getMod().getName() + "." + o.getName();
                    holder.registerProblem(o.getCtrName(), "Type '" + fqn + "' undefined" );
                }
            }
        };
    }
}
