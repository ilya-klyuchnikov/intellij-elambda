// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TypeDefinition extends PsiElement {

  @NotNull
  List<DataConstructor> getDataConstructorList();

  @NotNull
  List<TypeVariableDef> getTypeVariableDefList();

  @NotNull
  PsiElement getKwData();

  @NotNull
  PsiElement getOpEq();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

  @NotNull
  PsiElement getSemi();

  @NotNull
  PsiElement getUid();

}
