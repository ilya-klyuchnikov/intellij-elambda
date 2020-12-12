// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Pattern extends PsiElement {

  @Nullable
  LocalPattern getLocalPattern();

  @Nullable
  RemotePattern getRemotePattern();

  @NotNull List<Variable> getVariableList();

}
