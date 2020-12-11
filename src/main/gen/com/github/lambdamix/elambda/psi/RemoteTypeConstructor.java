// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.lambdamix.elambda.psi.reference.RemoteTypeConstructorReference;

public interface RemoteTypeConstructor extends Type {

  @NotNull
  RemoteTypeId getRemoteTypeId();

  @NotNull
  List<Type> getTypeList();

  @NotNull
  PsiElement getParLeft();

  @NotNull
  PsiElement getParRight();

  @NotNull String getName();

  @NotNull RemoteTypeConstructorReference getReference();

  @NotNull
  PsiElement getCtrName();

  @NotNull
  Mod getMod();

}
