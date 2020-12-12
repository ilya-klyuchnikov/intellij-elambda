// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.lambdamix.elambda.psi.reference.ModReference;

public interface Mod extends PsiElement {

  @NotNull
  PsiElement getLid();

  @NotNull String getName();

  @NotNull ModReference getReference();

  @NotNull
  PsiElement getModName();

}
