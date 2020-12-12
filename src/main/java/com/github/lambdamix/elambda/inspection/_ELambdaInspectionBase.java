package com.github.lambdamix.elambda.inspection;

import com.github.lambdamix.elambda.psi.ELambdaFile;
import com.github.lambdamix.elambda.psi.ELambdaVisitor;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;

public abstract class _ELambdaInspectionBase extends LocalInspectionTool {
    private static final PsiElementVisitor DUMMY_VISITOR = new PsiElementVisitor() { };

    @Override
    public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, LocalInspectionToolSession session) {
        ELambdaFile file = ObjectUtils.tryCast(session.getFile(), ELambdaFile.class);
        return file != null ? buildELambdaVisitor(holder, session) : DUMMY_VISITOR;
    }

    abstract ELambdaVisitor buildELambdaVisitor(@NotNull ProblemsHolder holder, @NotNull LocalInspectionToolSession session);
}
