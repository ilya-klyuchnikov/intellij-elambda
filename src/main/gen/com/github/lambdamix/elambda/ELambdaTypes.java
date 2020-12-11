// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.lambdamix.elambda.psi.ELambdaElementType;
import com.github.lambdamix.elambda.psi.ELambdaTokenType;
import com.github.lambdamix.elambda.psi.impl.*;

public interface ELambdaTypes {

  IElementType APP_EXPR = new ELambdaElementType("APP_EXPR");
  IElementType BINDING = new ELambdaElementType("BINDING");
  IElementType BRANCH = new ELambdaElementType("BRANCH");
  IElementType CASE_EXPR = new ELambdaElementType("CASE_EXPR");
  IElementType CONSTRUCTOR_EXPR = new ELambdaElementType("CONSTRUCTOR_EXPR");
  IElementType DATA_CONSTRUCTOR = new ELambdaElementType("DATA_CONSTRUCTOR");
  IElementType EXPR = new ELambdaElementType("EXPR");
  IElementType LAMBDA_EXPR = new ELambdaElementType("LAMBDA_EXPR");
  IElementType MOD = new ELambdaElementType("MOD");
  IElementType PATTERN = new ELambdaElementType("PATTERN");
  IElementType REMOTE_CONSTRUCTOR_EXPR = new ELambdaElementType("REMOTE_CONSTRUCTOR_EXPR");
  IElementType REMOTE_CTR = new ELambdaElementType("REMOTE_CTR");
  IElementType REMOTE_TYPE_CONSTRUCTOR = new ELambdaElementType("REMOTE_TYPE_CONSTRUCTOR");
  IElementType REMOTE_TYPE_ID = new ELambdaElementType("REMOTE_TYPE_ID");
  IElementType REMOTE_VARIABLE_EXPR = new ELambdaElementType("REMOTE_VARIABLE_EXPR");
  IElementType TYPE = new ELambdaElementType("TYPE");
  IElementType TYPE_CONSTRUCTOR = new ELambdaElementType("TYPE_CONSTRUCTOR");
  IElementType TYPE_DEFINITION = new ELambdaElementType("TYPE_DEFINITION");
  IElementType TYPE_VARIABLE = new ELambdaElementType("TYPE_VARIABLE");
  IElementType TYPE_VARIABLE_DEF = new ELambdaElementType("TYPE_VARIABLE_DEF");
  IElementType VARIABLE = new ELambdaElementType("VARIABLE");
  IElementType VARIABLE_EXPR = new ELambdaElementType("VARIABLE_EXPR");

  IElementType ARROW = new ELambdaTokenType("->");
  IElementType COMMA = new ELambdaTokenType(",");
  IElementType COMMENT = new ELambdaTokenType("COMMENT");
  IElementType CURLY_LEFT = new ELambdaTokenType("{");
  IElementType CURLY_RIGHT = new ELambdaTokenType("}");
  IElementType DOT = new ELambdaTokenType(".");
  IElementType KW_CASE = new ELambdaTokenType("case");
  IElementType KW_DATA = new ELambdaTokenType("data");
  IElementType KW_LAM = new ELambdaTokenType("lam");
  IElementType KW_OF = new ELambdaTokenType("of");
  IElementType KW_WHERE = new ELambdaTokenType("where");
  IElementType LID = new ELambdaTokenType("LID");
  IElementType OP_EQ = new ELambdaTokenType("=");
  IElementType OP_OR = new ELambdaTokenType("|");
  IElementType PAR_LEFT = new ELambdaTokenType("(");
  IElementType PAR_RIGHT = new ELambdaTokenType(")");
  IElementType SEMI = new ELambdaTokenType(";");
  IElementType UID = new ELambdaTokenType("UID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == APP_EXPR) {
        return new AppExprImpl(node);
      }
      else if (type == BINDING) {
        return new BindingImpl(node);
      }
      else if (type == BRANCH) {
        return new BranchImpl(node);
      }
      else if (type == CASE_EXPR) {
        return new CaseExprImpl(node);
      }
      else if (type == CONSTRUCTOR_EXPR) {
        return new ConstructorExprImpl(node);
      }
      else if (type == DATA_CONSTRUCTOR) {
        return new DataConstructorImpl(node);
      }
      else if (type == EXPR) {
        return new ExprImpl(node);
      }
      else if (type == LAMBDA_EXPR) {
        return new LambdaExprImpl(node);
      }
      else if (type == MOD) {
        return new ModImpl(node);
      }
      else if (type == PATTERN) {
        return new PatternImpl(node);
      }
      else if (type == REMOTE_CONSTRUCTOR_EXPR) {
        return new RemoteConstructorExprImpl(node);
      }
      else if (type == REMOTE_CTR) {
        return new RemoteCtrImpl(node);
      }
      else if (type == REMOTE_TYPE_CONSTRUCTOR) {
        return new RemoteTypeConstructorImpl(node);
      }
      else if (type == REMOTE_TYPE_ID) {
        return new RemoteTypeIdImpl(node);
      }
      else if (type == REMOTE_VARIABLE_EXPR) {
        return new RemoteVariableExprImpl(node);
      }
      else if (type == TYPE_CONSTRUCTOR) {
        return new TypeConstructorImpl(node);
      }
      else if (type == TYPE_DEFINITION) {
        return new TypeDefinitionImpl(node);
      }
      else if (type == TYPE_VARIABLE) {
        return new TypeVariableImpl(node);
      }
      else if (type == TYPE_VARIABLE_DEF) {
        return new TypeVariableDefImpl(node);
      }
      else if (type == VARIABLE) {
        return new VariableImpl(node);
      }
      else if (type == VARIABLE_EXPR) {
        return new VariableExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
