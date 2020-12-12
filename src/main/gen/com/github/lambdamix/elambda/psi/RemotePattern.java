// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.lambdamix.elambda.psi.reference.RemotePatternReference;

public interface RemotePattern extends PsiElement {

  @NotNull
  RemoteCtr getRemoteCtr();

  @NotNull
  List<Variable> getVariableList();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

  @NotNull String getName();

  @NotNull RemotePatternReference getReference();

  @NotNull
  PsiElement getPatName();

  @NotNull
  Mod getMod();

}
