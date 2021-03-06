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
  @Nullable
  public LocalPattern getLocalPattern() {
    return findChildByClass(LocalPattern.class);
  }

  @Override
  @Nullable
  public RemotePattern getRemotePattern() {
    return findChildByClass(RemotePattern.class);
  }

  @Override
  public @NotNull List<Variable> getVariableList() {
    return ELambdaPsiImplUtil.getVariableList(this);
  }

}
