// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RemoteTypeConstructor extends Type {

  @NotNull
  RemoteTypeId getRemoteTypeId();

  @NotNull
  List<Type> getTypeList();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

}
