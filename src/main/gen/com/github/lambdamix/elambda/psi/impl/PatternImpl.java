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
import com.github.lambdamix.elambda.psi.reference.PatternReference;

public class PatternImpl extends ASTWrapperPsiElement implements Pattern {

  public PatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Variable> getVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Variable.class);
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
  @NotNull
  public PsiElement getUid() {
    return findNotNullChildByType(UID);
  }

  @Override
  public @NotNull String getName() {
    return ELambdaPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull PatternReference getReference() {
    return ELambdaPsiImplUtil.getReference(this);
  }

  @Override
  @NotNull
  public PsiElement getPatName() {
    return getUid();
  }

}
