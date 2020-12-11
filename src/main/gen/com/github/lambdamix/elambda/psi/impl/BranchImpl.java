// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.lambdamix.elambda.ELambdaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.lambdamix.elambda.psi.*;

public class BranchImpl extends ASTWrapperPsiElement implements Branch {

  public BranchImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitBranch(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public Expr getExpr() {
    return findNotNullChildByClass(Expr.class);
  }

  @Override
  @NotNull
  public Pattern getPattern() {
    return findNotNullChildByClass(Pattern.class);
  }

  @Override
  @NotNull
  public PsiElement getArrow() {
    return findNotNullChildByType(ARROW);
  }

  @Override
  @NotNull
  public PsiElement getSemi() {
    return findNotNullChildByType(SEMI);
  }

}
