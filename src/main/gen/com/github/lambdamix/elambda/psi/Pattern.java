// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.lambdamix.elambda.psi.reference.PatternReference;

public interface Pattern extends PsiElement {

  @NotNull
  List<Variable> getVariableList();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

  @NotNull
  PsiElement getUid();

  @NotNull String getName();

  @NotNull PatternReference getReference();

  @NotNull
  PsiElement getPatName();

}
