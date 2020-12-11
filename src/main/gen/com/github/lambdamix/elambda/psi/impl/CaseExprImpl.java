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

public class CaseExprImpl extends ExprImpl implements CaseExpr {

  public CaseExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitCaseExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Branch> getBranchList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Branch.class);
  }

  @Override
  @NotNull
  public Expr getExpr() {
    return findNotNullChildByClass(Expr.class);
  }

  @Override
  @NotNull
  public PsiElement getCurlyLeft() {
    return findNotNullChildByType(CURLY_LEFT);
  }

  @Override
  @NotNull
  public PsiElement getCurlyRight() {
    return findNotNullChildByType(CURLY_RIGHT);
  }

  @Override
  @NotNull
  public PsiElement getKwCase() {
    return findNotNullChildByType(KW_CASE);
  }

  @Override
  @NotNull
  public PsiElement getKwOf() {
    return findNotNullChildByType(KW_OF);
  }

}
