// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RemoteConstructorExpr extends Expr {

  @NotNull
  List<Expr> getExprList();

  @NotNull
  RemoteCtr getRemoteCtr();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

}
