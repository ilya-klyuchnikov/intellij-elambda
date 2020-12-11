// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CaseExpr extends Expr {

  @NotNull
  List<Branch> getBranchList();

  @NotNull
  Expr getExpr();

  @NotNull
  PsiElement getCurlyLeft();

  @NotNull
  PsiElement getCurlyRight();

  @NotNull
  PsiElement getKwCase();

  @NotNull
  PsiElement getKwOf();

}
