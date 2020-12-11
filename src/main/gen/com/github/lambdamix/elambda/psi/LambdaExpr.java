// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LambdaExpr extends Expr {

  @NotNull
  Expr getExpr();

  @NotNull
  List<Variable> getVariableList();

  @NotNull
  PsiElement getArrow();

  @NotNull
  PsiElement getKwLam();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

}
