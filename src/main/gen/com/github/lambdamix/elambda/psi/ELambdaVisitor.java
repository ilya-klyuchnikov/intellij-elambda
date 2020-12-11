// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ELambdaVisitor extends PsiElementVisitor {

  public void visitAppExpr(@NotNull AppExpr o) {
    visitExpr(o);
  }

  public void visitBinding(@NotNull Binding o) {
    visitPsiElement(o);
  }

  public void visitBranch(@NotNull Branch o) {
    visitPsiElement(o);
  }

  public void visitCaseExpr(@NotNull CaseExpr o) {
    visitExpr(o);
  }

  public void visitConstructorExpr(@NotNull ConstructorExpr o) {
    visitExpr(o);
  }

  public void visitDataConstructor(@NotNull DataConstructor o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull Expr o) {
    visitPsiElement(o);
  }

  public void visitLambdaExpr(@NotNull LambdaExpr o) {
    visitExpr(o);
  }

  public void visitMod(@NotNull Mod o) {
    visitPsiElement(o);
  }

  public void visitPattern(@NotNull Pattern o) {
    visitPsiElement(o);
  }

  public void visitRemoteConstructorExpr(@NotNull RemoteConstructorExpr o) {
    visitExpr(o);
  }

  public void visitRemoteCtr(@NotNull RemoteCtr o) {
    visitPsiElement(o);
  }

  public void visitRemoteTypeConstructor(@NotNull RemoteTypeConstructor o) {
    visitType(o);
  }

  public void visitRemoteTypeId(@NotNull RemoteTypeId o) {
    visitPsiElement(o);
  }

  public void visitRemoteVariableExpr(@NotNull RemoteVariableExpr o) {
    visitExpr(o);
  }

  public void visitType(@NotNull Type o) {
    visitPsiElement(o);
  }

  public void visitTypeConstructor(@NotNull TypeConstructor o) {
    visitType(o);
  }

  public void visitTypeDefinition(@NotNull TypeDefinition o) {
    visitPsiElement(o);
  }

  public void visitTypeVariable(@NotNull TypeVariable o) {
    visitType(o);
  }

  public void visitTypeVariableDef(@NotNull TypeVariableDef o) {
    visitPsiElement(o);
  }

  public void visitVariable(@NotNull Variable o) {
    visitPsiElement(o);
  }

  public void visitVariableExpr(@NotNull VariableExpr o) {
    visitExpr(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
