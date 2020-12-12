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
import com.github.lambdamix.elambda.psi.reference.ModReference;

public class ModImpl extends ASTWrapperPsiElement implements Mod {

  public ModImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitMod(this);
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

  @Override
  public @NotNull String getName() {
    return ELambdaPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull ModReference getReference() {
    return ELambdaPsiImplUtil.getReference(this);
  }

  @Override
  @NotNull
  public PsiElement getModName() {
    return getLid();
  }

}
