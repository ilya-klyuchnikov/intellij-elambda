// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.lambdamix.elambda.ELambdaTypes.*;
import com.github.lambdamix.elambda.psi.*;

public class VariableExprImpl extends ExprImpl implements VariableExpr {

  public VariableExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitVariableExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getLid() {
    return findNotNullChildByType(LID);
  }

}
