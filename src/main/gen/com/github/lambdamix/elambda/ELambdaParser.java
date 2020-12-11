// This is a generated file. Not intended for manual editing.
package com.github.lambdamix.elambda;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.lambdamix.elambda.ELambdaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ELambdaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return elambdaFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(REMOTE_TYPE_CONSTRUCTOR, TYPE, TYPE_CONSTRUCTOR, TYPE_VARIABLE),
    create_token_set_(APP_EXPR, CASE_EXPR, CONSTRUCTOR_EXPR, EXPR,
      LAMBDA_EXPR, REMOTE_CONSTRUCTOR_EXPR, REMOTE_VARIABLE_EXPR, VARIABLE_EXPR),
  };

  /* ********************************************************** */
  // (remote_variable_expr | variable_expr | paren_expr) exprs_
  public static boolean app_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "app_expr")) return false;
    if (!nextTokenIs(b, "<app expr>", LID, PAR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APP_EXPR, "<app expr>");
    r = app_expr_0(b, l + 1);
    r = r && exprs_(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // remote_variable_expr | variable_expr | paren_expr
  private static boolean app_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "app_expr_0")) return false;
    boolean r;
    r = remote_variable_expr(b, l + 1);
    if (!r) r = variable_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // variable '=' expr ';'
  public static boolean binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && consumeToken(b, OP_EQ);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, BINDING, r);
    return r;
  }

  /* ********************************************************** */
  // pattern '->' expr ';'
  public static boolean branch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "branch")) return false;
    if (!nextTokenIs(b, UID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, BRANCH, r);
    return r;
  }

  /* ********************************************************** */
  // 'case' expr 'of' '{' branch* '}'
  public static boolean case_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_expr")) return false;
    if (!nextTokenIs(b, KW_CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CASE);
    r = r && expr(b, l + 1);
    r = r && consumeTokens(b, 0, KW_OF, CURLY_LEFT);
    r = r && case_expr_4(b, l + 1);
    r = r && consumeToken(b, CURLY_RIGHT);
    exit_section_(b, m, CASE_EXPR, r);
    return r;
  }

  // branch*
  private static boolean case_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_expr_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!branch(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_expr_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // UID exprs_
  public static boolean constructor_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_expr")) return false;
    if (!nextTokenIs(b, UID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UID);
    r = r && exprs_(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // UID top_types_
  public static boolean data_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_constructor")) return false;
    if (!nextTokenIs(b, UID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UID);
    r = r && top_types_(b, l + 1);
    exit_section_(b, m, DATA_CONSTRUCTOR, r);
    return r;
  }

  /* ********************************************************** */
  // data_constructor ('|' data_constructor)*
  static boolean data_constructors_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_constructors_")) return false;
    if (!nextTokenIs(b, UID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_constructor(b, l + 1);
    r = r && data_constructors__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('|' data_constructor)*
  private static boolean data_constructors__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_constructors__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!data_constructors__1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "data_constructors__1", c)) break;
    }
    return true;
  }

  // '|' data_constructor
  private static boolean data_constructors__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_constructors__1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_OR);
    r = r && data_constructor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (type_definition | binding | COMMENT)*
  static boolean elambdaFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elambdaFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elambdaFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elambdaFile", c)) break;
    }
    return true;
  }

  // type_definition | binding | COMMENT
  private static boolean elambdaFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elambdaFile_0")) return false;
    boolean r;
    r = type_definition(b, l + 1);
    if (!r) r = binding(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // remote_constructor_expr | app_expr | remote_variable_expr | variable_expr | constructor_expr | lambda_expr | case_expr | paren_expr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expr>");
    r = remote_constructor_expr(b, l + 1);
    if (!r) r = app_expr(b, l + 1);
    if (!r) r = remote_variable_expr(b, l + 1);
    if (!r) r = variable_expr(b, l + 1);
    if (!r) r = constructor_expr(b, l + 1);
    if (!r) r = lambda_expr(b, l + 1);
    if (!r) r = case_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '('  ')' |  '(' expr (',' expr)* ')'
  static boolean exprs_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprs_")) return false;
    if (!nextTokenIs(b, PAR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, PAR_LEFT, PAR_RIGHT);
    if (!r) r = exprs__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expr (',' expr)* ')'
  private static boolean exprs__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprs__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAR_LEFT);
    r = r && expr(b, l + 1);
    r = r && exprs__1_2(b, l + 1);
    r = r && consumeToken(b, PAR_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' expr)*
  private static boolean exprs__1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprs__1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exprs__1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exprs__1_2", c)) break;
    }
    return true;
  }

  // ',' expr
  private static boolean exprs__1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprs__1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'lam' variables_ '->' expr
  public static boolean lambda_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr")) return false;
    if (!nextTokenIs(b, KW_LAM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_LAM);
    r = r && variables_(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && expr(b, l + 1);
    exit_section_(b, m, LAMBDA_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // LID
  public static boolean mod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mod")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LID);
    exit_section_(b, m, MOD, r);
    return r;
  }

  /* ********************************************************** */
  // '(' expr ')'
  static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIs(b, PAR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAR_LEFT);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, PAR_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // UID variables_
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    if (!nextTokenIs(b, UID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UID);
    r = r && variables_(b, l + 1);
    exit_section_(b, m, PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // remote_ctr exprs_
  public static boolean remote_constructor_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_constructor_expr")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_ctr(b, l + 1);
    r = r && exprs_(b, l + 1);
    exit_section_(b, m, REMOTE_CONSTRUCTOR_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // mod '.' UID
  public static boolean remote_ctr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_ctr")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mod(b, l + 1);
    r = r && consumeTokens(b, 0, DOT, UID);
    exit_section_(b, m, REMOTE_CTR, r);
    return r;
  }

  /* ********************************************************** */
  // remote_type_id top_types_
  public static boolean remote_type_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_type_constructor")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_type_id(b, l + 1);
    r = r && top_types_(b, l + 1);
    exit_section_(b, m, REMOTE_TYPE_CONSTRUCTOR, r);
    return r;
  }

  /* ********************************************************** */
  // mod '.' UID
  public static boolean remote_type_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_type_id")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mod(b, l + 1);
    r = r && consumeTokens(b, 0, DOT, UID);
    exit_section_(b, m, REMOTE_TYPE_ID, r);
    return r;
  }

  /* ********************************************************** */
  // mod '.' LID
  public static boolean remote_variable_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_variable_expr")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mod(b, l + 1);
    r = r && consumeTokens(b, 0, DOT, LID);
    exit_section_(b, m, REMOTE_VARIABLE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // '('  ')' | '(' type (',' type)* ')'
  static boolean top_types_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_types_")) return false;
    if (!nextTokenIs(b, PAR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, PAR_LEFT, PAR_RIGHT);
    if (!r) r = top_types__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' type (',' type)* ')'
  private static boolean top_types__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_types__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAR_LEFT);
    r = r && type(b, l + 1);
    r = r && top_types__1_2(b, l + 1);
    r = r && consumeToken(b, PAR_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' type)*
  private static boolean top_types__1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_types__1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!top_types__1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "top_types__1_2", c)) break;
    }
    return true;
  }

  // ',' type
  private static boolean top_types__1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_types__1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // remote_type_constructor | type_constructor | type_variable
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, "<type>", LID, UID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE, "<type>");
    r = remote_type_constructor(b, l + 1);
    if (!r) r = type_constructor(b, l + 1);
    if (!r) r = type_variable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UID top_types_
  public static boolean type_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_constructor")) return false;
    if (!nextTokenIs(b, UID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UID);
    r = r && top_types_(b, l + 1);
    exit_section_(b, m, TYPE_CONSTRUCTOR, r);
    return r;
  }

  /* ********************************************************** */
  // 'data' UID type_variable_defs_ '=' data_constructors_ ';'
  public static boolean type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition")) return false;
    if (!nextTokenIs(b, KW_DATA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_DATA, UID);
    r = r && type_variable_defs_(b, l + 1);
    r = r && consumeToken(b, OP_EQ);
    r = r && data_constructors_(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, TYPE_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // LID
  public static boolean type_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_variable")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LID);
    exit_section_(b, m, TYPE_VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // LID
  public static boolean type_variable_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_variable_def")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LID);
    exit_section_(b, m, TYPE_VARIABLE_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // '(' ')' | '(' type_variable_def (','  type_variable_def)* ')'
  static boolean type_variable_defs_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_variable_defs_")) return false;
    if (!nextTokenIs(b, PAR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, PAR_LEFT, PAR_RIGHT);
    if (!r) r = type_variable_defs__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' type_variable_def (','  type_variable_def)* ')'
  private static boolean type_variable_defs__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_variable_defs__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAR_LEFT);
    r = r && type_variable_def(b, l + 1);
    r = r && type_variable_defs__1_2(b, l + 1);
    r = r && consumeToken(b, PAR_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (','  type_variable_def)*
  private static boolean type_variable_defs__1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_variable_defs__1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_variable_defs__1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_variable_defs__1_2", c)) break;
    }
    return true;
  }

  // ','  type_variable_def
  private static boolean type_variable_defs__1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_variable_defs__1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_variable_def(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LID
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LID);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // LID
  public static boolean variable_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_expr")) return false;
    if (!nextTokenIs(b, LID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LID);
    exit_section_(b, m, VARIABLE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // '('  ')' | '(' variable (',' variable)* ')'
  static boolean variables_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables_")) return false;
    if (!nextTokenIs(b, PAR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, PAR_LEFT, PAR_RIGHT);
    if (!r) r = variables__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' variable (',' variable)* ')'
  private static boolean variables__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAR_LEFT);
    r = r && variable(b, l + 1);
    r = r && variables__1_2(b, l + 1);
    r = r && consumeToken(b, PAR_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' variable)*
  private static boolean variables__1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables__1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variables__1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variables__1_2", c)) break;
    }
    return true;
  }

  // ',' variable
  private static boolean variables__1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables__1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
