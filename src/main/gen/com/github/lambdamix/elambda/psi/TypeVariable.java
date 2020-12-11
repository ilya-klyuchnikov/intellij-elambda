// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.lambdamix.elambda.psi.reference.TypeVariableReference;

public interface TypeVariable extends Type {

  @NotNull
  PsiElement getLid();

  @NotNull String getName();

  @NotNull TypeVariableReference getReference();

  @NotNull
  PsiElement getVarName();

}
