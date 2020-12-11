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

public class ExprImpl extends ASTWrapperPsiElement implements Expr {

  public ExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Expr getExpr() {
    return findChildByClass(Expr.class);
  }

  @Override
  @Nullable
  public PsiElement getParLeft() {
    return findChildByType(PAR_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getParRight() {
    return findChildByType(PAR_RIGHT);
  }

}
