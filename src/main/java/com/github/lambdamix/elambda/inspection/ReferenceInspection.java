package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.*;
import com.github.lambdamix.elambda.psi.reference.TypeConstructorReference;
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

        @Override
        public void visitLocalPattern(@NotNull LocalPattern o) {
            if (o.getReference().resolve() == null) {
                holder.registerProblem(o.getPatName(), "Constructor '" + o.getName() + "' undefined" );
            }
        }

        @Override
        public void visitRemoteConstructorExpr(@NotNull RemoteConstructorExpr o) {
            if (o.getMod().getReference().resolve() == null) {
                holder.registerProblem(o.getMod(), "Module '" + o.getMod().getName() + "' undefined");
            } else if (o.getReference().resolve() == null) {
                String fqn = o.getMod().getName() + "." + o.getName();
                holder.registerProblem(o.getCtrName(), "Constructor '" + fqn + "' undefined" );
            }
        }

        @Override
        public void visitRemotePattern(@NotNull RemotePattern o) {
            if (o.getMod().getReference().resolve() == null) {
                holder.registerProblem(o.getMod(), "Module '" + o.getMod().getName() + "' undefined");
            } else if (o.getReference().resolve() == null) {
                String fqn = o.getMod().getName() + "." + o.getName();
                holder.registerProblem(o.getPatName(), "Constructor '" + fqn + "' undefined" );
            }
        }

        @Override
        public void visitRemoteTypeConstructor(@NotNull RemoteTypeConstructor o) {
            if (o.getMod().getReference().resolve() == null) {
                holder.registerProblem(o.getMod(), "Module '" + o.getMod().getName() + "' undefined");
            } else if (o.getReference().resolve() == null) {
                String fqn = o.getMod().getName() + "." + o.getName();
                holder.registerProblem(o.getCtrName(), "Type '" + fqn + "' undefined" );
            }
        }

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

        @Override
        public void visitTypeConstructor(@NotNull TypeConstructor o) {
            TypeConstructorReference reference = o.getReference();
            if (reference.resolve() == null) {
                holder.registerProblem(o.getUid(), "Type '" + o.getName() + "' undefined" );
            }
        }

        @Override
        public void visitTypeVariable(@NotNull TypeVariable o) {
            if (o.getReference().resolve() == null) {
                holder.registerProblem(o.getLid(), "Type variable '" + o.getName() + "' undefined");
            }
        }

        @Override
        public void visitVariableExpr(@NotNull VariableExpr o) {
            if (o.getReference().resolve() == null) {
                holder.registerProblem(o.getLid(), "Variable '" + o.getName() + "' is unbound");
            }
        }
    }
}
