// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RemoteVariableExpr extends Expr {

  @NotNull
  Mod getMod();

  @NotNull
  PsiElement getDot();

  @NotNull
  PsiElement getLid();

  @NotNull String getName();

  @NotNull
  PsiElement getVarName();

}
