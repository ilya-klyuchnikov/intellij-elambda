package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.github.lambdamix.elambda.psi.RemoteVariableExpr;
import com.github.lambdamix.elambda.psi.VariableExpr;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class RemoteVariableInspection extends _ELambdaInspectionBase {
    @Override
    protected ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor() {
            @Override
            public void visitRemoteVariableExpr(@NotNull RemoteVariableExpr o) {
                if (o.getMod().getReference().resolve() == null) {
                    holder.registerProblem(o.getMod(), "Module '" + o.getMod().getName() + "' undefined");
                } else if (o.getReference().resolve() == null) {
                    // checking variable ONLY of module is defined
                    String fqn = o.getMod().getName() + "." + o.getName();
                    holder.registerProblem(o.getLid(), "Variable '" + fqn + "' undefined");
                }
            }
        };
    }
}
