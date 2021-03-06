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
import com.github.lambdamix.elambda.psi.reference.RemoteConstructorExprReference;

public class RemoteConstructorExprImpl extends ExprImpl implements RemoteConstructorExpr {

  public RemoteConstructorExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitRemoteConstructorExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Expr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expr.class);
  }

  @Override
  @NotNull
  public RemoteCtr getRemoteCtr() {
    return findNotNullChildByClass(RemoteCtr.class);
  }

  @Override
  @NotNull
  public PsiElement getParLeft() {
    return findNotNullChildByType(PAR_LEFT);
  }

  @Override
  @NotNull
  public PsiElement getParRight() {
    return findNotNullChildByType(PAR_RIGHT);
  }

  @Override
  public @NotNull String getName() {
    return ELambdaPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull RemoteConstructorExprReference getReference() {
    return ELambdaPsiImplUtil.getReference(this);
  }

  @Override
  @NotNull
  public PsiElement getCtrName() {
    RemoteCtr p1 = getRemoteCtr();
    return p1.getUid();
  }

  @Override
  @NotNull
  public Mod getMod() {
    RemoteCtr p1 = getRemoteCtr();
    return p1.getMod();
  }

}
