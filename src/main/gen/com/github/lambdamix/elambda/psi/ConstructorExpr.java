// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ConstructorExpr extends Expr {

  @NotNull
  List<Expr> getExprList();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

  @NotNull
  PsiElement getUid();

  @NotNull String getName();

  @NotNull
  PsiElement getCtrName();

}
