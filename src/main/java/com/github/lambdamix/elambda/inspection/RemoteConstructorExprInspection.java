package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.github.lambdamix.elambda.psi.RemoteConstructorExpr;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class RemoteConstructorExprInspection extends _ELambdaInspectionBase{
    @Override
    ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session) {
        return new ELambdaVisitor(){
            @Override
            public void visitRemoteConstructorExpr(@NotNull RemoteConstructorExpr o) {
                if (o.getMod().getReference().resolve() == null) {
                    holder.registerProblem(o.getMod(), "Module '" + o.getMod().getName() + "' undefined");
                } else if (o.getReference().resolve() == null) {
                    String fqn = o.getMod().getName() + "." + o.getName();
                    holder.registerProblem(o.getCtrName(), "Constructor '" + fqn + "' undefined" );
                }
            }
        };
    }
}
