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

public class TypeDefinitionImpl extends ASTWrapperPsiElement implements TypeDefinition {

  public TypeDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ELambdaVisitor visitor) {
    visitor.visitTypeDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ELambdaVisitor) accept((ELambdaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DataConstructor> getDataConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DataConstructor.class);
  }

  @Override
  @NotNull
  public List<TypeVariableDef> getTypeVariableDefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TypeVariableDef.class);
  }

  @Override
  @NotNull
  public PsiElement getKwData() {
    return findNotNullChildByType(KW_DATA);
  }

  @Override
  @NotNull
  public PsiElement getOpEq() {
    return findNotNullChildByType(OP_EQ);
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
  public PsiElement getSemi() {
    return findNotNullChildByType(SEMI);
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
  @NotNull
  public PsiElement getTypeName() {
    return getUid();
  }

}
